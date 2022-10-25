package com.example.project_backend.repository;

import com.example.project_backend.model.ConnectPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
@Repository
public interface ConnectPointRepository extends JpaRepository<ConnectPoint,Integer> {
}
