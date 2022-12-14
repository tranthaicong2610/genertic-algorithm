package com.example.project_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "connectPoint")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConnectPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name ="pointStart")
    private String pointStart;

    @Column(name = "pointEnd")
    private String pointEnd;

    @Column(name="distance")
    private float distance;

    @Column(name = "time")
    private float time;


}
