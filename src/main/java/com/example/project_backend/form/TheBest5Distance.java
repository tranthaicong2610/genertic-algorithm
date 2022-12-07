package com.example.project_backend.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheBest5Distance {
    private GenerationInformationByDistance list1;
    private GenerationInformationByDistance list2;
    private GenerationInformationByDistance list3;
    private GenerationInformationByDistance list4;
    private GenerationInformationByDistance list5;

}
