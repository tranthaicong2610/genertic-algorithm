package com.example.project_backend;

import com.example.project_backend.form.Gen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("test")
    String hello(){
        return "oke";
    }

    public static void main(String[] args) {
        String[] address = new String[]{"HANOI","HAIPHONG","NAMDINH","BINHDUONG","QUANGNGAI","HOCHIMINH","BINHTHUAN","THAIBINH","BACNINH","HAIDUONG"};
        List<Gen>  gennerationInit = new ArrayList<>();
        Random length = new Random();
//        for(int i=0;i<100;i++)
//        {
//            int genLength = length.nextInt(17) +1 ;
//            List<String> genRandom = new ArrayList<>();
//            while(genLength < 3) {
//                genLength = length.nextInt(17) +1 ;
//            }
//            int ranIndex ;
//            for(int k=0;k<genLength;k++){
//                ranIndex = length.nextInt(10);
//                genRandom.add(address[ranIndex]);
//            }
//            System.out.println(i + " "+genRandom);
//            gennerationInit.add(new Gen(genRandom));
//        }
        List<String> list = new ArrayList<>();
        list.add("Tran");
        list.add("Thai");
        list.add("Cong");

        List<String> list1 = new ArrayList<>();
        list1.add("Tran");
        list1.add("Thai");
        list1.add("Cong");
        gennerationInit.add(new Gen(list));
        gennerationInit.add(new Gen(list1));
        System.out.println(gennerationInit.get(0).equals(gennerationInit.get(1)));

        System.out.println(gennerationInit);


    }
}
