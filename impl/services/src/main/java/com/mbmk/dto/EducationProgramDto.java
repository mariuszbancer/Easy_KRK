package com.mbmk.dto;

import com.mbmk.model.domain.CourseForm;
import com.mbmk.model.domain.LevelOfEducation;
import com.mbmk.model.domain.StudiesProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationProgramDto {
    private Long id;
    private Long fieldOfStudyId;
    private StudiesProfile studiesProfile;
    private LocalDate createdAt;
    private LocalDate startsAt;
    private LevelOfEducation levelOfEducation;
    private CourseForm courseForm;
    private String language;
}