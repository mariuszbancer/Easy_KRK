package com.mbmk.services;

import com.mbmk.dto.EducationProgramDto;
import com.mbmk.mappers.EducationProgramMapper;
import com.mbmk.model.domain.EducationProgram;
import com.mbmk.model.repository.EducationProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationProgramService {

    private final EducationProgramRepository educationProgramRepository;
    private final EducationProgramMapper educationProgramMapper;

    public List<EducationProgramDto> getEducationPrograms() {
        return null;
    }

    public EducationProgramDto getById(Long id) {
        return null;
    }

    public EducationProgramDto updateEducationProgram(EducationProgramDto educationProgramDto) {
        return null;
    }

    public EducationProgramDto createEducationProgram(EducationProgramDto educationProgramDto) {
        return null;
    }

    public void deleteById(Long id) {
        educationProgramRepository.deleteById(id);
    }
}