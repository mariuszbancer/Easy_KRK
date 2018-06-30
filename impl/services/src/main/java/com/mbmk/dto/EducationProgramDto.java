package com.mbmk.dto;

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
    private String fieldOfStudyName;
    private String studiesProfile;
    private LocalDate createdAt;
    private LocalDate startsAt;
    private String levelOfEducation;
    private String courseForm;
    private String language;
    private Long studiesProgramId;
    private Long studiesPlanId;
}