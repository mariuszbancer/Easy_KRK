package com.mbmk.mappers;

import com.mbmk.dto.SemesterDto;
import com.mbmk.model.domain.Course;
import com.mbmk.model.domain.Semester;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SemesterMapper {

    private final CourseMapper courseMapper;

    public SemesterDto toDto(Semester semester) {
        return SemesterDto.builder()
                .id(semester.getId())
                .courses(!CollectionUtils.isEmpty(semester.getCourses()) ? courseMapper.toDtos(semester.getCourses()): new ArrayList<>())
                .coursesString(!CollectionUtils.isEmpty(semester.getCourses()) ? semester.getCourses().stream().map(Course::getCode).collect(Collectors.joining(",")) : "")
                .number(semester.getNumber())
                .build();
    }

    public List<SemesterDto> toDtos(List<Semester> semesters) {
        return semesters.stream().map(this::toDto).collect(Collectors.toList());
    }

}