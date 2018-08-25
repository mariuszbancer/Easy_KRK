package com.mbmk.services;

import com.mbmk.dto.EducationProgramDto;
import com.mbmk.mappers.EducationProgramMapper;
import com.mbmk.model.domain.*;
import com.mbmk.model.repository.EducationProgramRepository;
import com.mbmk.model.repository.FieldOfStudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class EducationProgramService {

    private final EducationProgramRepository educationProgramRepository;
    private final EducationProgramMapper educationProgramMapper;
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public List<EducationProgramDto> getEducationPrograms() {
        List<EducationProgram> educationPrograms = educationProgramRepository.findAll();
        return educationProgramMapper.toDtos(educationPrograms);
    }

    public EducationProgramDto getById(Long id) {
        Optional<EducationProgram> educationProgram = educationProgramRepository.findById(id);
        return educationProgram
                .map(educationProgramMapper::toDto)
                .orElseThrow(() -> new RuntimeException("No education program with id " + id));
    }

    public EducationProgramDto updateEducationProgram(EducationProgramDto educationProgramDto) {
        if(isNull(educationProgramDto.getId())) {
            throw new RuntimeException("Cannot update education program with null id");
        }
        Optional<EducationProgram> educationProgramOptional = educationProgramRepository.findById(educationProgramDto.getId());
        if(!educationProgramOptional.isPresent()) {
            throw new RuntimeException("Cannot find education program with given id");
        }
        EducationProgram educationProgram = educationProgramOptional.get();
        if(nonNull(educationProgramDto.getCourseForm())) {
            educationProgram.setCourseForm(CourseForm.courseForm(educationProgramDto.getCourseForm()));
        }
        if(nonNull(educationProgramDto.getStartsAt())) {
            educationProgram.setStartsAt(educationProgramDto.getStartsAt());
        }
        if(nonNull(educationProgramDto.getFieldOfStudyId())) {
            Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findById(educationProgramDto.getFieldOfStudyId());
            fieldOfStudy.ifPresent(educationProgram::setFieldOfStudy);
        }
        if(nonNull(educationProgramDto.getLevelOfEducation())) {
            educationProgram.setLevelOfEducation(LevelOfEducation.levelOfEducation(educationProgramDto.getLevelOfEducation()));
        }
        if(nonNull(educationProgramDto.getStudiesProfile())) {
            educationProgram.setStudiesProfile(StudiesProfile.studiesProfile(educationProgramDto.getStudiesProfile()));
        }
        if(!StringUtils.isEmpty(educationProgramDto.getLanguage())) {
            educationProgram.setLanguage(educationProgramDto.getLanguage());
        }
        if(nonNull(educationProgramDto.getCreatedAt())) {
            educationProgram.setCreatedAt(educationProgramDto.getCreatedAt());
        }
        EducationProgram savedEducationProgram = educationProgramRepository.save(educationProgram);
        return educationProgramMapper.toDto(savedEducationProgram);
    }

    public EducationProgramDto createEducationProgram(EducationProgramDto educationProgramDto) {
        EducationProgram.EducationProgramBuilder educationProgramBuilder = EducationProgram.builder();
        if(nonNull(educationProgramDto.getCourseForm())) {
            educationProgramBuilder.courseForm(CourseForm.courseForm(educationProgramDto.getCourseForm()));
        }
        if(nonNull(educationProgramDto.getStartsAt())) {
            educationProgramBuilder.startsAt(educationProgramDto.getStartsAt());
        }
        if(nonNull(educationProgramDto.getFieldOfStudyId())) {
            Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findById(educationProgramDto.getFieldOfStudyId());
            fieldOfStudy.map(educationProgramBuilder::fieldOfStudy);
        }
        if(nonNull(educationProgramDto.getLevelOfEducation())) {
            educationProgramBuilder.levelOfEducation(LevelOfEducation.levelOfEducation(educationProgramDto.getLevelOfEducation()));
        }
        if(nonNull(educationProgramDto.getStudiesProfile())) {
            educationProgramBuilder.studiesProfile(StudiesProfile.studiesProfile(educationProgramDto.getStudiesProfile()));
        }
        if(!StringUtils.isEmpty(educationProgramDto.getLanguage())) {
            educationProgramBuilder.language(educationProgramDto.getLanguage());
        }
        if(nonNull(educationProgramDto.getCreatedAt())) {
            educationProgramBuilder.createdAt(educationProgramDto.getCreatedAt());
        }
        EducationProgram educationProgram = educationProgramBuilder.build();
        EducationProgram savedEducationProgram = educationProgramRepository.save(educationProgram);
        return educationProgramMapper.toDto(savedEducationProgram);
    }

    public void deleteById(Long id) {
        educationProgramRepository.deleteById(id);
    }
}