package com.example.project_backend.service;

import com.example.project_backend.form.GenerationInformationByDistance;
import com.example.project_backend.form.GenerationInformationByTime;
import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import java.util.List;

public interface IPointService {
    // lay danh sach cac diem
    List<Point> getPoints();

    // lai ghep cheo
    List<String> crossover(List<String> father, List<String> mother,PointInfo pointInfo);

    // dot bien
    List<String> mutation(List<String> father ,PointInfo pointInfo);

    // tinh quang duong
    float calculateDistance(List<String> gens);

    float calculateTime(List<String> gens);

    List<String> geneSlicing (List<String> gens,PointInfo pointInfo);

    float fitnessCalculatorByDistance(List<String> gens);

    float fitnessCalculatorTime(List<String> gens);

    void orderByDistance(List<GenerationInformationByDistance> list);

    List<GenerationInformationByTime> orderByTime(List<GenerationInformationByTime> list);

    float distanceTotal(List<GenerationInformationByDistance> list);

    float timeTotal(List<GenerationInformationByTime> list);

    float totalFitnessDistance(List<GenerationInformationByDistance> list, PointInfo pointInfo);

}
