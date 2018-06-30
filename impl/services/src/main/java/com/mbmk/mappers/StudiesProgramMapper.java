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

    public StudiesProgramDto toDto(StudiesProgram savedStudiesProgram) {
        return StudiesProgramDto.builder()
                .createdAt(savedStudiesProgram.getAdoptionDate())
                .startsAt(savedStudiesProgram.getStartsAt())
                .description(savedStudiesProgram.getDescription())
                .modules(!CollectionUtils.isEmpty(savedStudiesProgram.getModules()) ? moduleMapper.toDtos(savedStudiesProgram.getModules()) : Collections.emptyList())
                .build();
    }

    public List<StudiesProgramDto> toDtos(List<StudiesProgram> studiesPrograms) {
        return studiesPrograms.stream().map(this::toDto).collect(Collectors.toList());
    }
}