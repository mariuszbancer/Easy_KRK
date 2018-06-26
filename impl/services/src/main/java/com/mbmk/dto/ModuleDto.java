package com.mbmk.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ModuleDto {

    private Long id;
    private String name;
    private List<CourseDto> courses;
}