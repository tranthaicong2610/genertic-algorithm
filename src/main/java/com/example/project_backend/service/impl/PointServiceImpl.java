package com.example.project_backend.service.impl;

import com.example.project_backend.form.GenerationInformationByDistance;
import com.example.project_backend.form.GenerationInformationByTime;
import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import com.example.project_backend.repository.ConnectPointRepository;
import com.example.project_backend.repository.PointRepository;
import com.example.project_backend.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PointServiceImpl implements IPointService {

    private final PointRepository  pointRepository;
    private final ConnectPointRepository connectPointRepository;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository ,ConnectPointRepository connectPointRepository){
        this.pointRepository = pointRepository;
        this.connectPointRepository = connectPointRepository;
    }
    @Override
    public List<Point> getPoints() {

        return pointRepository.findAll();
    }


    /**
     *
     * @param father ma gen cha
     * @param mother ma gen me
     * @param pointInfo thong tin 3 diem can tim
     * @return ma gen sau khi duoc lai ghep
     */

    @Override
    public List<String> crossover(List<String> father, List<String> mother ,PointInfo pointInfo) {
        List<String> childIndividual ;
        Random generatorFather = new Random();
        Random generatorMother = new Random();
        int pointFather=0 ,pointMother =0;
        childIndividual = new ArrayList<>();
        while(true){
             pointFather = generatorFather.nextInt(father.size()-1);
             pointMother = generatorMother.nextInt(mother.size()-1);

            childIndividual.addAll(father.subList(0,pointFather));
            childIndividual.addAll(mother.subList(pointMother,mother.size()));
            if(checkGen(childIndividual , pointInfo)) {
                break;
            }
            childIndividual.clear();
        }

        return childIndividual;
    }

    /**
     * ham co nhiem vu tao ca the con dot bien bang cach tim kiem 1 vi tri bat ky sau do dot bien no
     * @param father ca the cha
     * @param pointInfo cac thanh pho lay tu clien chuyen ve
     * @return tra ve ca the con dot bien
     */
    @Override
    public List<String> mutation(List<String> father,PointInfo pointInfo) {
        List<String> cityNames = this.pointRepository.getNameCity();
        List<String> childIndividual ;
        while(true){
            childIndividual = new ArrayList<>();
            for(String val : father) {
                childIndividual.add(val);
            }
            // vi tri dot bien
            int mutationPoint =  (int)Math.round(Math.random()*(father.size()-1));

            // gia tri dot bien
            String mutationValue = cityNames.get((int)Math.round(Math.random()*9));

            // cap nhat gen dot bien
            childIndividual.set(mutationPoint,mutationValue);

            // kiem tra gen thoa man dieu kien gen t/m va con khac cha
            if(checkGen(childIndividual , pointInfo) && childIndividual.equals(father)) {
                break;
            }
        }
        return childIndividual;
    }



    /**
     * ham check sự phù hợp của gen đc tạo ra
     * kiểm tra xem có 2 giá trị trùng sát nhau
     * kiểm tra có tồn tại 3 điểm trong gen ko
     *
     * @param gens
     * @param pointInfo
     * @return
     */

    static Boolean checkGen(List<String> gens ,PointInfo pointInfo){
        // kiem tra xem co 2 gia tri trung gan nhau
        for(int i=0;i < gens.size()-1 ;i++){
            if(gens.get(i).equals(gens.get(i+1)) ){
                return false;
            }
        }

        // kiem tra kich co
        if(gens.size() < 3) return false;
        // kiem tra xem ma gen da di qua 3 diem chua
        if(
            !gens.contains(pointInfo.getPoint1())  ||
            !gens.contains(pointInfo.getPoint1()) ||
            !gens.contains(pointInfo.getPoint1())
        ){
            return false;
        }

        // qua het cac dieu kien
        return true;
    }


    /**
     * Tinh quang duong phai di chuyen
     * @param gens duong di qua 3 diem
     * @return khoang cach cua chung
     */
    @Override
    public float calculateDistance(List<String> gens) {
        float distancePointTotal  = 0;
        for (int i = 0; i < gens.size()-1; i++) {
            float distanceTwoPoint =  (this.connectPointRepository.getDistance(gens.get(i+1),gens.get(i)) != null)
                    ? this.connectPointRepository.getDistance(gens.get(i+1),gens.get(i))
                    : this.connectPointRepository.getDistance(gens.get(i),gens.get(i+1));
            distancePointTotal +=  distanceTwoPoint;
        }
        return distancePointTotal == 0  ? 100000 : distancePointTotal;
    }

    /**
     * Tinh thoi gian  phai di chuyen
     * @param gens duong di qua 3 diem
     * @return thoi gian cua chung
     */
    @Override
    public float calculateTime(List<String> gens) {
        float timePointTotal  = 0;
        for (int i = 0; i < gens.size()-1; i++) {
            float distanceTwoPoint =  (this.connectPointRepository.getTime(gens.get(i+1),gens.get(i)) != null)
                    ? this.connectPointRepository.getTime(gens.get(i+1),gens.get(i))
                    : this.connectPointRepository.getTime(gens.get(i),gens.get(i+1));
            timePointTotal +=  distanceTwoPoint;
        }
        return timePointTotal;
    }

    /**
     *
     * @param gens duong di giua 3 diem
     * @return tra ve fitness cua ca the theo khoang cach
     */

    public float fitnessCalculatorByDistance(List<String> gens){
        return 1/calculateDistance(gens);
    }

    /**
     *
     * @param gens duong di giua 3 diem
     * @return tra ve fitness cua ca the theo thoi gian
     */

    public float fitnessCalculatorTime(List<String> gens){
        return 1/calculateTime(gens);
    }

    /**
     * ham lay cat ra doan chua 3 diem can xet
     * @param gens doan ma gen
     * @param pointInfo cac diem di qua nguoi dung muon
     * @return tra ve doan ma co chua 3 diem can xet
     */

    @Override
    public List<String> geneSlicing(List<String> gens, PointInfo pointInfo){
        int indexPoint1 = gens.indexOf(pointInfo.getPoint1());
        int indexPoint2 = gens.indexOf(pointInfo.getPoint2());
        int indexPoint3 = gens.indexOf(pointInfo.getPoint3());
        int pointStart = Math.min(indexPoint1,Math.min(indexPoint2,indexPoint3));
        int pointEnd = Math.max(indexPoint1,Math.max(indexPoint2,indexPoint3));
        List<String> ok = new ArrayList<>();
        if(indexPoint1 < 0 || indexPoint2 < 0 || indexPoint3 < 0) return ok;
        return gens.subList(pointStart,pointEnd+1);
    }

    /**
     *
     * @param list danh sach cac thong tin gen va distance  trong quan the
     * @return tra ve 1 quan the dc sap xep theo khoang cach tang dan  dan
     */

    public void orderByDistance(List<GenerationInformationByDistance> list){
        Collections.sort(list, new Comparator<GenerationInformationByDistance>() {
            @Override
            public int compare(GenerationInformationByDistance o1, GenerationInformationByDistance o2) {
                if (o1.getDistance() == o2.getDistance()) return 0;
                if (o1.getDistance() > o2.getDistance()) return 1;
                return -1;
            }
        });
    }

    /**
     *
     * @param list danh sach cac thong tin gen va time  trong quan the
     * @return tra ve 1 quan the dc sap xep theo thoi gian tang dan dan
     */

    public List<GenerationInformationByTime> orderByTime(List<GenerationInformationByTime> list){
        Collections.sort(list, new Comparator<GenerationInformationByTime>() {
            @Override
            public int compare(GenerationInformationByTime o1, GenerationInformationByTime o2) {
                if(o1.getTime() == o2.getTime()) return 0;
                if (o1.getTime() > o2.getTime()) return 1;
                return -1;
            }
        });
        return list;
    }

    /**
     * ham tinh tong khoang cach cua 1 quan  the
     * @param list danh sach thong tin quan the gom gen va khoang cach
     * @return tra ve tong khoang cach cua 1 quan the
     */
    public float distanceTotal(List<GenerationInformationByDistance> list){
        float sum = 0;
        for(GenerationInformationByDistance generationInformationByDistance : list){
            sum += generationInformationByDistance.getDistance();
        }
        return sum;
    }


    /**
     * ham tinh tong thoi gian cua 1 the he
     * @param list danh sach thong tin quan the gom gen va thoi gian
     * @return tra ve tong thoi gian cua 1 quan the
     */
    public float timeTotal(List<GenerationInformationByTime> list){
        float sum =0;
        for(GenerationInformationByTime generationInformationByTime : list){
            sum += generationInformationByTime.getTime();
        }
        return sum;
    }

    /**
     * ham tinh tong fitness
     * @param list danh sach quan the
     * @return tra ve tong fitness
     */


    @Override
    public float totalFitnessDistance(List<GenerationInformationByDistance> list ,PointInfo pointInfo) {
        float sumFitness = 0;
        for (GenerationInformationByDistance gen : list){
            sumFitness += (fitnessCalculatorByDistance(this.geneSlicing(gen.getGens(),pointInfo)));
        }
        return sumFitness;
    }

//    float roundLet(){
//
//    }


    public static void main(String[] args) {
//        int i=0;
//        while(i<10){
//            System.out.println((int)Math.round(Math.random()*2));
//            i++;
//        }
//        PointInfo a = new PointInfo("1","1","1");
//        PointInfo b = new PointInfo("1","1","1");
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
        List<String> arr = new ArrayList<>();
        arr.add("ok1");
        arr.add("ok2");
        arr.add("ok1");
        arr.add("ok1");
        arr.add("ok3");
        arr.add("ok2");
        arr.add("ok3");
        int pointStart = arr.indexOf("ok1");
        int pointEnd = arr.indexOf("ok3");
        System.out.println(arr.indexOf("ok1"));
        System.out.println(arr.indexOf("ok3"));
        System.out.println(arr.subList(pointStart,pointEnd+1));
//        String ok ="tran thai cong";
//        System.out.println(ok.substring(5,9));
    }



}
