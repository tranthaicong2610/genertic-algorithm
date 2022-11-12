package com.example.project_backend.service;

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

}
