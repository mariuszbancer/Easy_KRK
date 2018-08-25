package com.mbmk.dto;

import com.mbmk.model.domain.*;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
public class CreateCourseEnumDto {
    private List<String> courseForms = Stream.of(CourseForm.values()).map(CourseForm::getFormName).collect(Collectors.toList());
    private List<String> courseTypes = Stream.of(CourseType.values()).map(CourseType::getTypeName).collect(Collectors.toList());
    private List<String> passingMethods = Stream.of(PassingMethod.values()).map(PassingMethod::getMethodName).collect(Collectors.toList());
    private List<String> courseKinds = Stream.of(CourseKind.values()).map(CourseKind::getKindName).collect(Collectors.toList());
    private List<String> studiesProfiles = Stream.of(StudiesProfile.values()).map(StudiesProfile::getProfileName).collect(Collectors.toList());
}
