package com.example.project_backend.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheBest5Time {
    private GenerationInformationByTime list1;
    private GenerationInformationByTime list2;
    private GenerationInformationByTime list3;
    private GenerationInformationByTime list4;
    private GenerationInformationByTime list5;
}
