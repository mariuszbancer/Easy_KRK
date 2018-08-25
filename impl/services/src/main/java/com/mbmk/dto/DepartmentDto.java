package com.mbmk.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@RequiredArgsConstructor
public class DepartmentDto {
    private final Long id;
    private final String name;
    private final Long departmentId;
}