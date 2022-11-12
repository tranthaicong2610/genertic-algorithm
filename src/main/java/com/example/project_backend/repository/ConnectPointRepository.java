package com.example.project_backend.repository;

import com.example.project_backend.model.ConnectPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ConnectPointRepository extends JpaRepository<ConnectPoint,Integer> {
    @Query(value="select cp.distance from connect_point cp where cp.point_start = ?1 and cp.point_end = ?2 limit 1", nativeQuery=true)
    Float getDistance(String pointStart,String pointEnd);

    @Query(value = "select cp.time from connect_point cp where cp.point_start = ?1 and cp.point_end = ?2 limit 1",nativeQuery = true)
    Float getTime(String pointStart, String pointEnd);
}
