package com.mbmk.services;

import com.mbmk.dto.CourseDto;
import com.mbmk.mappers.CourseMapper;
import com.mbmk.model.domain.Course;
import com.mbmk.model.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDto> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toDtos(courses);
    }

    public CourseDto create(CourseDto courseDto) {
        Course.CourseBuilder courseBuilder = Course.builder();
        courseBuilder
                .cnpsHours(courseDto.getCnpsHours())
                .zzuHours(courseDto.getZzuHours())
                .ectsPoints(courseDto.getEctsPoints())
                .code(courseDto.getCode())
                .courseForm(courseDto.getCourseForm())
                .courseKind(courseDto.getCourseKind())
                .studiesProfile(courseDto.getStudiesProfile())
                .passingMethod(courseDto.getPassingMethod())
                .courseType(courseDto.getCourseType());

        Course course = courseBuilder.build();
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDto(savedCourse);
    }
}