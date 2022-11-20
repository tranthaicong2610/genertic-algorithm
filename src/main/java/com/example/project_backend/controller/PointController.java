package com.example.project_backend.controller;

import com.example.project_backend.form.GenerationInformationByDistance;
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
    public List<GenerationInformationByDistance> pointClient(@RequestBody PointInfo pointInfo){
        //test
        List<String> gens1 = new ArrayList<>();
        List<String> gens2 = new ArrayList<>();
        List<String> gens3 = new ArrayList<>();
        List<String> gens4 = new ArrayList<>();
        List<String> gens5 = new ArrayList<>();
        gens1.add("HANOI");
        gens1.add("HAIPHONG");
        gens1.add("HANAM");
        gens1.add("NAMDINH");
        gens2.add("NAMDINH");
        gens2.add("HAIDUONG");
        gens2.add("NGHEAN");
        gens2.add("QUANGNAM");
        gens2.add("HANOI");
        gens2.add("HAIPHONG");
        gens3.add("NAMDINH");
        gens3.add("HAIDUONG");
        gens3.add("NGHEAN");
        gens3.add("QUANGNAM");
        gens3.add("HANOI");
        gens3.add("HAIDUONG");
        gens3.add("NGHEAN");
        gens3.add("HAIPHONG");
        gens4.add("NAMDINH");
        gens4.add("HAIDUONG");
        gens4.add("NGHEAN");
        gens4.add("THANHHOA");
        gens4.add("HAIDUONG");
        gens4.add("NGHEAN");
        gens4.add("QUANGNAM");
        gens4.add("HANOI");
        gens4.add("HAIPHONG");
        gens4.add("HANOI");
        gens4.add("THANHHOA");
        gens4.add("HAIDUONG");
        gens4.add("NGHEAN");
        gens4.add("HAIPHONG");
        gens4.add("HANAM");
        gens4.add("NAMDINH");
        System.out.println(pointInfo.toString());
        List<GenerationInformationByDistance> list = new ArrayList<>();
        list.add(new GenerationInformationByDistance(123,  gens1));
        list.add(new GenerationInformationByDistance(152,gens2));
        list.add(new GenerationInformationByDistance(185,gens3));
        list.add(new GenerationInformationByDistance(123,gens4));
        list.add(new GenerationInformationByDistance(225,gens5));
        return list;
    }
}
