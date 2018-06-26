package com.mbmk.rest;

import com.mbmk.dto.FieldOfStudyDto;
import com.mbmk.services.FieldOfStudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
@Slf4j
public class FieldOfStudyController {

    private final FieldOfStudyService fieldOfStudyService;

    @GetMapping("fieldOfStudies")
    public List<FieldOfStudyDto> getAll() {
        log.debug("get all field of studies");
        return fieldOfStudyService.getAll();
    }
}
