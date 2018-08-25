package com.mbmk.mappers;

import com.mbmk.dto.DepartmentDto;
import com.mbmk.model.domain.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

    public List<DepartmentDto> toDtos(List<Department> departments) {
        return departments.stream().map(this::toDto).collect(Collectors.toList());
    }

    public DepartmentDto toDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDepartment() != null ? department.getDepartment().getId() : null
        );
    }
}