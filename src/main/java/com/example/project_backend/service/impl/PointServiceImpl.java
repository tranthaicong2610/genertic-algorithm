package com.example.project_backend.service.impl;

import com.example.project_backend.model.Point;
import com.example.project_backend.repository.PointRepository;
import com.example.project_backend.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements IPointService {

    @Autowired
    private PointRepository pointRepository;
    @Override
    public List<Point> getPoints() {
        return pointRepository.findAll();
    }
}
