package com.example.project_backend.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheBest5Time {
    private List<GenerationInformationByTime> list1;
    private List<GenerationInformationByTime> list2;
    private List<GenerationInformationByTime> list3;
    private List<GenerationInformationByTime> list4;
    private List<GenerationInformationByTime> list5;
}
