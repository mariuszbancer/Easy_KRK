package com.mbmk.services;

import com.mbmk.dto.DepartmentDto;
import com.mbmk.dto.FieldOfStudyDto;
import com.mbmk.mappers.DepartmentMapper;
import com.mbmk.mappers.FieldOfStudyMapper;
import com.mbmk.model.domain.FieldOfStudy;
import com.mbmk.model.repository.DepartmentRepository;
import com.mbmk.model.repository.FieldOfStudyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final FieldOfStudyMapper fieldOfStudyMapper;

    public List<DepartmentDto> getAllDepartmens() {
        log.debug("Service call to get all departments");
        return departmentMapper.toDtos(departmentRepository.findAll());
    }

    public List<FieldOfStudyDto> getFieldOfStudiesByDepartment(Long departmentId) {
        List<FieldOfStudy> fieldOfStudies = fieldOfStudyRepository.findByDepartmentId(departmentId);
        return fieldOfStudyMapper.toDtos(fieldOfStudies);
    }
}