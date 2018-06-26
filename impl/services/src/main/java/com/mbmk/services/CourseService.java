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
}