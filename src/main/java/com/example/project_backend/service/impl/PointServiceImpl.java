package com.example.project_backend.service.impl;

import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import com.example.project_backend.repository.PointRepository;
import com.example.project_backend.service.IPointService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointServiceImpl implements IPointService {

    private final PointRepository  pointRepository;
    @Autowired
    public PointServiceImpl(PointRepository pointRepository){
        this.pointRepository = pointRepository;
    }
    @Override
    public List<Point> getPoints() {

        return pointRepository.findAll();
    }


    /**
     * random chi lay 0 va 1 va loai 1 vi co su cong bang hon khi 1 chiem den khoang vung 1
     * @param father ca the cha ung voi 0
     * @param mother ca the me ung voi 2
     * @return tra ve ca the con
     */

    @Override
    public List<String> crossover(List<String> father, List<String> mother) {
        List<String> childIndividual = new ArrayList<>();
        double a ;
        int selectFatherOrMother  ;
        for(int i = 0 ; i < father.size() ; i++){
            a = Math.random();
            selectFatherOrMother = (int) Math.round(a*2);
            while(selectFatherOrMother ==1){
                a =Math.random();
                selectFatherOrMother = (int) Math.round(a*2);
            }
            String s = (selectFatherOrMother == 0) ?  father.get(i) :  mother.get(i);
            childIndividual.add(s);
        }
        return childIndividual;
    }

    /**
     *
     * @return tra ve ca the con dot bien
     */
    @Override
    public List<String> mutation(PointInfo pointInfo) {
        List<String> cityNames = this.pointRepository.getNameCity();
        List<String> childIndividual = new ArrayList<>();
        while(true){
            for(int i=0;i < 18 ;i++){
                childIndividual.add(cityNames.get((int)Math.round(Math.random()*9)));
            }
            if(checkGen(childIndividual , pointInfo)) {
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

        // kiem tra xem ma gen da di qua 3 diem chua
        if(!(
            gens.contains(pointInfo.getPoint1()) &&
            gens.contains(pointInfo.getPoint1()) &&
            gens.contains(pointInfo.getPoint1())
        )){
            return false;
        }

        // qua het cac dieu kien
        return true;
    }




}
