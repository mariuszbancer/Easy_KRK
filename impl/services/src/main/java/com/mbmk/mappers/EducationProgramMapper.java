package com.mbmk.mappers;

import com.mbmk.dto.EducationProgramDto;
import com.mbmk.model.domain.EducationProgram;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class EducationProgramMapper {

    public List<EducationProgramDto> toDtos(List<EducationProgram> educationPrograms) {
        return educationPrograms.stream().map(this::toDto).collect(Collectors.toList());
    }

    public EducationProgramDto toDto(EducationProgram educationProgram) {
        return EducationProgramDto.builder()
                .id(educationProgram.getId())
                .courseForm(educationProgram.getCourseForm().getFormName())
                .createdAt(educationProgram.getCreatedAt())
                .startsAt(educationProgram.getStartsAt())
                .fieldOfStudyId(nonNull(educationProgram.getFieldOfStudy()) ? educationProgram.getFieldOfStudy().getId() : null)
                .fieldOfStudyName(nonNull(educationProgram.getFieldOfStudy()) ? educationProgram.getFieldOfStudy().getName() : null)
                .language(educationProgram.getLanguage())
                .levelOfEducation(educationProgram.getLevelOfEducation().getLevelName())
                .studiesProfile(educationProgram.getStudiesProfile().getProfileName())
                .build();
    }
}