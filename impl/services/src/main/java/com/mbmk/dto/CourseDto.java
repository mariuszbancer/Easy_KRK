package com.mbmk.dto;

import com.mbmk.model.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id;
    private String name;
    private Long ectsPoints;
    private String code;
    private Long zzuHours;
    private Long cnpsHours;
    private CourseForm courseForm;
    private PassingMethod passingMethod;
    private StudiesProfile studiesProfile;
    private CourseKind courseKind;
    private CourseType courseType;
}