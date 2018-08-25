package com.mbmk.rest;

import com.mbmk.dto.StudiesPlanDto;
import com.mbmk.services.StudiesPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class StudiesPlanController {

    private final StudiesPlanService studiesPlanService;

    @PostMapping("studiesPlans")
    @ResponseBody
    public StudiesPlanDto create(@RequestBody StudiesPlanDto studiesPlanDto) {
      log.debug("Create studies plan {}", studiesPlanDto);
      return studiesPlanService.create(studiesPlanDto);
    }

    @GetMapping("studiesPlans/{id}")
    @ResponseBody
    public StudiesPlanDto getById(@PathVariable("id") Long id) {
        return studiesPlanService.getById(id);
    }

    @PutMapping("studiesPlans")
    @ResponseBody
    public StudiesPlanDto update(@RequestBody StudiesPlanDto studiesPlanDto) {
        return studiesPlanService.update(studiesPlanDto);
    }
}
