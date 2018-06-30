package com.mbmk.services;

import com.mbmk.dto.ModuleDto;
import com.mbmk.dto.StudiesProgramDto;
import com.mbmk.mappers.StudiesProgramMapper;
import com.mbmk.model.domain.EducationProgram;
import com.mbmk.model.domain.Module;
import com.mbmk.model.domain.StudiesProgram;
import com.mbmk.model.repository.EducationProgramRepository;
import com.mbmk.model.repository.ModuleRepository;
import com.mbmk.model.repository.StudiesProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Transactional
public class StudiesProgramService {

    private final StudiesProgramRepository studiesProgramRepository;
    private final StudiesProgramMapper studiesProgramMapper;
    private final ModuleRepository moduleRepository;
    private final EducationProgramRepository educationProgramRepository;

    public StudiesProgramDto create(StudiesProgramDto studiesProgramDto) {
        StudiesProgram.StudiesProgramBuilder studiesProgramBuilder = StudiesProgram.builder();
        studiesProgramBuilder
                .startsAt(studiesProgramDto.getStartsAt())
                .adoptionDate(studiesProgramDto.getCreatedAt());

        if(!CollectionUtils.isEmpty(studiesProgramDto.getModules())) {
            List<Long> moduleIds = studiesProgramDto.getModules().stream().map(ModuleDto::getId).collect(Collectors.toList());
            List<Module> modules = moduleRepository.findAllById(moduleIds);
            studiesProgramBuilder.modules(modules);
        }

        if(nonNull(studiesProgramDto.getEducationProgramId())) {
            Optional<EducationProgram> educationProgramOptional = educationProgramRepository.findById(studiesProgramDto.getEducationProgramId());
            if(educationProgramOptional.isPresent()) {
                List<EducationProgram> educationPrograms = new ArrayList<>();
                educationPrograms.add(educationProgramOptional.get());
                studiesProgramBuilder.educationPrograms(educationPrograms);
            }
        }

        StudiesProgram studiesProgram = studiesProgramBuilder.build();
        StudiesProgram savedStudiesProgram = studiesProgramRepository.save(studiesProgram);
        savedStudiesProgram.getEducationPrograms().forEach(educationProgram -> educationProgram.setStudiesProgram(savedStudiesProgram));
        educationProgramRepository.saveAll(savedStudiesProgram.getEducationPrograms());
        return studiesProgramMapper.toDto(savedStudiesProgram);
    }
}