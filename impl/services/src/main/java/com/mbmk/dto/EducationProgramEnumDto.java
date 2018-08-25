package com.mbmk.dto;

import com.mbmk.model.domain.CourseForm;
import com.mbmk.model.domain.LevelOfEducation;
import com.mbmk.model.domain.StudiesProfile;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
public class EducationProgramEnumDto {
    List<String> studiesProfiles = Stream.of(StudiesProfile.values()).map(StudiesProfile::getProfileName).collect(Collectors.toList());
    List<String> levelsOfEducation = Stream.of(LevelOfEducation.values()).map(LevelOfEducation::getLevelName).collect(Collectors.toList());
    List<String> courseForms = Stream.of(CourseForm.values()).map(CourseForm::getFormName).collect(Collectors.toList());
}
