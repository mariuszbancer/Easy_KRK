package com.mbmk.mappers;

import com.mbmk.dto.StudiesPlanDto;
import com.mbmk.model.domain.StudiesPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudiesPlanMapper {

    private final SemesterMapper semesterMapper;

    public StudiesPlanDto toDto(StudiesPlan studiesPlan) {
        return StudiesPlanDto.builder()
                .createdAt(studiesPlan.getAdoptionDate())
                .startsAt(studiesPlan.getStartingAt())
                .semesters(!CollectionUtils.isEmpty(studiesPlan.getSemesters()) ? semesterMapper.toDtos(studiesPlan.getSemesters()) : Collections.emptyList())
                .build();
    }

    public List<StudiesPlanDto> toDtos(List<StudiesPlan> studiesPlans) {
        return studiesPlans.stream().map(this::toDto).collect(Collectors.toList());
    }
}