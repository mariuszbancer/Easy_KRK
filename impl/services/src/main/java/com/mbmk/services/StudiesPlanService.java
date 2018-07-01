package com.mbmk.services;

import com.mbmk.dto.SemesterDto;
import com.mbmk.dto.StudiesPlanDto;
import com.mbmk.mappers.StudiesPlanMapper;
import com.mbmk.model.domain.EducationProgram;
import com.mbmk.model.domain.Semester;
import com.mbmk.model.domain.StudiesPlan;
import com.mbmk.model.repository.EducationProgramRepository;
import com.mbmk.model.repository.SemesterRepository;
import com.mbmk.model.repository.StudiesPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Transactional
public class StudiesPlanService {

    private final StudiesPlanRepository studiesPlanRepository;
    private final StudiesPlanMapper studiesPlanMapper;
    private final SemesterRepository semesterRepository;
    private final EducationProgramRepository educationProgramRepository;

    public StudiesPlanDto create(StudiesPlanDto studiesPlanDto) {
        StudiesPlan.StudiesPlanBuilder studiesPlanBuilder = StudiesPlan.builder();
        studiesPlanBuilder
                .adoptionDate(studiesPlanDto.getCreatedAt())
                .startingAt(studiesPlanDto.getStartsAt())
                .build();
        if(!CollectionUtils.isEmpty(studiesPlanDto.getSemesters())) {
            List<Long> semestersIds = studiesPlanDto.getSemesters().stream().map(SemesterDto::getId).collect(Collectors.toList());
            List<Semester> semesters = semesterRepository.findAllById(semestersIds);
            studiesPlanBuilder.semesters(semesters);
        }
        if(nonNull(studiesPlanDto.getEducationProgramId())) {
            Optional<EducationProgram> educationProgramOptional = educationProgramRepository.findById(studiesPlanDto.getEducationProgramId());
            if(educationProgramOptional.isPresent()) {
                List<EducationProgram> educationPrograms = new ArrayList<>();
                educationPrograms.add(educationProgramOptional.get());
                studiesPlanBuilder.educationPrograms(educationPrograms);
            }
        }
        StudiesPlan studiesPlan = studiesPlanBuilder.build();
        StudiesPlan savedStudiesPlan = studiesPlanRepository.save(studiesPlan);
        if(!CollectionUtils.isEmpty(savedStudiesPlan.getSemesters())) {
            savedStudiesPlan.getSemesters().forEach(s -> s.setStudiesPlan(savedStudiesPlan));
            semesterRepository.saveAll(savedStudiesPlan.getSemesters());
        }
        if(!CollectionUtils.isEmpty(savedStudiesPlan.getEducationPrograms())) {
            savedStudiesPlan.getEducationPrograms().forEach(e -> e.setStudiesPlan(savedStudiesPlan));
            educationProgramRepository.saveAll(savedStudiesPlan.getEducationPrograms());
        }
        return studiesPlanMapper.toDto(studiesPlan);
    }

    public StudiesPlanDto getById(Long id) {
        Optional<StudiesPlan> studiesPlanOptional = studiesPlanRepository.findById(id);
        return studiesPlanOptional.map(studiesPlanMapper::toDto).orElse(null);
    }

    public StudiesPlanDto update(StudiesPlanDto studiesPlanDto) {
        if(nonNull(studiesPlanDto.getId())) {
            Optional<StudiesPlan> optionalPlan = studiesPlanRepository.findById(studiesPlanDto.getId());
            if(optionalPlan.isPresent()) {
                StudiesPlan studiesPlan = optionalPlan.get();
                studiesPlan.setAdoptionDate(studiesPlanDto.getCreatedAt());
                studiesPlan.setStartingAt(studiesPlanDto.getStartsAt());
                studiesPlan.getSemesters().forEach(semester -> semester.setStudiesPlan(null));
                semesterRepository.saveAll(studiesPlan.getSemesters());
                if(!CollectionUtils.isEmpty(studiesPlanDto.getSemesters())) {
                    List<Long> semesterIds = studiesPlanDto.getSemesters().stream().map(SemesterDto::getId).collect(Collectors.toList());
                    List<Semester> semesters = semesterRepository.findAllById(semesterIds);
                    studiesPlan.setSemesters(semesters);
                }
                else {
                    studiesPlan.setSemesters(Collections.emptyList());
                }

                StudiesPlan savedStudiesPlan = studiesPlanRepository.save(studiesPlan);
                if(!CollectionUtils.isEmpty(savedStudiesPlan.getSemesters())) {
                    savedStudiesPlan.getSemesters().forEach(semester -> semester.setStudiesPlan(savedStudiesPlan));
                    semesterRepository.saveAll(savedStudiesPlan.getSemesters());
                }
                return studiesPlanMapper.toDto(savedStudiesPlan);
            }
        }
        return null;
    }
}