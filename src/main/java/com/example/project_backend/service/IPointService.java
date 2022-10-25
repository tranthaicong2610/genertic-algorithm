package com.example.project_backend.service;

import com.example.project_backend.model.Point;
import java.util.List;

public interface IPointService {
    // lay danh sach cac diem
    List<Point> getPoints();
}
