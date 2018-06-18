package com.mbmk.mappers;

import com.mbmk.dto.ChangeSuggestionDto;
import com.mbmk.model.domain.ChangeSuggestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
public class ChangeSuggestionMapper {

    public List<ChangeSuggestionDto> toDtos(List<ChangeSuggestion> changeSuggestions) {
        return changeSuggestions.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ChangeSuggestionDto toDto(ChangeSuggestion changeSuggestion) {
        return ChangeSuggestionDto.builder()
                .id(changeSuggestion.getId())
                .content(changeSuggestion.getContent())
                .notifiedAt(changeSuggestion.getNotifiedAt())
                .educationProgramId(nonNull(changeSuggestion.getEducationProgram()) ? changeSuggestion.getEducationProgram().getId() : null)
                .createdById(nonNull(changeSuggestion.getCreatedBy()) ? changeSuggestion.getCreatedBy().getId() : null)
                .changeSuggestionType(changeSuggestion.getChangeSuggestionType().getRegionalizedString())
                .build();
    }
}