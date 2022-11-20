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

        String[] data1 = {"NAMDINH","BINHTHUAN","NAMDINH","HANOI","HOCHIMINH","HAIPHONG","BINHDUONG","HOCHIMINH","BACNINH","BINHTHUAN","BINHDUONG"};
        String[] data2 = {"HOCHIMINH", "BINHTHUAN", "BACNINH", "BINHDUONG", "BACNINH", "BINHTHUAN", "NAMDINH", "NAMDINH", "BACNINH", "HAIPHONG", "BACNINH"};
        String[] data3 = {"BINHDUONG", "BINHTHUAN", "HOCHIMINH", "HAIPHONG", "BINHTHUAN", "NAMDINH", "HOCHIMINH", "BACNINH", "BACNINH", "BINHTHUAN", "BACNINH", "THAIBINH"};
        String[] data4 = {"NAMDINH", "BACNINH", "BACNINH", "THAIBINH", "HOCHIMINH", "BINHTHUAN", "THAIBINH", "HAIPHONG", "BINHDUONG", "THAIBINH", "THAIBINH"};
        String[] data5 = {"NAMDINH", "BACNINH", "NAMDINH", "BINHTHUAN", "HAIPHONG", "NAMDINH", "QUANGNGAI", "NAMDINH", "BACNINH", "THAIBINH", "HAIPHONG"};
        String[] data6 = {"BINHTHUAN", "NAMDINH", "HOCHIMINH", "BINHDUONG", "QUANGNGAI", "QUANGNGAI", "THAIBINH", "HAIPHONG", "QUANGNGAI", "THAIBINH", "HANOI", "BINHTHUAN", "BINHTHUAN"};
        String[] data7 = {"HOCHIMINH", "HANOI", "HAIPHONG", "BINHTHUAN", "BINHTHUAN", "QUANGNGAI", "THAIBINH", "BINHDUONG", "HOCHIMINH", "HOCHIMINH", "HAIPHONG"};
        String[] data8 = {"QUANGNGAI", "NAMDINH", "HANOI", "BINHTHUAN", "HAIDUONG", "HAIPHONG", "BINHDUONG", "QUANGNGAI", "THAIBINH", "BACNINH", "BINHTHUAN", "HOCHIMINH"};
        String[] data9 = {"HANOI", "BACNINH", "HAIPHONG", "THAIBINH", "BINHTHUAN", "THAIBINH", "BINHDUONG", "THAIBINH", "NAMDINH", "HANOI", "HOCHIMINH"};
        String[] data10 = {"HAIDUONG", "BINHTHUAN", "HAIDUONG", "BACNINH", "THAIBINH", "HAIDUONG", "NAMDINH", "HOCHIMINH", "BINHDUONG", "BACNINH", "THAIBINH"};
        String[] data11 = {"HANOI", "BINHTHUAN", "HOCHIMINH", "HOCHIMINH", "QUANGNGAI", "HANOI", "HAIPHONG", "HANOI", "BINHTHUAN", "HAIPHONG", "NAMDINH"};
        String[] data12 = {"THAIBINH", "HAIPHONG", "THAIBINH", "NAMDINH", "BACNINH", "BINHTHUAN", "THAIBINH", "QUANGNGAI", "HAIDUONG", "THAIBINH", "BACNINH"};
        String[] data13 = {"BINHDUONG", "BINHTHUAN", "BACNINH", "BACNINH", "HAIPHONG", "QUANGNGAI", "HOCHIMINH", "HAIDUONG", "THAIBINH", "THAIBINH", "HAIPHONG"};
        String[] data14 = {"HAIDUONG", "HOCHIMINH", "BINHDUONG", "THAIBINH", "HAIPHONG", "BINHDUONG"};
        String[] data15 = {"BINHTHUAN", "QUANGNGAI", "BINHDUONG", "BINHTHUAN", "HAIDUONG", "THAIBINH", "NAMDINH", "HOCHIMINH", "BACNINH", "BINHTHUAN", "HAIDUONG"};
        String[] data16 = {"QUANGNGAI", "BINHDUONG", "THAIBINH", "BACNINH", "BINHTHUAN", "QUANGNGAI", "NAMDINH", "BINHDUONG", "HOCHIMINH"};
        String[] data17 = {"NAMDINH", "NAMDINH", "HAIPHONG", "THAIBINH", "QUANGNGAI", "BINHTHUAN", "BACNINH", "NAMDINH", "HANOI", "QUANGNGAI", "HAIPHONG", "BACNINH", "HANOI"};
        String[] data18 = {"HOCHIMINH", "HANOI", "THAIBINH", "BACNINH", "BINHDUONG", "QUANGNGAI", "QUANGNGAI", "HAIPHONG", "BINHDUONG", "HOCHIMINH", "BINHDUONG", "BINHTHUAN"};
        String[] data19 = {"THAIBINH", "BINHDUONG", "BINHTHUAN", "QUANGNGAI", "HAIPHONG", "BACNINH", "HANOI", "HAIDUONG", "HANOI", "HAIPHONG", "QUANGNGAI"};
        String[] data20 = {"BINHTHUAN", "NAMDINH", "BACNINH", "BACNINH", "NAMDINH"};
        String[] data21 = {"QUANGNGAI", "BINHDUONG", "BINHTHUAN", "QUANGNGAI", "BINHDUONG", "NAMDINH", "BINHTHUAN", "BINHTHUAN", "HAIPHONG", "QUANGNGAI", "BACNINH"};
        String[] data22 = {"HANOI", "HANOI", "NAMDINH", "HAIPHONG", "THAIBINH", "QUANGNGAI", "QUANGNGAI", "BINHDUONG", "NAMDINH", "NAMDINH", "QUANGNGAI"};
        String[] data23 = {"BACNINH", "QUANGNGAI", "NAMDINH", "QUANGNGAI", "BINHTHUAN", "NAMDINH", "QUANGNGAI", "HAIPHONG"};
        String[] data24 = {"NAMDINH", "THAIBINH", "BINHDUONG", "QUANGNGAI", "NAMDINH", "HAIPHONG", "NAMDINH", "THAIBINH", "BINHTHUAN", "HOCHIMINH", "BINHTHUAN"};
        String[] data25 = {"THAIBINH", "BACNINH", "QUANGNGAI", "HOCHIMINH", "BINHTHUAN", "BACNINH", "THAIBINH", "HAIPHONG", "HAIDUONG", "QUANGNGAI", "THAIBINH"};
        String[] data26 = {"NAMDINH", "THAIBINH", "BINHTHUAN", "BINHDUONG", "HAIDUONG", "NAMDINH", "HANOI", "NAMDINH", "BACNINH", "NAMDINH", "HAIPHONG"};
        String[] data27 = {"BACNINH", "HAIDUONG", "QUANGNGAI", "QUANGNGAI", "HOCHIMINH", "HOCHIMINH", "NAMDINH", "HAIPHONG", "BINHTHUAN", "NAMDINH", "BACNINH", "BACNINH"};
        String[] data28 = {"BINHDUONG", "THAIBINH", "HANOI", "NAMDINH", "HAIPHONG", "BINHDUONG", "BINHTHUAN", "THAIBINH", "BINHTHUAN", "THAIBINH", "QUANGNGAI"};
        String[] data29 = {"QUANGNGAI", "BACNINH", "HOCHIMINH", "THAIBINH", "THAIBINH", "QUANGNGAI", "BINHTHUAN", "BINHDUONG", "NAMDINH", "BACNINH", "HAIPHONG"};
        String[] data30 = {"BINHTHUAN", "NAMDINH", "HAIDUONG", "HAIPHONG", "HAIPHONG", "THAIBINH", "BINHTHUAN", "HAIPHONG", "BACNINH", "NAMDINH", "QUANGNGAI"};
        String[] data31 = {"NAMDINH", "HAIDUONG", "HAIPHONG", "BINHDUONG", "THAIBINH", "NAMDINH", "BINHDUONG", "BACNINH", "HOCHIMINH", "BACNINH", "THAIBINH"};
        String[] data32 = {"THAIBINH", "HAIDUONG", "NAMDINH", "BINHDUONG", "QUANGNGAI", "QUANGNGAI", "HOCHIMINH", "HOCHIMINH", "HOCHIMINH", "HAIDUONG", "QUANGNGAI"};
        String[] data33 = {"NAMDINH", "BINHTHUAN", "QUANGNGAI", "BINHDUONG", "HOCHIMINH", "HANOI", "BACNINH", "THAIBINH", "QUANGNGAI", "QUANGNGAI", "QUANGNGAI"};
        String[] data34 = {"NAMDINH", "BINHDUONG", "HAIDUONG", "HANOI", "NAMDINH", "QUANGNGAI", "THAIBINH", "QUANGNGAI", "NAMDINH", "BINHDUONG", "BINHTHUAN"};
        String[] data35 = {"THAIBINH", "HAIPHONG", "HOCHIMINH", "HAIPHONG", "THAIBINH", "HOCHIMINH", "HANOI", "QUANGNGAI", "QUANGNGAI", "BINHDUONG", "BACNINH"};
        String[] data36 = {"HANOI", "BINHDUONG", "BACNINH", "BINHDUONG", "BACNINH", "HAIPHONG", "BINHDUONG", "HOCHIMINH", "QUANGNGAI", "NAMDINH", "QUANGNGAI"};
        String[] data37 = {"NAMDINH", "BINHDUONG", "BINHDUONG", "BINHDUONG", "BACNINH", "HOCHIMINH", "BACNINH", "HOCHIMINH", "BACNINH", "QUANGNGAI", "QUANGNGAI"};
        String[] data38 = {"HOCHIMINH", "THAIBINH", "BACNINH", "HOCHIMINH", "HAIPHONG", "BINHTHUAN", "HANOI", "BACNINH", "BINHDUONG", "BINHDUONG", "HOCHIMINH"};
        String[] data39 = {"HOCHIMINH", "QUANGNGAI", "BINHDUONG", "BINHTHUAN", "BINHDUONG", "HAIPHONG", "THAIBINH", "HAIDUONG", "BINHTHUAN", "HOCHIMINH", "BINHTHUAN"};
        String[] data40 = {"BINHDUONG", "HAIPHONG", "HANOI", "BINHTHUAN", "HOCHIMINH", "BINHTHUAN", "HAIPHONG", "NAMDINH", "HAIPHONG", "HANOI", "THAIBINH"};
        String[] data41 = {"THAIBINH", "THAIBINH", "BINHTHUAN", "BINHTHUAN", "BINHDUONG", "HAIPHONG", "HANOI", "BACNINH", "HOCHIMINH", "BINHTHUAN", "NAMDINH"};
        String[] data42 = {"HOCHIMINH", "HAIDUONG", "HOCHIMINH", "QUANGNGAI", "NAMDINH", "HANOI", "BINHDUONG", "HAIPHONG", "NAMDINH", "BINHTHUAN", "NAMDINH"};
        String[] data43 = {"QUANGNGAI", "HAIPHONG", "HANOI", "BINHDUONG", "NAMDINH", "HOCHIMINH", "QUANGNGAI", "NAMDINH", "BINHDUONG", "NAMDINH", "NAMDINH"};
        String[] data44 = {"BINHTHUAN", "HOCHIMINH", "NAMDINH", "BINHTHUAN", "THAIBINH", "HAIDUONG", "BINHDUONG", "THAIBINH", "BINHDUONG", "HAIPHONG", "BINHDUONG"};
        String[] data45 = {"BINHDUONG", "HOCHIMINH", "BINHDUONG", "HAIPHONG", "NAMDINH", "BACNINH", "BACNINH", "HOCHIMINH"};
        String[] data46 = {"HAIPHONG", "QUANGNGAI", "QUANGNGAI", "BINHTHUAN", "BINHDUONG", "QUANGNGAI", "BINHTHUAN", "HOCHIMINH", "BACNINH", "BINHTHUAN", "BACNINH"};
        String[] data47 = {"THAIBINH", "BINHDUONG", "NAMDINH", "NAMDINH", "BINHTHUAN", "QUANGNGAI", "HOCHIMINH", "HAIPHONG"};
        String[] data48 = {"BINHDUONG", "BINHTHUAN", "BINHTHUAN", "QUANGNGAI", "BACNINH", "HOCHIMINH", "QUANGNGAI", "THAIBINH", "HOCHIMINH", "BINHDUONG", "NAMDINH"};
        String[] data49 = {"THAIBINH", "HAIPHONG", "HANOI", "HANOI", "NAMDINH", "QUANGNGAI", "HAIDUONG", "HOCHIMINH", "HAIPHONG", "HANOI", "NAMDINH"};
        String[] data50 = {"HOCHIMINH", "QUANGNGAI", "BINHTHUAN", "NAMDINH"};
        String[] data51 = {"HAIPHONG", "BINHTHUAN", "BACNINH", "QUANGNGAI", "BACNINH", "HAIPHONG", "BINHDUONG", "BACNINH", "QUANGNGAI", "HANOI", "NAMDINH"};
        String[] data52 = {"BINHDUONG", "THAIBINH", "NAMDINH", "HANOI", "BINHDUONG", "BINHDUONG", "BINHTHUAN", "HAIPHONG", "HANOI", "HOCHIMINH", "HANOI"};
        String[] data53 = {"NAMDINH", "NAMDINH", "BINHTHUAN", "BINHDUONG", "QUANGNGAI", "HOCHIMINH", "NAMDINH", "QUANGNGAI", "BINHTHUAN", "BACNINH", "BINHTHUAN"};
        String[] data54 = {"BINHTHUAN", "THAIBINH", "BINHDUONG", "HAIPHONG", "QUANGNGAI", "BINHTHUAN", "BACNINH", "NAMDINH", "BINHDUONG", "NAMDINH"};
        String[] data55 = {"QUANGNGAI", "THAIBINH", "BACNINH", "NAMDINH", "BACNINH", "THAIBINH", "BINHDUONG", "HAIPHONG", "HAIPHONG", "QUANGNGAI", "HAIDUONG"};
        String[] data56 = {"NAMDINH", "BACNINH", "HOCHIMINH", "HOCHIMINH", "QUANGNGAI", "BACNINH", "NAMDINH", "HAIDUONG", "THAIBINH", "BINHTHUAN", "BINHDUONG"};
        String[] data57 = {"BINHDUONG", "THAIBINH", "HOCHIMINH", "HOCHIMINH", "HAIDUONG", "NAMDINH", "NAMDINH", "HAIPHONG"};
        String[] data58 = {"BINHTHUAN", "HAIPHONG", "HAIPHONG", "BACNINH", "NAMDINH", "BACNINH", "BINHTHUAN", "BACNINH", "QUANGNGAI", "HANOI", "HOCHIMINH"};
        String[] data59 = {"HANOI", "BINHTHUAN", "HOCHIMINH", "NAMDINH", "QUANGNGAI", "BINHTHUAN", "HOCHIMINH", "BINHDUONG", "HOCHIMINH", "NAMDINH", "BINHTHUAN"};
        String[] data60 = {"BINHTHUAN", "HAIPHONG", "HOCHIMINH", "BACNINH", "THAIBINH", "QUANGNGAI", "HOCHIMINH", "HAIPHONG", "HOCHIMINH", "QUANGNGAI", "QUANGNGAI"};
        String[] data61 = {"HOCHIMINH", "HAIDUONG", "NAMDINH", "BACNINH", "NAMDINH", "THAIBINH", "HOCHIMINH", "BINHDUONG", "BACNINH", "QUANGNGAI", "HOCHIMINH"};
        String[] data62 = {"NAMDINH", "QUANGNGAI", "NAMDINH", "BINHDUONG", "BINHTHUAN", "THAIBINH", "BINHDUONG", "NAMDINH", "BINHDUONG", "BINHTHUAN", "BACNINH", "HOCHIMINH", "BACNINH", "THAIBINH", "NAMDINH"};
        String[] data63 = {"HOCHIMINH", "HANOI", "HAIDUONG", "NAMDINH", "BINHTHUAN", "HANOI", "BINHTHUAN", "HAIPHONG", "QUANGNGAI", "THAIBINH", "QUANGNGAI"};
        String[] data64 = {"BINHTHUAN", "NAMDINH", "NAMDINH", "THAIBINH", "THAIBINH", "NAMDINH", "HAIDUONG", "HAIPHONG", "HAIDUONG", "THAIBINH", "BINHTHUAN"};
        String[] data65 = {"HAIPHONG", "BINHDUONG", "NAMDINH", "BINHTHUAN", "BACNINH", "HAIDUONG", "BINHTHUAN", "BINHDUONG", "HAIDUONG", "THAIBINH", "HAIDUONG"};
        String[] data66 = {"BINHTHUAN", "HAIDUONG", "HOCHIMINH", "QUANGNGAI", "HOCHIMINH", "BACNINH", "BINHDUONG", "THAIBINH", "BACNINH", "BINHTHUAN", "THAIBINH"};
        String[] data67 = {"BINHTHUAN", "HAIPHONG", "BINHTHUAN", "BINHTHUAN", "BINHTHUAN", "HOCHIMINH", "THAIBINH", "HOCHIMINH", "HOCHIMINH", "BINHTHUAN", "HAIDUONG"};
        String[] data68 = {"HAIDUONG", "QUANGNGAI", "HANOI", "HAIPHONG", "THAIBINH", "BINHDUONG", "HAIPHONG"};
        String[] data69 = {"BACNINH", "QUANGNGAI", "BACNINH", "HAIPHONG", "HAIDUONG", "HANOI", "BINHTHUAN", "BINHDUONG", "HANOI", "BINHDUONG", "BACNINH"};
        String[] data70 = {"HAIDUONG", "HAIPHONG", "HAIDUONG", "THAIBINH", "BINHDUONG", "BINHDUONG", "QUANGNGAI", "THAIBINH", "THAIBINH", "BACNINH", "HAIPHONG"};
        String[] data71 = {"NAMDINH", "BINHDUONG", "THAIBINH", "BINHDUONG", "NAMDINH", "HAIDUONG", "NAMDINH", "HAIPHONG", "BINHDUONG", "BINHDUONG", "BACNINH"};
        String[] data72 = {"BINHTHUAN", "NAMDINH", "HAIPHONG", "BINHTHUAN", "HOCHIMINH", "BINHDUONG", "BACNINH", "NAMDINH", "BINHTHUAN", "BACNINH", "HOCHIMINH", "HOCHIMINH", "HAIPHONG"};
        String[] data73 = {"QUANGNGAI", "THAIBINH", "BACNINH", "QUANGNGAI", "BACNINH", "HOCHIMINH", "HAIPHONG", "THAIBINH", "BINHDUONG", "BINHDUONG", "NAMDINH"};
        String[] data74 = {"HAIPHONG", "NAMDINH", "HANOI", "QUANGNGAI", "HAIPHONG", "HAIPHONG", "THAIBINH", "HOCHIMINH", "HAIDUONG", "HANOI", "BACNINH"};
        String[] data75 = {"QUANGNGAI", "HAIPHONG", "QUANGNGAI", "HAIPHONG", "NAMDINH", "HANOI", "HOCHIMINH", "HAIDUONG"};
        String[] data76 = {"BACNINH", "THAIBINH", "HAIPHONG", "QUANGNGAI", "BINHTHUAN", "QUANGNGAI", "QUANGNGAI", "HANOI", "BINHTHUAN", "QUANGNGAI", "HAIPHONG"};
        String[] data77 = {"HOCHIMINH", "BINHTHUAN", "NAMDINH", "QUANGNGAI", "BINHDUONG", "HAIPHONG", "HAIDUONG", "HOCHIMINH", "HOCHIMINH", "THAIBINH", "BINHDUONG"};
        String[] data78 = {"THAIBINH", "BACNINH", "BACNINH", "QUANGNGAI", "BINHDUONG", "HOCHIMINH", "NAMDINH", "BINHTHUAN", "HAIPHONG", "QUANGNGAI", "BINHTHUAN"};
        String[] data79= {"HAIPHONG", "QUANGNGAI", "BACNINH", "NAMDINH", "NAMDINH", "NAMDINH", "THAIBINH", "HOCHIMINH", "HOCHIMINH", "BINHTHUAN", "HAIDUONG"};
        String[] data80 = {"THAIBINH", "QUANGNGAI", "HOCHIMINH", "HAIPHONG", "NAMDINH", "QUANGNGAI", "THAIBINH", "HANOI", "HAIPHONG", "BINHTHUAN", "NAMDINH"};
        String[] data81 = {"HAIDUONG", "BACNINH", "HOCHIMINH", "NAMDINH", "BINHTHUAN", "BACNINH", "NAMDINH", "HAIPHONG", "HOCHIMINH", "HAIPHONG", "HOCHIMINH", "BINHDUONG", "HAIDUONG", "BINHDUONG", "BINHTHUAN", "HAIPHONG"};
        String[] data82 = {"BINHDUONG", "NAMDINH", "NAMDINH", "HOCHIMINH", "HANOI", "QUANGNGAI", "HAIDUONG", "QUANGNGAI", "BINHDUONG", "BINHTHUAN", "THAIBINH"};
        String[] data83 = {"BINHDUONG", "BINHDUONG", "HAIPHONG", "HOCHIMINH", "HOCHIMINH", "HOCHIMINH", "HOCHIMINH"};
        String[] data84 = {"NAMDINH", "BACNINH", "BINHTHUAN", "BACNINH", "HOCHIMINH", "BACNINH", "HAIDUONG", "HOCHIMINH", "HOCHIMINH", "THAIBINH", "HOCHIMINH"};
        String[] data85 = {"BINHTHUAN", "BINHTHUAN", "BINHDUONG", "HAIPHONG", "BACNINH", "HOCHIMINH"};
        String[] data86 = {"NAMDINH", "HAIDUONG", "NAMDINH", "HAIDUONG", "BACNINH", "BACNINH", "HANOI", "HAIPHONG", "BINHTHUAN", "HAIPHONG", "HAIPHONG"};
        String[] data87 = {"THAIBINH", "HANOI", "HAIPHONG", "NAMDINH", "BINHTHUAN", "HANOI", "HAIDUONG", "QUANGNGAI", "NAMDINH", "BINHDUONG", "THAIBINH"};
        String[] data88 = {"BINHDUONG", "HOCHIMINH", "NAMDINH", "HANOI", "THAIBINH", "QUANGNGAI", "HANOI", "BINHDUONG", "HOCHIMINH", "BACNINH", "HAIPHONG"};
        String[] data89 = {"HAIPHONG", "BINHTHUAN", "HAIPHONG", "HOCHIMINH", "HOCHIMINH", "BINHTHUAN", "QUANGNGAI", "HANOI", "HAIPHONG", "HAIDUONG", "HANOI"};
        String[] data90 = {"THAIBINH", "BINHTHUAN", "HANOI"};
        String[] data91 = {"HOCHIMINH", "HOCHIMINH", "BACNINH", "BINHTHUAN", "HAIDUONG", "HOCHIMINH", "BINHDUONG", "HANOI", "HAIPHONG", "THAIBINH", "QUANGNGAI"};
        String[] data92 = {"BINHTHUAN", "BINHDUONG", "HAIPHONG", "HAIPHONG", "NAMDINH", "HOCHIMINH", "HAIDUONG", "BINHDUONG", "HAIPHONG", "BACNINH", "NAMDINH", "BINHDUONG"};
        String[] data93 = {"THAIBINH", "HOCHIMINH", "BINHDUONG", "HAIDUONG", "NAMDINH", "THAIBINH", "NAMDINH", "BINHDUONG", "NAMDINH", "HOCHIMINH", "QUANGNGAI"};
        String[] data94 = {"HOCHIMINH", "HANOI", "BACNINH", "BINHTHUAN", "NAMDINH", "NAMDINH", "HAIPHONG", "BINHDUONG", "BACNINH", "QUANGNGAI", "BINHDUONG"};
        String[] data95 = {"BINHDUONG", "HOCHIMINH", "HANOI", "THAIBINH", "HOCHIMINH", "NAMDINH"};
        String[] data96 = {"HOCHIMINH", "BACNINH", "HAIPHONG", "NAMDINH", "QUANGNGAI", "THAIBINH"};
        String[] data97 = {"HAIPHONG", "BACNINH", "BINHDUONG", "QUANGNGAI", "BACNINH", "BINHTHUAN"};
        String[] data98 = {"QUANGNGAI", "THAIBINH", "NAMDINH", "HANOI", "HAIPHONG", "HOCHIMINH"};
        String[] data99 = {"THAIBINH", "BACNINH", "THAIBINH", "BINHTHUAN", "HOCHIMINH", "THAIBINH"};
        String[] data100 = {"HOCHIMINH", "HAIPHONG", "THAIBINH", "HAIPHONG", "NAMDINH", "BINHTHUAN"};
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
