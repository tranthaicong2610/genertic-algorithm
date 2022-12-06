package com.example.project_backend.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheBest5Distance {
    private List<GenerationInformationByDistance> list1;
    private List<GenerationInformationByDistance> list2;
    private List<GenerationInformationByDistance> list3;
    private List<GenerationInformationByDistance> list4;
    private List<GenerationInformationByDistance> list5;

}
