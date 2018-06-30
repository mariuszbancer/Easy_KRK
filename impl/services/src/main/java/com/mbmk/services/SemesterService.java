package com.mbmk.services;

import com.mbmk.dto.CourseDto;
import com.mbmk.dto.SemesterDto;
import com.mbmk.mappers.SemesterMapper;
import com.mbmk.model.domain.Course;
import com.mbmk.model.domain.Semester;
import com.mbmk.model.repository.CourseRepository;
import com.mbmk.model.repository.SemesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Transactional
public class SemesterService {
    private final SemesterRepository semesterRepository;
    private final SemesterMapper semesterMapper;
    private final CourseRepository courseRepository;

    public SemesterDto createSemester(SemesterDto semesterDto) {
        Semester.SemesterBuilder builder = Semester.builder();

        if(!CollectionUtils.isEmpty(semesterDto.getCourses())) {
            List<Long> coursesIds = semesterDto.getCourses().stream().map(CourseDto::getId).collect(Collectors.toList());
            List<Course> courses = courseRepository.findAllById(coursesIds);
            builder.courses(courses);
        }
        Semester semester = builder.build();
        Semester savedSemester = semesterRepository.save(semester);
        savedSemester.getCourses().forEach(course -> course.getSemesters().add(savedSemester));
        courseRepository.saveAll(savedSemester.getCourses());
        return semesterMapper.toDto(savedSemester);
    }

    public List<SemesterDto> getAll() {
        List<Semester> semesters = semesterRepository.findAll();
        return semesterMapper.toDtos(semesters);
    }
}