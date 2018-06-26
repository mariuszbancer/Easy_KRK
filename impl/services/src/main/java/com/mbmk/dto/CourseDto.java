package com.mbmk.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {

    private Long id;
    private String name;
}