package com.mbmk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudiesProgramDto {
    private Long id;
    private Long educationProgramId;
    private String description;
    private LocalDate createdAt;
    private LocalDate startsAt;
    private List<ModuleDto> modules;
}