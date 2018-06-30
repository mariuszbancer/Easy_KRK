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
        savedStudiesPlan.getSemesters().forEach(s -> s.setStudiesPlan(savedStudiesPlan));
        semesterRepository.saveAll(savedStudiesPlan.getSemesters());
        savedStudiesPlan.getEducationPrograms().forEach(e -> e.setStudiesPlan(savedStudiesPlan));
        educationProgramRepository.saveAll(savedStudiesPlan.getEducationPrograms());
        return studiesPlanMapper.toDto(studiesPlan);
    }
}