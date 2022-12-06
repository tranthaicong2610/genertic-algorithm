package com.example.project_backend.controller;

import com.example.project_backend.form.*;
import com.example.project_backend.model.Point;
import com.example.project_backend.service.IPointService;
import org.hibernate.internal.util.MathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RequestMapping("/point")
@RestController
public class PointController {

    @Autowired
    private IPointService iPointService;

    @GetMapping("")
    public List<Point> getAllPoint(){
        return iPointService.getPoints();
    }

    @PostMapping("/data")
    public List<PopulationInfo> pointClient(@RequestBody PointInfo pointInfo){
        List<GenerationInformationByDistance> populationDistance = new ArrayList<>(); // ban sao can dung de lai ghep va dot bien du lieu
        List<GenerationInformationByTime> populationTime = new ArrayList<>(); // ban sao can dung de lai ghep va dot bien du lieu
        List<PopulationInfo> populationInfos = new ArrayList<>(); // luu tru cac ma gen tot nhat cua cac the he
        List<Float> roundLet = new ArrayList<>(); // danh sach roundLet
        float totalFitness = 0 ; // tinh tong fitness
        String[] address = new String[]{"HANOI","HAIPHONG","NAMDINH","BINHDUONG","QUANGNGAI","HOCHIMINH","BINHTHUAN","THAIBINH","BACNINH","HAIDUONG"};
        List<Gen>  gennerationInit = new ArrayList<>();
        Random length = new Random();
        for(int i=0;i<100;i++)
        {
            while(true){
                int genLength = length.nextInt(17) +1 ;
                List<String> genRandom = new ArrayList<>();
                while(genLength < 3) {
                    genLength = length.nextInt(17) +1 ;
                }
                int ranIndex ;
                for(int k=0;k<genLength;k++){
                    ranIndex = length.nextInt(10);
                    genRandom.add(address[ranIndex]);
                }
                if(iPointService.checkGen(genRandom,pointInfo) == true){
                    gennerationInit.add(new Gen(genRandom));
                    break;
                }
//                System.out.println(i + " "+genRandom);

            }
        }

        // check 5 the he co thay doi ham muc tieu cua 5 gen tot nhat  hay khong
        Boolean check = true;

        // isCheck is true : Tinh toan khoang cach
        if(pointInfo.isSelect()){
            // the he thu nhat sinh ngau nhien
            List<GenerationInformationByDistance>  generation1 = new ArrayList<>();
            for (Gen gen : gennerationInit){
                generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(gen.getGen(),pointInfo)),gen.getGen()));
            }

            //luu 5 gen tot nhat tai cac the he
            List<TheBest5Distance> theBest5Distances = new ArrayList<>();


            // tao ra 100 the he tiep theo
            for(int k=0;k<100 ;k++){
                totalFitness = iPointService.totalFitnessDistance(generation1,pointInfo);

                //sap xep quan the theo thu tu tot nhat xuong kem nhat
                iPointService.orderByDistance(generation1);

                //tinh roundLet
                for (int i =0 ; i<generation1.size() ; i++  ){
                    float element = iPointService.fitnessCalculatorByDistance(iPointService.geneSlicing(generation1.get(i).getGens(),pointInfo))/totalFitness;

                    if (i>0){
                        roundLet.add(element + roundLet.get(i-1));
                    }
                    else{
                        roundLet.add(element);
                    }

                }

                // gan quan the cho mang moi de lai ghep va dot bien
                for (int i =0 ;i< generation1.size();i++){
                    populationDistance.add(generation1.get(i));
                }
                // danh sach luu 5 gens tot nhat

                List<GenerationInformationByDistance> listBest5 = new ArrayList<>();
                listBest5.add(generation1.get(0));
                listBest5.add(generation1.get(1));
                listBest5.add(generation1.get(2));
                listBest5.add(generation1.get(3));
                listBest5.add(generation1.get(4));
                theBest5Distances.add(new TheBest5Distance(
                        (List<GenerationInformationByDistance>) listBest5.get(0),
                        (List<GenerationInformationByDistance>) listBest5.get(1),
                        (List<GenerationInformationByDistance>) listBest5.get(2),
                        (List<GenerationInformationByDistance>) listBest5.get(3),
                        (List<GenerationInformationByDistance>) listBest5.get(4)));
                generation1.clear();
                generation1.add(listBest5.get(0));
                generation1.add(listBest5.get(1));
                generation1.add(listBest5.get(2));
                generation1.add(listBest5.get(3));
                generation1.add(listBest5.get(4));
//                listBest5.clear();

                populationInfos.add(new PopulationInfo(iPointService.genToConnectTwoPoint(iPointService.geneSlicing(generation1.get(0).getGens(),pointInfo) ) ,generation1.get(0).getDistance(),0,
                        iPointService.fitnessCalculatorByDistance(iPointService.geneSlicing(generation1.get(0).getGens(),pointInfo))));
                // lai ghep
                int loop =0;

                while(loop<85)
                {
                    loop++;
                    float selectFather = (float) Math.random();
                    float selectMother = (float) Math.random();
                    int indexFather =0  , indexMother =0  ;
                    boolean findFaher = false , findMother  = false;
                    for(int i=0 ; i<roundLet.size();i++){
                        if(!findFaher&& selectFather < roundLet.get(i)){
                            findFaher = true;
                            indexFather   = i ;
                        }
                        if (!findMother && selectMother < roundLet.get(i) ){
                            findMother = true;
                            indexMother = i ;

                        }
                        if( findFaher && findMother ) break;
                    }
                    List<String> createCrossover =  iPointService.crossover(populationDistance.get(indexFather).getGens(),populationDistance.get(indexMother).getGens(),pointInfo );
                    generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(createCrossover,pointInfo)),createCrossover));
                }
                // dot bien 10 % con lai
                loop = 0;
                while(loop < 10) {
                    loop++;
                    float selectFather = (float) Math.random();
                    int indexFather = 0 ;
                    boolean findFaher = false;
                    for(int i=0 ; i<roundLet.size();i++){
                        if(!findFaher&& selectFather < roundLet.get(i)){
                            findFaher = true;
                            indexFather   = i ;
                            break;
                        }

                    }
                    List<String> createMutation =  iPointService.mutation(populationDistance.get(indexFather).getGens(),pointInfo );
                    generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(createMutation,pointInfo)),createMutation));
                }
                if(theBest5Distances.size()>4){
                    check = theBest5Distances.get(theBest5Distances.size()-1).equals(theBest5Distances.size()-5);

                }
                if (!check) break;
                populationDistance.clear();
            }
            return populationInfos;
        }

        // Tinh toan theo thoi gian

        // the he thu nhat sinh ngau nhien
        List<GenerationInformationByTime>  generation1 = new ArrayList<>();

        for (Gen gen : gennerationInit){
            generation1.add(new GenerationInformationByTime(iPointService.calculateTime(iPointService.geneSlicing(gen.getGen(),pointInfo)),gen.getGen()));
        }

        //luu 5 gen tot nhat tai cac the he
        List<TheBest5Time> theBest5Times = new ArrayList<>();


        // tao ra 100 the he tiep theo
        for(int k=0;k<100 ;k++){
            totalFitness = iPointService.totalFitnessTime(generation1,pointInfo);

            //sap xep quan the theo thu tu tot nhat xuong kem nhat
            iPointService.orderByTime(generation1);

            //tinh roundLet
            for (int i =0 ; i<generation1.size() ; i++  ){
                float element = iPointService.fitnessCalculatorTime(iPointService.geneSlicing(generation1.get(i).getGens(),pointInfo))/totalFitness;

                if (i>0){
                    roundLet.add(element + roundLet.get(i-1));
                }
                else{
                    roundLet.add(element);
                }

            }

            // gan quan the cho mang moi de lai ghep va dot bien
            for (int i =0 ;i< generation1.size();i++){
                populationTime.add(generation1.get(i));
            }

            // danh sach luu 5 gens tot nhat

            List<GenerationInformationByTime> listBest5 = new ArrayList<>();
            listBest5.add(generation1.get(0));
            listBest5.add(generation1.get(1));
            listBest5.add(generation1.get(2));
            listBest5.add(generation1.get(3));
            listBest5.add(generation1.get(4));
            theBest5Times.add(new TheBest5Time(
                    (List<GenerationInformationByTime>) listBest5.get(0),
                    (List<GenerationInformationByTime>) listBest5.get(1),
                    (List<GenerationInformationByTime>) listBest5.get(2),
                    (List<GenerationInformationByTime>) listBest5.get(3),
                    (List<GenerationInformationByTime>) listBest5.get(4)));
            generation1.clear();
            generation1.add(listBest5.get(0));
            generation1.add(listBest5.get(1));
            generation1.add(listBest5.get(2));
            generation1.add(listBest5.get(3));
            generation1.add(listBest5.get(4));
            listBest5.clear();

            populationInfos.add(new PopulationInfo(iPointService.genToConnectTwoPoint(iPointService.geneSlicing(generation1.get(0).getGens(),pointInfo) ) ,0,generation1.get(0).getTime(),
                    iPointService.fitnessCalculatorTime(iPointService.geneSlicing(generation1.get(0).getGens(),pointInfo))));
            // lai ghep
            int loop =0;

            while(loop<85)
            {
                loop++;
                float selectFather = (float) Math.random();
                float selectMother = (float) Math.random();
                int indexFather =0  , indexMother =0  ;
                boolean findFaher = false , findMother  = false;
                for(int i=0 ; i<roundLet.size();i++){
                    if(!findFaher&& selectFather < roundLet.get(i)){
                        findFaher = true;
                        indexFather   = i ;
                    }
                    if (!findMother && selectMother < roundLet.get(i) ){
                        findMother = true;
                        indexMother = i ;

                    }
                    if( findFaher && findMother ) break;
                }
                List<String> createCrossover =  iPointService.crossover(populationTime.get(indexFather).getGens(),populationTime.get(indexMother).getGens(),pointInfo );
                generation1.add(new GenerationInformationByTime(iPointService.calculateTime(iPointService.geneSlicing(createCrossover,pointInfo)),createCrossover));
            }
            // dot bien 10 % con lai
            loop = 0;
            while(loop < 10) {
                loop++;
                float selectFather = (float) Math.random();
                int indexFather = 0 ;
                boolean findFaher = false;
                for(int i=0 ; i<roundLet.size();i++){
                    if(!findFaher&& selectFather < roundLet.get(i)){
                        findFaher = true;
                        indexFather   = i ;
                        break;
                    }

                }
                List<String> createMutation =  iPointService.mutation(populationTime.get(indexFather).getGens(),pointInfo );
                generation1.add(new GenerationInformationByTime(iPointService.calculateTime(iPointService.geneSlicing(createMutation,pointInfo)),createMutation));
            }
            if(theBest5Times.size()>4){
                check = theBest5Times.get(theBest5Times.size()-1).equals(theBest5Times.size()-5);

            }
            if (!check) break;
            populationTime.clear();
        }
        return populationInfos;
    }
}
