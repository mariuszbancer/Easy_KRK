package com.mbmk.mappers;

import com.mbmk.dto.FieldOfStudyDto;
import com.mbmk.model.domain.FieldOfStudy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FieldOfStudyMapper {

    public List<FieldOfStudyDto> toDtos(List<FieldOfStudy> fieldOfStudies) {
        return fieldOfStudies.stream().map(this::toDto).collect(Collectors.toList());
    }

    public FieldOfStudyDto toDto(FieldOfStudy fieldOfStudy) {
        return new FieldOfStudyDto(
                fieldOfStudy.getId(),
                fieldOfStudy.getName(),
                fieldOfStudy.getDepartment() != null ? fieldOfStudy.getDepartment().getId() : null
        );
    }
}
