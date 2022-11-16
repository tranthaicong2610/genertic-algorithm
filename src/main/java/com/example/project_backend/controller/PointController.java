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
        //test
        List<String> gens1 = new ArrayList<>();
        List<String> gens2 = new ArrayList<>();
        List<String> gens3 = new ArrayList<>();
        List<String> gens4 = new ArrayList<>();
        List<String> gens5 = new ArrayList<>();

        gens1.add("HANOI","HAIPHONG","HANAM","NAMDINH");
        gens2.add("NAMDINH","HAIDUONG","NGHEAN","QUANGNAM","HANOI","HAIPHONG");
        gens3.add("NAMDINH","HAIDUONG","NGHEAN","QUANGNAM","HANOI","HAIDUONG","NGHEAN","HAIPHONG");
        gens4.add("NAMDINH","HAIDUONG","NGHEAN","THANHHOA","HAIDUONG","NGHEAN","QUANGNAM","HANOI","HAIPHONG");
        gens4.add("HANOI","THANHHOA","HAIDUONG","NGHEAN","HAIPHONG","HANAM","NAMDINH");
        System.out.println(pointInfo.toString());
        List<GenerationInformationByDistance> list = new ArrayList<>();
        list.add(123,gens1);
        list.add(152,gens2);
        list.add(185,gens3);
        list.add(123,gens4);
        list.add(225,gens5);
        return list;
    }
}
