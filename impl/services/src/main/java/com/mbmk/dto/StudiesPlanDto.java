package com.mbmk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudiesPlanDto {
    private Long id;
    private Long educationProgramId;
    private LocalDate createdAt;
    private LocalDate startsAt;
    private List<SemesterDto> semesters;
}