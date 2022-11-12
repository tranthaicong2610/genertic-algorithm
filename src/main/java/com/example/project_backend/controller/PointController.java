package com.example.project_backend.controller;

import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import com.example.project_backend.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/point")
@RestController
public class PointController {

    @Autowired
    private IPointService iPointService;

    @GetMapping("")
    public List<Point> getAllPoint(){
        List<String> gens = new ArrayList<>();
        gens.add("HANOI");
        gens.add("HAPHONG");
        gens.add("NAMDINH");

        float ok = this.iPointService.calculateDistance(gens);
        float h = ok +2;

        float ok1 = this.iPointService.calculateTime(gens);
        float h1 = ok +2;

//        System.out.println(ok);
        return iPointService.getPoints();
    }

    @PostMapping("/data")
    public PointInfo pointClient(@RequestBody PointInfo pointInfo){
        System.out.println(pointInfo.toString());

        return pointInfo;
    }
}
