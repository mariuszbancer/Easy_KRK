package com.mbmk.rest;

import com.mbmk.dto.StudiesPlanDto;
import com.mbmk.services.StudiesPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class StudiesPlanController {

    private final StudiesPlanService studiesPlanService;

    @PostMapping("studiesPlans")
    @RequestBody
    public StudiesPlanDto create(@RequestBody StudiesPlanDto studiesPlanDto) {
      log.debug("Create studies plan {}", studiesPlanDto);
      return studiesPlanService.create(studiesPlanDto);
    }
}
