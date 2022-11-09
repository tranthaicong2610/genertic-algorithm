package com.example.project_backend.service.impl;

import com.example.project_backend.form.PointInfo;
import com.example.project_backend.model.Point;
import com.example.project_backend.repository.PointRepository;
import com.example.project_backend.service.IPointService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointServiceImpl implements IPointService {

    private final PointRepository  pointRepository;
    @Autowired
    public PointServiceImpl(PointRepository pointRepository){
        this.pointRepository = pointRepository;
    }
    @Override
    public List<Point> getPoints() {

        return pointRepository.findAll();
    }


    /**
     * random chi lay 0 va 1 va loai 1 vi co su cong bang hon khi 1 chiem den khoang vung 1
     * @param father ca the cha ung voi 0
     * @param mother ca the me ung voi 2
     * @return tra ve ca the con
     */

    @Override
    public List<String> crossover(List<String> father, List<String> mother ,PointInfo pointInfo) {
        List<String> childIndividual ;
        double a ;
        int selectFatherOrMother  ;
        while(true){
            childIndividual = new ArrayList<>();
            for(int i = 0 ; i < father.size() ; i++){
                a = Math.random();
                selectFatherOrMother = (int) Math.round(a*2);
                while(selectFatherOrMother ==1){
                    a =Math.random();
                    selectFatherOrMother = (int) Math.round(a*2);
                }
                String s = (selectFatherOrMother == 0) ?  father.get(i) :  mother.get(i);
                childIndividual.add(s);
            }
            if(checkGen(childIndividual , pointInfo)) {
                break;
            }
        }

        return childIndividual;
    }

    /**
     * ham co nhiem vu tao ca the con dot bien bang cach tim kiem 1 vi tri bat ky sau do dot bien no
     * @param father ca the cha
     * @param pointInfo cac thanh pho lay tu clien chuyen ve
     * @return tra ve ca the con dot bien
     */
    @Override
    public List<String> mutation(List<String> father,PointInfo pointInfo) {
        List<String> cityNames = this.pointRepository.getNameCity();
        List<String> childIndividual ;
        while(true){
            childIndividual = new ArrayList<>();
            for(String val : father) {
                childIndividual.add(val);
            }
            // vi tri dot bien
            int mutationPoint =  (int)Math.round(Math.random()*17);

            // gia tri dot bien
            String mutationValue = cityNames.get((int)Math.round(Math.random()*9));

            // cap nhat gen dot bien
            childIndividual.set(mutationPoint,mutationValue);

            // kiem tra gen thoa man dieu kien gen t/m va con khac cha
            if(checkGen(childIndividual , pointInfo) && childIndividual.equals(father)) {
                break;
            }
        }
        return childIndividual;
    }



    /**
     * ham check sự phù hợp của gen đc tạo ra
     * kiểm tra xem có 2 giá trị trùng sát nhau
     * kiểm tra có tồn tại 3 điểm trong gen ko
     *
     * @param gens
     * @param pointInfo
     * @return
     */

    static Boolean checkGen(List<String> gens ,PointInfo pointInfo){
        // kiem tra xem co 2 gia tri trung gan nhau
        for(int i=0;i < gens.size()-1 ;i++){
            if(gens.get(i).equals(gens.get(i+1)) ){
                return false;
            }
        }

        // kiem tra xem ma gen da di qua 3 diem chua
        if(!(
            gens.contains(pointInfo.getPoint1()) &&
            gens.contains(pointInfo.getPoint1()) &&
            gens.contains(pointInfo.getPoint1())
        )){
            return false;
        }

        // qua het cac dieu kien
        return true;
    }


    /**
     * Tinh quang duong phai di chuyen
     * @param pointInfo cac diem di qua
     * @return
     */
    @Override
    public int calculateDistance(PointInfo pointInfo) {


        return 0;
    }


    /**
     * ham lay cat ra doan chua 3 diem can xet
     * @param gens doan ma gen
     * @param pointInfo cac diem di qua nguoi dung muon
     * @return tra ve doan ma co chua 3 diem can xet
     */
    List<String> geneSlicing (List<String> gens,PointInfo pointInfo){
        int indexPoint1 = gens.indexOf(pointInfo.getPoint1());
        int indexPoint2 = gens.indexOf(pointInfo.getPoint2());
        int indexPoint3 = gens.indexOf(pointInfo.getPoint3());
        int pointStart = Math.min(indexPoint1,Math.min(indexPoint2,indexPoint3));
        int pointEnd = Math.max(indexPoint1,Math.min(indexPoint2,indexPoint3));
        return gens.subList(pointStart,pointEnd+1);
    }




    public static void main(String[] args) {
//        int i=0;
//        while(i<10){
//            System.out.println((int)Math.round(Math.random()*2));
//            i++;
//        }
//        PointInfo a = new PointInfo("1","1","1");
//        PointInfo b = new PointInfo("1","1","1");
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
        List<String> arr = new ArrayList<>();
        arr.add("ok1");
        arr.add("ok2");
        arr.add("ok1");
        arr.add("ok1");
        arr.add("ok3");
        arr.add("ok2");
        arr.add("ok3");
        int pointStart = arr.indexOf("ok1");
        int pointEnd = arr.indexOf("ok3");
        System.out.println(arr.indexOf("ok1"));
        System.out.println(arr.indexOf("ok3"));
        System.out.println(arr.subList(pointStart,pointEnd+1));
//        String ok ="tran thai cong";
//        System.out.println(ok.substring(5,9));
    }



}
