package com.mbmk.rest;

import com.mbmk.dto.DepartmentDto;
import com.mbmk.dto.FieldOfStudyDto;
import com.mbmk.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping(path = "departments")
    @ResponseBody
    public List<DepartmentDto> getAllDepartments() {
        log.debug("Rest request to get all departments");
        return departmentService.getAllDepartmens();
    }

    @GetMapping(path = "departments/{id}/fieldOfStudies")
    public List<FieldOfStudyDto> getAllFieldOfStudies(@PathVariable("id") Long departmentId) {
        log.debug("Rest request to get all fields of studies by departmentId: {}", departmentId);
        return departmentService.getFieldOfStudiesByDepartment(departmentId);
    }
}
