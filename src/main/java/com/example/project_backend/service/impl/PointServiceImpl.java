package com.example.project_backend.service.impl;

import com.example.project_backend.model.Point;
import com.example.project_backend.repository.PointRepository;
import com.example.project_backend.service.IPointService;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> childIndividual = new  ArrayList<String>();
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
     * @param father ca the cha
     * @param mother ca the con
     * @return tra ve ca the con dot bien
     */
    @Override
    public List<String> mutation() {
        List<String> cityNames = this.pointRepository.getNameCity();
        List<String> childIndividual = new  ArrayList<String>();
        while(true){
            for(int i=0;i < 18 ;i++){
                childIndividual.add(cityNames.get((int)Math.round(Math.random()*9)));
            }
        }
        return childIndividual;
    }

    public void main(String[] args) {
        List<String> entityManager = this.pointRepository.getNameCity();
        System.out.println(entityManager);
    }
}
