package com.mbmk.rest;

import com.mbmk.dto.CourseDto;
import com.mbmk.dto.CreateCourseEnumDto;
import com.mbmk.services.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("courses")
    @ResponseBody
    public List<CourseDto> getAllCourses() {
        log.debug("Request to getAllCourses");
        return courseService.getAll();
    }

    @GetMapping("courses/enum")
    @ResponseBody
    public CreateCourseEnumDto createCourseEnumDto() {
        return new CreateCourseEnumDto();
    }

    @PostMapping("courses")
    @ResponseBody
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        log.debug("create course: {}", courseDto);
        return courseService.create(courseDto);
    }
}
