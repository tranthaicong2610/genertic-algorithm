package com.example.project_backend.form;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerationInformationByTime {
    private float time ;
    private List<String> gens;
}
