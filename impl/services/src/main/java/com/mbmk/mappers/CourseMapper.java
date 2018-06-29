package com.mbmk.mappers;

import com.mbmk.dto.CourseDto;
import com.mbmk.model.domain.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .ectsPoints(course.getEctsPoints())
                .code(course.getCode())
                .zzuHours(course.getZzuHours())
                .cnpsHours(course.getCnpsHours())
                .courseForm(course.getCourseForm())
                .passingMethod(course.getPassingMethod())
                .studiesProfile(course.getStudiesProfile())
                .courseKind(course.getCourseKind())
                .courseType(course.getCourseType())
                .build();
    }

    public List<CourseDto> toDtos(List<Course> courses) {
        return courses.stream().map(this::toDto).collect(Collectors.toList());
    }
}