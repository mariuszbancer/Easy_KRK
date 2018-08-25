package com.mbmk.dto;

import lombok.Value;

@Value
public class FieldOfStudyDto {
    private Long id;
    private String name;
    private Long departmentId;
}
