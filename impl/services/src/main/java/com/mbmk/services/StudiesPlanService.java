package com.mbmk.services;

import com.mbmk.dto.StudiesPlanDto;
import com.mbmk.model.domain.StudiesPlan;
import org.springframework.stereotype.Service;

@Service
public class StudiesPlanService {

    public StudiesPlanDto create(StudiesPlanDto studiesPlanDto) {
        StudiesPlan.StudiesPlanBuilder studiesPlanBuilder = StudiesPlan.builder();
        return studiesPlanDto;
    }
}