package com.mbmk.rest;

import com.mbmk.dto.StudiesProgramDto;
import com.mbmk.services.StudiesProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class StudiesProgramController {
    private final StudiesProgramService studiesProgramService;

    @PostMapping("studiesPrograms")
    @ResponseBody
    public StudiesProgramDto create(@RequestBody StudiesProgramDto studiesProgramDto) {
        log.debug("Create studies program {}", studiesProgramDto);
        return studiesProgramService.create(studiesProgramDto);
    }
}
