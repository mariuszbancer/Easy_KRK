package com.mbmk.services;

import com.mbmk.dto.FieldOfStudyDto;
import com.mbmk.mappers.FieldOfStudyMapper;
import com.mbmk.model.domain.FieldOfStudy;
import com.mbmk.model.repository.FieldOfStudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldOfStudyService {

    private final FieldOfStudyRepository fieldOfStudyRepository;
    private final FieldOfStudyMapper fieldOfStudyMapper;

    public List<FieldOfStudyDto> getAll() {
        List<FieldOfStudy> fieldOfStudies = fieldOfStudyRepository.findAll();
        return fieldOfStudyMapper.toDtos(fieldOfStudies);
    }
}
