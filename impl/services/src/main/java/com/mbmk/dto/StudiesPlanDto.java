package com.mbmk.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudiesPlanDto {
    private Long id;
    private LocalDate createdAt;
    private LocalDate startsAt;
    private List<SemesterDto> semesters;
}