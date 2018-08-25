package com.mbmk.rest;

import com.mbmk.dto.SemesterDto;
import com.mbmk.services.SemesterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
@Slf4j
public class SemesterController {

    private final SemesterService semesterService;

    @PostMapping("semesters")
    @ResponseBody
    public SemesterDto createSemesters(@RequestBody SemesterDto semesterDto) {
        log.debug("Create semester {}", semesterDto);
        return semesterService.createSemester(semesterDto);
    }

    @GetMapping("semesters")
    @ResponseBody
    public List<SemesterDto> getAllSemesters() {
        log.debug("Request to getAllSemesters");
        return semesterService.getAll();
    }
}