package com.example.project_backend.service.impl;

import com.example.project_backend.model.Point;
import com.example.project_backend.repository.PointRepository;
import com.example.project_backend.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PointServiceImpl implements IPointService {

    private final PointRepository  pointRepository;
    @Autowired
    PointServiceImpl(PointRepository pointRepository){
        this.pointRepository = pointRepository;
    }
    @Override
    public List<Point> getPoints() {
        return pointRepository.findAll();
    }


    /**
     *
     * @param father ca the cha
     * @param mother ca the me
     * @return tra ve ca the con
     */

    @Override
    public List<String> crossover(List<String> father, List<String> mother) {
        List<String> childIndividual = new  ArrayList<String>();
        double a ;
        int selectFatherOrMother  ;
        for(int i = 0 ; i < father.size() ; i++){
            a = Math.random();
            selectFatherOrMother = (int)(a*2);
            while(selectFatherOrMother ==1){
                a =Math.random();
                selectFatherOrMother = (int)(a*2);
            }
            String s = (selectFatherOrMother == 0) ?  father.get(i) :  mother.get(i);
            childIndividual.add(s);
        }
        return childIndividual;
    }

    /**
     *
     * @param father ca the cha
     * @param mother ca the con
     * @return tra ve ca the con dot bien
     */
    @Override
    public List<String> mutation(List<String> father, List<String> mother) {
        return null;
    }
}
