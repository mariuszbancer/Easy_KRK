package com.mbmk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangeSuggestionDto {
    private Long id;
    private String content;
    private LocalDate notifiedAt;
    private Long educationProgramId;
    private String createdByUsername;
    private String changeSuggestionType;
    private Long departmentId;
    private Long fieldOfStudyId;
    private String departmentName;
    private String fieldOfStudyName;
}