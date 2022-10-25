package com.example.project_backend.controller;

import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import com.example.project_backend.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PointInfo pointClient(@RequestBody PointInfo pointInfo){
        System.out.println(pointInfo.toString());
        return pointInfo;
    }
}
