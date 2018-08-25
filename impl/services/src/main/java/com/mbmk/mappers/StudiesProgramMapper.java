package com.mbmk.mappers;

import com.mbmk.dto.StudiesProgramDto;
import com.mbmk.model.domain.StudiesProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudiesProgramMapper {

    private final ModuleMapper moduleMapper;

    public StudiesProgramDto toDto(StudiesProgram studiesProgram) {
        return StudiesProgramDto.builder()
                .id(studiesProgram.getId())
                .createdAt(studiesProgram.getAdoptionDate())
                .startsAt(studiesProgram.getStartsAt())
                .description(studiesProgram.getDescription())
                .modules(!CollectionUtils.isEmpty(studiesProgram.getModules()) ? moduleMapper.toDtos(studiesProgram.getModules()) : Collections.emptyList())
                .build();
    }

    public List<StudiesProgramDto> toDtos(List<StudiesProgram> studiesPrograms) {
        return studiesPrograms.stream().map(this::toDto).collect(Collectors.toList());
    }
}