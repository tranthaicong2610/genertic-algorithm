package com.example.project_backend.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationInfo {
    private List<String> gens;
    private float distance;
    private float time;
    private float fitness;
}
