package com.mbmk.dto;

import com.mbmk.model.domain.CourseForm;
import com.mbmk.model.domain.LevelOfEducation;
import com.mbmk.model.domain.StudiesProfile;
import lombok.Data;

import java.util.Date;

@Data
public class EducationProgramDto {
    private Long fieldOfStudyId;
    private StudiesProfile studiesProfile;
    private Date createdAt;
    private Date startsAt;
    private LevelOfEducation levelOfEducation;
    private CourseForm courseForm;
    private String language;
}