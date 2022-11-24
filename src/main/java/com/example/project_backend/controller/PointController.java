package com.example.project_backend.controller;

import com.example.project_backend.form.GenerationInformationByDistance;
import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import com.example.project_backend.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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

//        float ok = this.iPointService.calculateDistance(gens);
//        float h = ok +2;
//
//        float ok1 = this.iPointService.calculateTime(gens);
//        float h1 = ok +2;

//        System.out.println(ok);
        return iPointService.getPoints();
    }

    @PostMapping("/data")
    public List<GenerationInformationByDistance> pointClient(@RequestBody PointInfo pointInfo){
        List<GenerationInformationByDistance> population = new ArrayList<>();

        String[] data1 = {"NAMDINH","BINHTHUAN","NAMDINH","HANOI","HOCHIMINH","HAIPHONG","BINHDUONG","HOCHIMINH","BACNINH","BINHTHUAN","BINHDUONG"};
        String[] data2 = {"HOCHIMINH", "BINHTHUAN", "BACNINH", "BINHDUONG", "BACNINH", "BINHTHUAN", "NAMDINH", "BACNINH", "QUANGNGAI", "HAIPHONG", "BACNINH"};
        String[] data3 = {"BINHDUONG", "BINHTHUAN", "HOCHIMINH", "HAIPHONG", "BINHTHUAN", "NAMDINH", "HOCHIMINH", "QUANGNGAI", "BACNINH", "BINHTHUAN", "BACNINH", "THAIBINH"};
        String[] data4 = {"NAMDINH", "QUANGNGAI", "BACNINH", "THAIBINH", "HOCHIMINH", "BINHTHUAN", "THAIBINH", "HAIPHONG", "BINHDUONG", "THAIBINH", "HOCHIMINH"};
        String[] data5 = {"NAMDINH", "BACNINH", "NAMDINH", "BINHTHUAN", "HAIPHONG", "NAMDINH", "QUANGNGAI", "NAMDINH", "BACNINH", "THAIBINH", "HAIPHONG"};
        String[] data6 = {"BINHTHUAN", "NAMDINH", "HOCHIMINH", "BINHDUONG", "THAIBINH", "QUANGNGAI", "THAIBINH", "HAIPHONG", "QUANGNGAI", "THAIBINH", "HANOI", "BINHTHUAN", "HANOI"};
        String[] data7 = {"HOCHIMINH", "HANOI", "HAIPHONG", "BINHTHUAN", "HAIDUONG", "QUANGNGAI", "THAIBINH", "BINHDUONG", "HOCHIMINH", "BINHDUONG", "HAIPHONG"};
        String[] data8 = {"QUANGNGAI", "NAMDINH", "HANOI", "BINHTHUAN", "HAIDUONG", "HAIPHONG", "BINHDUONG", "QUANGNGAI", "THAIBINH", "BACNINH", "BINHTHUAN", "HOCHIMINH"};
        String[] data9 = {"HANOI", "BACNINH", "HAIPHONG", "THAIBINH", "BINHTHUAN", "THAIBINH", "BINHDUONG", "THAIBINH", "NAMDINH", "HANOI", "HOCHIMINH"};
        String[] data10 = {"HAIDUONG", "BINHTHUAN", "HAIDUONG", "BACNINH", "THAIBINH", "HAIDUONG", "NAMDINH", "HOCHIMINH", "BINHDUONG", "BACNINH", "THAIBINH"};
        String[] data11 = {"HANOI", "BINHTHUAN", "HOCHIMINH", "BINHDUONG", "QUANGNGAI", "HANOI", "HAIPHONG", "HANOI", "BINHTHUAN", "HAIPHONG", "NAMDINH"};
        String[] data12 = {"THAIBINH", "HAIPHONG", "THAIBINH", "NAMDINH", "BACNINH", "BINHTHUAN", "THAIBINH", "QUANGNGAI", "HAIDUONG", "THAIBINH", "BACNINH"};
        String[] data13 = {"BINHDUONG", "BINHTHUAN", "QUANGNGAI", "BACNINH", "HAIPHONG", "QUANGNGAI", "HOCHIMINH", "HAIDUONG", "THAIBINH", "HOCHIMINH", "HAIPHONG"};
        String[] data14 = {"HAIDUONG", "HOCHIMINH", "BINHDUONG", "THAIBINH", "HAIPHONG", "BINHDUONG"};
        String[] data15 = {"BINHTHUAN", "QUANGNGAI", "BINHDUONG", "BINHTHUAN", "HAIDUONG", "THAIBINH", "NAMDINH", "HOCHIMINH", "BACNINH", "BINHTHUAN", "HAIDUONG"};
        String[] data16 = {"QUANGNGAI", "BINHDUONG", "THAIBINH", "BACNINH", "BINHTHUAN", "QUANGNGAI", "NAMDINH", "BINHDUONG", "HOCHIMINH"};
        String[] data17 = {"NAMDINH", "BACNINH", "HAIPHONG", "THAIBINH", "QUANGNGAI", "BINHTHUAN", "BACNINH", "NAMDINH", "HANOI", "QUANGNGAI", "HAIPHONG", "BACNINH", "HANOI"};
        String[] data18 = {"HOCHIMINH", "HANOI", "THAIBINH", "BACNINH", "BINHDUONG", "QUANGNGAI", "QUANGNGAI", "HAIPHONG", "BINHDUONG", "HOCHIMINH", "BINHDUONG", "BINHTHUAN"};
        String[] data19 = {"THAIBINH", "BINHDUONG", "BINHTHUAN", "QUANGNGAI", "HAIPHONG", "BACNINH", "HANOI", "HAIDUONG", "HANOI", "HAIPHONG", "QUANGNGAI"};
        String[] data20 = {"BINHTHUAN", "NAMDINH", "BACNINH", "QUANGNGAI", "NAMDINH"};
        String[] data21 = {"QUANGNGAI", "BINHDUONG", "BINHTHUAN", "QUANGNGAI", "BINHDUONG", "NAMDINH", "BINHTHUAN", "HAIDUONG", "HAIPHONG", "QUANGNGAI", "BACNINH"};
        String[] data22 = {"QUANGNGAI", "HANOI", "NAMDINH", "HAIPHONG", "THAIBINH", "QUANGNGAI", "QUANGNGAI", "BINHDUONG", "BACNINH", "NAMDINH", "QUANGNGAI"};
        String[] data23 = {"BACNINH", "QUANGNGAI", "NAMDINH", "QUANGNGAI", "BINHTHUAN", "NAMDINH", "QUANGNGAI", "HAIPHONG"};
        String[] data24 = {"NAMDINH", "THAIBINH", "BINHDUONG", "QUANGNGAI", "NAMDINH", "HAIPHONG", "NAMDINH", "THAIBINH", "BINHTHUAN", "HOCHIMINH", "BINHTHUAN"};
        String[] data25 = {"THAIBINH", "BACNINH", "QUANGNGAI", "HOCHIMINH", "BINHTHUAN", "BACNINH", "THAIBINH", "HAIPHONG", "HAIDUONG", "QUANGNGAI", "THAIBINH"};
        String[] data26 = {"NAMDINH", "THAIBINH", "BINHTHUAN", "BINHDUONG", "HAIDUONG", "NAMDINH", "HANOI", "NAMDINH", "BACNINH", "NAMDINH", "HAIPHONG"};
        String[] data27 = {"BACNINH", "HAIDUONG", "QUANGNGAI", "QUANGNGAI", "HOCHIMINH", "BINHDUONG", "NAMDINH", "HAIPHONG", "BINHTHUAN", "NAMDINH", "BACNINH", "QUANGNGAI"};
        String[] data28 = {"BINHDUONG", "THAIBINH", "HANOI", "NAMDINH", "HAIPHONG", "BINHDUONG", "BINHTHUAN", "THAIBINH", "BINHTHUAN", "THAIBINH", "QUANGNGAI"};
        String[] data29 = {"QUANGNGAI", "BACNINH", "HOCHIMINH", "THAIBINH", "HOCHIMINH", "QUANGNGAI", "BINHTHUAN", "BINHDUONG", "NAMDINH", "BACNINH", "HAIPHONG"};
        String[] data30 = {"BINHTHUAN", "NAMDINH", "HAIDUONG", "HAIPHONG", "HAIDUONG", "THAIBINH", "BINHTHUAN", "HAIPHONG", "BACNINH", "NAMDINH", "QUANGNGAI"};
        String[] data31 = {"NAMDINH", "HAIDUONG", "HAIPHONG", "BINHDUONG", "THAIBINH", "NAMDINH", "BINHDUONG", "BACNINH", "HOCHIMINH", "BACNINH", "THAIBINH"};
        String[] data32 = {"THAIBINH", "HAIDUONG", "NAMDINH", "BINHDUONG", "QUANGNGAI", "QUANGNGAI", "HOCHIMINH", "BINHDUONG", "HOCHIMINH", "HAIDUONG", "QUANGNGAI"};
        String[] data33 = {"NAMDINH", "BINHTHUAN", "QUANGNGAI", "BINHDUONG", "HOCHIMINH", "HANOI", "BACNINH", "THAIBINH", "QUANGNGAI", "QUANGNGAI", "QUANGNGAI"};
        String[] data34 = {"NAMDINH", "BINHDUONG", "HAIDUONG", "HANOI", "NAMDINH", "QUANGNGAI", "THAIBINH", "QUANGNGAI", "NAMDINH", "BINHDUONG", "BINHTHUAN"};
        String[] data35 = {"THAIBINH", "HAIPHONG", "HOCHIMINH", "HAIPHONG", "THAIBINH", "HOCHIMINH", "HANOI", "QUANGNGAI", "QUANGNGAI", "BINHDUONG", "BACNINH"};
        String[] data36 = {"HANOI", "BINHDUONG", "BACNINH", "BINHDUONG", "BACNINH", "HAIPHONG", "BINHDUONG", "HOCHIMINH", "QUANGNGAI", "NAMDINH", "QUANGNGAI"};
        String[] data37 = {"NAMDINH", "BINHDUONG", "BACNINH", "BINHDUONG", "BACNINH", "HOCHIMINH", "BACNINH", "HOCHIMINH", "BACNINH", "QUANGNGAI", "QUANGNGAI"};
        String[] data38 = {"HOCHIMINH", "THAIBINH", "BACNINH", "HOCHIMINH", "HAIPHONG", "BINHTHUAN", "HANOI", "BACNINH", "BINHDUONG", "BINHDUONG", "HOCHIMINH"};
        String[] data39 = {"HOCHIMINH", "QUANGNGAI", "BINHDUONG", "BINHTHUAN", "BINHDUONG", "HAIPHONG", "THAIBINH", "HAIDUONG", "BINHTHUAN", "HOCHIMINH", "BINHTHUAN"};
        String[] data40 = {"BINHDUONG", "HAIPHONG", "HANOI", "BINHTHUAN", "HOCHIMINH", "BINHTHUAN", "HAIPHONG", "NAMDINH", "HAIPHONG", "HANOI", "THAIBINH"};
        String[] data41 = {"THAIBINH", "HOCHIMINH", "BINHTHUAN", "HAIDUONG", "BINHDUONG", "HAIPHONG", "HANOI", "BACNINH", "HOCHIMINH", "BINHTHUAN", "NAMDINH"};
        String[] data42 = {"HOCHIMINH", "HAIDUONG", "HOCHIMINH", "QUANGNGAI", "NAMDINH", "HANOI", "BINHDUONG", "HAIPHONG", "NAMDINH", "BINHTHUAN", "NAMDINH"};
        String[] data43 = {"QUANGNGAI", "HAIPHONG", "HANOI", "BINHDUONG", "NAMDINH", "HOCHIMINH", "QUANGNGAI", "NAMDINH", "BINHDUONG", "NAMDINH", "BACNINH"};
        String[] data44 = {"BINHTHUAN", "HOCHIMINH", "NAMDINH", "BINHTHUAN", "THAIBINH", "HAIDUONG", "BINHDUONG", "THAIBINH", "BINHDUONG", "HAIPHONG", "BINHDUONG"};
        String[] data45 = {"BINHDUONG", "HOCHIMINH", "BINHDUONG", "HAIPHONG", "NAMDINH", "BACNINH", "QUANGNGAI", "HOCHIMINH"};
        String[] data46 = {"HAIPHONG", "QUANGNGAI", "QUANGNGAI", "BINHTHUAN", "BINHDUONG", "QUANGNGAI", "BINHTHUAN", "HOCHIMINH", "BACNINH", "BINHTHUAN", "BACNINH"};
        String[] data47 = {"THAIBINH", "BINHDUONG", "NAMDINH", "NAMDINH", "BINHTHUAN", "QUANGNGAI", "HOCHIMINH", "HAIPHONG"};
        String[] data48 = {"BINHDUONG", "BINHTHUAN", "HAIDUONG", "QUANGNGAI", "BACNINH", "HOCHIMINH", "QUANGNGAI", "THAIBINH", "HOCHIMINH", "BINHDUONG", "NAMDINH"};
        String[] data49 = {"THAIBINH", "HAIPHONG", "HANOI", "QUANGNGAI", "NAMDINH", "QUANGNGAI", "HAIDUONG", "HOCHIMINH", "HAIPHONG", "HANOI", "NAMDINH"};
        String[] data50 = {"HOCHIMINH", "QUANGNGAI", "BINHTHUAN", "NAMDINH"};
        String[] data51 = {"HAIPHONG", "BINHTHUAN", "BACNINH", "QUANGNGAI", "BACNINH", "HAIPHONG", "BINHDUONG", "BACNINH", "QUANGNGAI", "HANOI", "NAMDINH"};
        String[] data52 = {"BINHDUONG", "THAIBINH", "NAMDINH", "HANOI", "BINHDUONG", "BINHDUONG", "BINHTHUAN", "HAIPHONG", "HANOI", "HOCHIMINH", "HANOI"};
        String[] data53 = {"NAMDINH", "BACNINH", "BINHTHUAN", "BINHDUONG", "QUANGNGAI", "HOCHIMINH", "NAMDINH", "QUANGNGAI", "BINHTHUAN", "BACNINH", "BINHTHUAN"};
        String[] data54 = {"BINHTHUAN", "THAIBINH", "BINHDUONG", "HAIPHONG", "QUANGNGAI", "BINHTHUAN", "BACNINH", "NAMDINH", "BINHDUONG", "NAMDINH"};
        String[] data55 = {"QUANGNGAI", "THAIBINH", "BACNINH", "NAMDINH", "BACNINH", "THAIBINH", "BINHDUONG", "HAIPHONG", "HAIDUONG", "QUANGNGAI", "HAIDUONG"};
        String[] data56 = {"NAMDINH", "BACNINH", "HOCHIMINH", "QUANGNGAI", "QUANGNGAI", "BACNINH", "NAMDINH", "HAIDUONG", "THAIBINH", "BINHTHUAN", "BINHDUONG"};
        String[] data57 = {"BINHDUONG", "THAIBINH", "QUANGNGAI", "HOCHIMINH", "HAIDUONG", "NAMDINH", "BACNINH", "HAIPHONG"};
        String[] data58 = {"BINHTHUAN", "HAIPHONG", "HAIDUONG", "BACNINH", "NAMDINH", "BACNINH", "BINHTHUAN", "BACNINH", "QUANGNGAI", "HANOI", "HOCHIMINH"};
        String[] data59 = {"HANOI", "BINHTHUAN", "HOCHIMINH", "NAMDINH", "QUANGNGAI", "BINHTHUAN", "HOCHIMINH", "BINHDUONG", "HOCHIMINH", "NAMDINH", "BINHTHUAN"};
        String[] data60 = {"BINHTHUAN", "HAIPHONG", "HOCHIMINH", "BACNINH", "THAIBINH", "QUANGNGAI", "HOCHIMINH", "HAIPHONG", "HOCHIMINH", "QUANGNGAI", "QUANGNGAI"};
        String[] data61 = {"HOCHIMINH", "HAIDUONG", "NAMDINH", "BACNINH", "NAMDINH", "THAIBINH", "HOCHIMINH", "BINHDUONG", "BACNINH", "QUANGNGAI", "HOCHIMINH"};
        String[] data62 = {"NAMDINH", "QUANGNGAI", "NAMDINH", "BINHDUONG", "BINHTHUAN", "THAIBINH", "BINHDUONG", "NAMDINH", "BINHDUONG", "BINHTHUAN", "BACNINH", "HOCHIMINH", "BACNINH", "THAIBINH", "NAMDINH"};
        String[] data63 = {"HOCHIMINH", "HANOI", "HAIDUONG", "NAMDINH", "BINHTHUAN", "HANOI", "BINHTHUAN", "HAIPHONG", "QUANGNGAI", "THAIBINH", "QUANGNGAI"};
        String[] data64 = {"BINHTHUAN", "NAMDINH", "NAMDINH", "THAIBINH", "HOCHIMINH", "NAMDINH", "HAIDUONG", "HAIPHONG", "HAIDUONG", "THAIBINH", "BINHTHUAN"};
        String[] data65 = {"HAIPHONG", "BINHDUONG", "NAMDINH", "BINHTHUAN", "BACNINH", "HAIDUONG", "BINHTHUAN", "BINHDUONG", "HAIDUONG", "THAIBINH", "HAIDUONG"};
        String[] data66 = {"BINHTHUAN", "HAIDUONG", "HOCHIMINH", "QUANGNGAI", "HOCHIMINH", "BACNINH", "BINHDUONG", "THAIBINH", "BACNINH", "BINHTHUAN", "THAIBINH"};
        String[] data67 = {"BINHTHUAN", "HAIPHONG", "BINHTHUAN", "HAIDUONG", "BINHTHUAN", "HOCHIMINH", "THAIBINH", "HOCHIMINH", "HOCHIMINH", "BINHTHUAN", "HAIDUONG"};
        String[] data68 = {"HAIDUONG", "QUANGNGAI", "HANOI", "HAIPHONG", "THAIBINH", "BINHDUONG", "HAIPHONG"};
        String[] data69 = {"BACNINH", "QUANGNGAI", "BACNINH", "HAIPHONG", "HAIDUONG", "HANOI", "BINHTHUAN", "BINHDUONG", "HANOI", "BINHDUONG", "BACNINH"};
        String[] data70 = {"HAIDUONG", "HAIPHONG", "HAIDUONG", "THAIBINH", "BINHDUONG", "BACNINH", "QUANGNGAI", "HOCHIMINH", "THAIBINH", "BACNINH", "HAIPHONG"};
        String[] data71 = {"NAMDINH", "BINHDUONG", "THAIBINH", "BINHDUONG", "NAMDINH", "HAIDUONG", "NAMDINH", "HAIPHONG", "BACNINH", "BINHDUONG", "BACNINH"};
        String[] data72 = {"BINHTHUAN", "NAMDINH", "HAIPHONG", "BINHTHUAN", "HOCHIMINH", "BINHDUONG", "BACNINH", "NAMDINH", "BINHTHUAN", "BACNINH", "HOCHIMINH", "QUANGNGAI", "HAIPHONG"};
        String[] data73 = {"QUANGNGAI", "THAIBINH", "BACNINH", "QUANGNGAI", "BACNINH", "HOCHIMINH", "HAIPHONG", "THAIBINH", "BACNINH", "BINHDUONG", "NAMDINH"};
        String[] data74 = {"HAIPHONG", "NAMDINH", "HANOI", "QUANGNGAI", "HAIPHONG", "HAIDUONG", "THAIBINH", "HOCHIMINH", "HAIDUONG", "HANOI", "BACNINH"};
        String[] data75 = {"QUANGNGAI", "HAIPHONG", "QUANGNGAI", "HAIPHONG", "NAMDINH", "HANOI", "HOCHIMINH", "HAIDUONG"};
        String[] data76 = {"BACNINH", "THAIBINH", "HAIPHONG", "QUANGNGAI", "BINHTHUAN", "QUANGNGAI", "QUANGNGAI", "HANOI", "BINHTHUAN", "QUANGNGAI", "HAIPHONG"};
        String[] data77 = {"HOCHIMINH", "BINHTHUAN", "NAMDINH", "QUANGNGAI", "BINHDUONG", "HAIPHONG", "HAIDUONG", "HOCHIMINH", "QUANGNGAI", "THAIBINH", "BINHDUONG"};
        String[] data78 = {"THAIBINH", "BACNINH", "QUANGNGAI", "QUANGNGAI", "BINHDUONG", "HOCHIMINH", "NAMDINH", "BINHTHUAN", "HAIPHONG", "QUANGNGAI", "BINHTHUAN"};
        String[] data79= {"HAIPHONG", "QUANGNGAI", "BACNINH", "THAIBINH", "NAMDINH", "BACNINH", "THAIBINH", "HOCHIMINH", "QUANGNGAI", "BINHTHUAN", "HAIDUONG"};
        String[] data80 = {"THAIBINH", "QUANGNGAI", "HOCHIMINH", "HAIPHONG", "NAMDINH", "QUANGNGAI", "THAIBINH", "HANOI", "HAIPHONG", "BINHTHUAN", "NAMDINH"};
        String[] data81 = {"HAIDUONG", "BACNINH", "HOCHIMINH", "NAMDINH", "BINHTHUAN", "BACNINH", "NAMDINH", "HAIPHONG", "HOCHIMINH", "HAIPHONG", "HOCHIMINH", "BINHDUONG", "HAIDUONG", "BINHDUONG", "BINHTHUAN", "HAIPHONG"};
        String[] data82 = {"BINHDUONG", "NAMDINH", "THAIBINH", "HOCHIMINH", "HANOI", "QUANGNGAI", "HAIDUONG", "QUANGNGAI", "BINHDUONG", "BINHTHUAN", "THAIBINH"};
        String[] data83 = {"BINHDUONG", "BINHDUONG", "HAIPHONG", "HOCHIMINH", "QUANGNGAI", "HOCHIMINH", "QUANGNGAI"};
        String[] data84 = {"NAMDINH", "BACNINH", "BINHTHUAN", "BACNINH", "HOCHIMINH", "BACNINH", "HAIDUONG", "HOCHIMINH", "QUANGNGAI", "THAIBINH", "HOCHIMINH"};
        String[] data85 = {"BINHTHUAN", "HAIDUONG", "BINHDUONG", "HAIPHONG", "BACNINH", "HOCHIMINH"};
        String[] data86 = {"NAMDINH", "HAIDUONG", "NAMDINH", "HAIDUONG", "BACNINH", "QUANGNGAI", "HANOI", "HAIPHONG", "BINHTHUAN", "HAIPHONG", "HAIPHONG"};
        String[] data87 = {"THAIBINH", "HANOI", "HAIPHONG", "NAMDINH", "BINHTHUAN", "HANOI", "HAIDUONG", "QUANGNGAI", "NAMDINH", "BINHDUONG", "THAIBINH"};
        String[] data88 = {"BINHDUONG", "HOCHIMINH", "NAMDINH", "HANOI", "THAIBINH", "QUANGNGAI", "HANOI", "BINHDUONG", "HOCHIMINH", "BACNINH", "HAIPHONG"};
        String[] data89 = {"HAIPHONG", "BINHTHUAN", "HAIPHONG", "HOCHIMINH", "QUANGNGAI", "BINHTHUAN", "QUANGNGAI", "HANOI", "HAIPHONG", "HAIDUONG", "HANOI"};
        String[] data90 = {"THAIBINH", "BINHTHUAN", "HANOI"};
        String[] data91 = {"QUANGNGAI", "HOCHIMINH", "BACNINH", "BINHTHUAN", "HAIDUONG", "HOCHIMINH", "BINHDUONG", "HANOI", "HAIPHONG", "THAIBINH", "QUANGNGAI"};
        String[] data92 = {"BINHTHUAN", "BINHDUONG", "HAIPHONG", "HAIPHONG", "NAMDINH", "HOCHIMINH", "HAIDUONG", "BINHDUONG", "HAIPHONG", "BACNINH", "NAMDINH", "BINHDUONG"};
        String[] data93 = {"THAIBINH", "HOCHIMINH", "BINHDUONG", "HAIDUONG", "NAMDINH", "THAIBINH", "NAMDINH", "BINHDUONG", "NAMDINH", "HOCHIMINH", "QUANGNGAI"};
        String[] data94 = {"HOCHIMINH", "HANOI", "BACNINH", "BINHTHUAN", "NAMDINH", "THAIBINH", "HAIPHONG", "BINHDUONG", "BACNINH", "QUANGNGAI", "BINHDUONG"};
        String[] data95 = {"BINHDUONG", "HOCHIMINH", "HANOI", "THAIBINH", "HOCHIMINH", "NAMDINH"};
        String[] data96 = {"HOCHIMINH", "BACNINH", "HAIPHONG", "NAMDINH", "QUANGNGAI", "THAIBINH"};
        String[] data97 = {"HAIPHONG", "BACNINH", "BINHDUONG", "QUANGNGAI", "BACNINH", "BINHTHUAN"};
        String[] data98 = {"QUANGNGAI", "THAIBINH", "NAMDINH", "HANOI", "HAIPHONG", "HOCHIMINH"};
        String[] data99 = {"THAIBINH", "BACNINH", "THAIBINH", "BINHTHUAN", "HOCHIMINH", "THAIBINH"};
        String[] data100 = {"HOCHIMINH", "HAIPHONG", "THAIBINH", "HAIPHONG", "NAMDINH", "BINHTHUAN"};
        //test
        // gens arr to list
        List<String> dataList1 = Arrays.asList(data1);
        List<String> dataList2 = Arrays.asList(data2);
        List<String> dataList3 = Arrays.asList(data3);
        List<String> dataList4 = Arrays.asList(data4);
        List<String> dataList5 = Arrays.asList(data5);
        List<String> dataList6 = Arrays.asList(data6);
        List<String> dataList7 = Arrays.asList(data7);
        List<String> dataList8 = Arrays.asList(data8);
        List<String> dataList9 = Arrays.asList(data9);
        List<String> dataList10 = Arrays.asList(data10);
        List<String> dataList11 = Arrays.asList(data11);
        List<String> dataList12 = Arrays.asList(data12);
        List<String> dataList13 = Arrays.asList(data13);
        List<String> dataList14 = Arrays.asList(data14);
        List<String> dataList15 = Arrays.asList(data15);
        List<String> dataList16 = Arrays.asList(data16);
        List<String> dataList17 = Arrays.asList(data17);
        List<String> dataList18 = Arrays.asList(data18);
        List<String> dataList19 = Arrays.asList(data19);
        List<String> dataList20 = Arrays.asList(data20);
        List<String> dataList21 = Arrays.asList(data21);
        List<String> dataList22 = Arrays.asList(data22);
        List<String> dataList23 = Arrays.asList(data23);
        List<String> dataList24 = Arrays.asList(data24);
        List<String> dataList25 = Arrays.asList(data25);
        List<String> dataList26 = Arrays.asList(data26);
        List<String> dataList27 = Arrays.asList(data27);
        List<String> dataList28 = Arrays.asList(data28);
        List<String> dataList29 = Arrays.asList(data29);
        List<String> dataList30 = Arrays.asList(data30);
        List<String> dataList31 = Arrays.asList(data31);
        List<String> dataList32 = Arrays.asList(data32);
        List<String> dataList33 = Arrays.asList(data33);
        List<String> dataList34 = Arrays.asList(data34);
        List<String> dataList35 = Arrays.asList(data35);
        List<String> dataList36 = Arrays.asList(data36);
        List<String> dataList37 = Arrays.asList(data37);
        List<String> dataList38 = Arrays.asList(data38);
        List<String> dataList39 = Arrays.asList(data39);
        List<String> dataList40 = Arrays.asList(data40);
        List<String> dataList41 = Arrays.asList(data41);
        List<String> dataList42 = Arrays.asList(data42);
        List<String> dataList43 = Arrays.asList(data43);
        List<String> dataList44 = Arrays.asList(data44);
        List<String> dataList45 = Arrays.asList(data45);
        List<String> dataList46 = Arrays.asList(data46);
        List<String> dataList47 = Arrays.asList(data47);
        List<String> dataList48 = Arrays.asList(data48);
        List<String> dataList49 = Arrays.asList(data49);
        List<String> dataList50 = Arrays.asList(data50);
        List<String> dataList51 = Arrays.asList(data51);
        List<String> dataList52 = Arrays.asList(data52);
        List<String> dataList53 = Arrays.asList(data53);
        List<String> dataList54 = Arrays.asList(data54);
        List<String> dataList55 = Arrays.asList(data55);
        List<String> dataList56 = Arrays.asList(data56);
        List<String> dataList57 = Arrays.asList(data57);
        List<String> dataList58 = Arrays.asList(data58);
        List<String> dataList59 = Arrays.asList(data59);
        List<String> dataList60 = Arrays.asList(data60);
        List<String> dataList61 = Arrays.asList(data61);
        List<String> dataList62 = Arrays.asList(data62);
        List<String> dataList63 = Arrays.asList(data63);
        List<String> dataList64 = Arrays.asList(data64);
        List<String> dataList65 = Arrays.asList(data65);
        List<String> dataList66 = Arrays.asList(data66);
        List<String> dataList67 = Arrays.asList(data67);
        List<String> dataList68 = Arrays.asList(data68);
        List<String> dataList69 = Arrays.asList(data69);
        List<String> dataList70 = Arrays.asList(data70);
        List<String> dataList71 = Arrays.asList(data71);
        List<String> dataList72 = Arrays.asList(data72);
        List<String> dataList73 = Arrays.asList(data73);
        List<String> dataList74 = Arrays.asList(data74);
        List<String> dataList75 = Arrays.asList(data75);
        List<String> dataList76 = Arrays.asList(data76);
        List<String> dataList77 = Arrays.asList(data77);
        List<String> dataList78 = Arrays.asList(data78);
        List<String> dataList79 = Arrays.asList(data79);
        List<String> dataList80 = Arrays.asList(data80);
        List<String> dataList81 = Arrays.asList(data81);
        List<String> dataList82 = Arrays.asList(data82);
        List<String> dataList83 = Arrays.asList(data83);
        List<String> dataList84 = Arrays.asList(data84);
        List<String> dataList85 = Arrays.asList(data85);
        List<String> dataList86 = Arrays.asList(data86);
        List<String> dataList87 = Arrays.asList(data87);
        List<String> dataList88 = Arrays.asList(data88);
        List<String> dataList89 = Arrays.asList(data89);
        List<String> dataList90 = Arrays.asList(data90);
        List<String> dataList91 = Arrays.asList(data91);
        List<String> dataList92 = Arrays.asList(data92);
        List<String> dataList93 = Arrays.asList(data93);
        List<String> dataList94 = Arrays.asList(data94);
        List<String> dataList95 = Arrays.asList(data95);
        List<String> dataList96 = Arrays.asList(data96);
        List<String> dataList97 = Arrays.asList(data97);
        List<String> dataList98 = Arrays.asList(data98);
        List<String> dataList99 = Arrays.asList(data99);
        List<String> dataList100 = Arrays.asList(data100);

//        System.out.println(iPointService.geneSlicing(Arrays.asList(data90),new PointInfo("HANOI","HAIPHONG","NAMDINH")));
        List<String> test = iPointService.geneSlicing(Arrays.asList(data1),new PointInfo("HANOI","HAIPHONG","NAMDINH"));

        List<String> gens1 = new ArrayList<>();
        List<String> gens2 = new ArrayList<>();
        List<String> gens3 = new ArrayList<>();
        List<String> gens4 = new ArrayList<>();
        List<String> gens5 = new ArrayList<>();


        // tao the he 1

        List<String> a = Arrays.asList("NAMDINH", "HOCHIMINH");
        List<String> a1 = Arrays.asList( "HOCHIMINH", "BINHDUONG");
        List<String> a2 = Arrays.asList( "BINHDUONG", "THAIBINH");
        List<String> a3 = Arrays.asList("THAIBINH", "QUANGNGAI");
        List<String> a4 = Arrays.asList( "QUANGNGAI", "THAIBINH");
        List<String> a5 = Arrays.asList( "THAIBINH", "HAIPHONG");
        List<String> a6 = Arrays.asList( "HAIPHONG", "QUANGNGAI");
        List<String> a7 = Arrays.asList( "QUANGNGAI", "THAIBINH");
        List<String> a8 = Arrays.asList( "THAIBINH", "HANOI");
        float kc  = iPointService.calculateDistance(a);
        float kc1  = iPointService.calculateDistance(a1);
        float kc2  = iPointService.calculateDistance(a2);
        float kc3  = iPointService.calculateDistance(a3);
        float kc4  = iPointService.calculateDistance(a4);
        float kc5  = iPointService.calculateDistance(a5);
        float kc6  = iPointService.calculateDistance(a6);
        float kc7  = iPointService.calculateDistance(a7);
        float kc8  = iPointService.calculateDistance(a8);
        List<GenerationInformationByDistance>  generation1 = new ArrayList<>(); // the he 1 sinh tay de loai bo cac th bi ko co duong di
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList1,pointInfo))  ,dataList1));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList2,pointInfo)),dataList2));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList3,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList4,pointInfo)),dataList4));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList5,pointInfo)),dataList5));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList6,pointInfo)),dataList6));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList7,pointInfo)),dataList7));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList8,pointInfo)),dataList8));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList9,pointInfo)),dataList9));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList10,pointInfo)),dataList10));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList11,pointInfo)),dataList11));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList12,pointInfo)),dataList12));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList13,pointInfo)),dataList13));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList14,pointInfo)),dataList14));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList15,pointInfo)),dataList15));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList16,pointInfo)),dataList16));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList17,pointInfo)),dataList17));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList18,pointInfo)),dataList18));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList19,pointInfo)),dataList19));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList20,pointInfo)),dataList20));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList21,pointInfo)),dataList21));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList22,pointInfo)),dataList22));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList23,pointInfo)),dataList23));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList24,pointInfo)),dataList24));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList25,pointInfo)),dataList25));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList26,pointInfo)),dataList26));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList27,pointInfo)),dataList27));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList28,pointInfo)),dataList28));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList29,pointInfo)),dataList29));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList30,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList31,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList32,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList33,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList34,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList35,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList36,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList37,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList38,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList39,pointInfo)),dataList3));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList40,pointInfo)),dataList40));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList41,pointInfo)),dataList41));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList42,pointInfo)),dataList42));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList43,pointInfo)),dataList43));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList44,pointInfo)),dataList44));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList45,pointInfo)),dataList45));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList46,pointInfo)),dataList46));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList47,pointInfo)),dataList47));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList48,pointInfo)),dataList48));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList49,pointInfo)),dataList49));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList50,pointInfo)),dataList50));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList51,pointInfo)),dataList51));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList52,pointInfo)),dataList52));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList53,pointInfo)),dataList53));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList54,pointInfo)),dataList54));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList55,pointInfo)),dataList55));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList56,pointInfo)),dataList56));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList57,pointInfo)),dataList57));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList58,pointInfo)),dataList58));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList59,pointInfo)),dataList59));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList60,pointInfo)),dataList60));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList61,pointInfo)),dataList61));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList62,pointInfo)),dataList62));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList63,pointInfo)),dataList63));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList64,pointInfo)),dataList64));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList65,pointInfo)),dataList65));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList66,pointInfo)),dataList66));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList67,pointInfo)),dataList67));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList68,pointInfo)),dataList68));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList69,pointInfo)),dataList69));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList70,pointInfo)),dataList70));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList71,pointInfo)),dataList71));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList72,pointInfo)),dataList72));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList73,pointInfo)),dataList73));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList74,pointInfo)),dataList74));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList75,pointInfo)),dataList75));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList76,pointInfo)),dataList76));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList77,pointInfo)),dataList77));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList78,pointInfo)),dataList78));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList79,pointInfo)),dataList79));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList80,pointInfo)),dataList80));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList81,pointInfo)),dataList81));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList82,pointInfo)),dataList82));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList83,pointInfo)),dataList83));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList84,pointInfo)),dataList84));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList85,pointInfo)),dataList85));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList86,pointInfo)),dataList86));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList87,pointInfo)),dataList87));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList88,pointInfo)),dataList88));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList89,pointInfo)),dataList89));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList90,pointInfo)),dataList90));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList91,pointInfo)),dataList91));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList92,pointInfo)),dataList92));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList93,pointInfo)),dataList93));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList94,pointInfo)),dataList94));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList95,pointInfo)),dataList95));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList96,pointInfo)),dataList96));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList97,pointInfo)),dataList97));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList98,pointInfo)),dataList98));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList99,pointInfo)),dataList99));
        generation1.add(new GenerationInformationByDistance(iPointService.calculateDistance(iPointService.geneSlicing(dataList100,pointInfo)),dataList100));








































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
