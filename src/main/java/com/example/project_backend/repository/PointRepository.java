package com.example.project_backend.repository;

import com.example.project_backend.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point,Integer> {
    @Query(value="select name from point ", nativeQuery=true)
    List<String> getNameCity();
}
