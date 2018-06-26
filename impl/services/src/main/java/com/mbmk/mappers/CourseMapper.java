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
                .build();
    }

    public List<CourseDto> toDtos(List<Course> courses) {
        return courses.stream().map(this::toDto).collect(Collectors.toList());
    }
}