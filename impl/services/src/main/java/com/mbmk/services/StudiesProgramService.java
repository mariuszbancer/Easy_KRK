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

import java.util.*;
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
                .adoptionDate(studiesProgramDto.getCreatedAt())
                .description(studiesProgramDto.getDescription());

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

    public StudiesProgramDto getById(Long id) {
        Optional<StudiesProgram> studiesProgramOptional = studiesProgramRepository.findById(id);
        return studiesProgramOptional.map(studiesProgramMapper::toDto).orElse(null);
    }
    
    public StudiesProgramDto update(StudiesProgramDto studiesProgramDto) {
        if(nonNull(studiesProgramDto.getId())) {
            Optional<StudiesProgram> optionalProgram = studiesProgramRepository.findById(studiesProgramDto.getId());
            if(optionalProgram.isPresent()) {
                StudiesProgram studiesProgram = optionalProgram.get();
                studiesProgram.setAdoptionDate(studiesProgramDto.getCreatedAt());
                studiesProgram.setStartsAt(studiesProgramDto.getStartsAt());
                studiesProgram.setDescription(studiesProgramDto.getDescription());
                studiesProgram.getModules().forEach(module -> module.getStudiesPrograms().remove(studiesProgram));
                moduleRepository.saveAll(studiesProgram.getModules());
                if(!CollectionUtils.isEmpty(studiesProgramDto.getModules())) {
                    List<Long> moduleIds = studiesProgramDto.getModules().stream().map(ModuleDto::getId).collect(Collectors.toList());
                    List<Module> modules = moduleRepository.findAllById(moduleIds);
                    studiesProgram.setModules(modules);
                }
                else {
                    studiesProgram.setModules(Collections.emptyList());
                }

                StudiesProgram savedStudiesProgram = studiesProgramRepository.save(studiesProgram);
                if(!CollectionUtils.isEmpty(savedStudiesProgram.getModules())) {
                    savedStudiesProgram.getModules().forEach(module -> {
                        if(CollectionUtils.isEmpty(module.getStudiesPrograms())){
                            module.setStudiesPrograms(new ArrayList<>(Collections.singletonList(savedStudiesProgram)));
                        }
                        else {
                            module.getStudiesPrograms().add(savedStudiesProgram);
                        }
                    });
                    moduleRepository.saveAll(savedStudiesProgram.getModules());
                }
                return studiesProgramMapper.toDto(savedStudiesProgram);
            }
        }
        return null;
    }
}