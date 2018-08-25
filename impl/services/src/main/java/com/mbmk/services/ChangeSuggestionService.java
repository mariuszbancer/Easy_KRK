package com.mbmk.services;

import com.mbmk.dto.ChangeSuggestionDto;
import com.mbmk.mappers.ChangeSuggestionMapper;
import com.mbmk.model.domain.*;
import com.mbmk.model.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Transactional
public class ChangeSuggestionService {

    private final ChangeSuggestionRepository changeSuggestionRepository;
    private final ChangeSuggestionMapper changeSuggestionMapper;
    private final EducationProgramRepository educationProgramRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public List<ChangeSuggestionDto> getChangeSuggestions() {
        List<ChangeSuggestion> changeSuggestions = changeSuggestionRepository.findAll();
        return changeSuggestionMapper.toDtos(changeSuggestions);
    }

    public ChangeSuggestionDto createChangeSuggestion(ChangeSuggestionDto changeSuggestionDto) {
        ChangeSuggestion.ChangeSuggestionBuilder changeSuggestionBuilder = ChangeSuggestion.builder()
                .content(changeSuggestionDto.getContent())
                .notifiedAt(changeSuggestionDto.getNotifiedAt());

        if(nonNull(changeSuggestionDto.getEducationProgramId())) {
            Optional<EducationProgram> educationProgram = educationProgramRepository.findById(changeSuggestionDto.getEducationProgramId());
            educationProgram.map(changeSuggestionBuilder::educationProgram);
        }

        if(!StringUtils.isEmpty(changeSuggestionDto.getChangeSuggestionType())) {
            ChangeSuggestionType changeSuggestionType = ChangeSuggestionType.fromRegionalizedString(changeSuggestionDto.getChangeSuggestionType());
            if(nonNull(changeSuggestionType)) {
                changeSuggestionBuilder.changeSuggestionType(changeSuggestionType);
            }
        }

        if(nonNull(changeSuggestionDto.getDepartmentId())) {
            Optional<Department> department = departmentRepository.findById(changeSuggestionDto.getDepartmentId());
            department.map(changeSuggestionBuilder::department);
        }

        if(nonNull(changeSuggestionDto.getFieldOfStudyId())) {
            Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findById(changeSuggestionDto.getFieldOfStudyId());
            fieldOfStudy.map(changeSuggestionBuilder::fieldOfStudy);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        user.map(changeSuggestionBuilder::createdBy);

        ChangeSuggestion changeSuggestion = changeSuggestionBuilder.build();
        changeSuggestionRepository.save(changeSuggestion);

        return changeSuggestionMapper.toDto(changeSuggestion);
    }

    public ChangeSuggestionDto getById(Long id) {
        Optional<ChangeSuggestion> changeSuggestion = changeSuggestionRepository.findById(id);
        return changeSuggestion.map(changeSuggestionMapper::toDto).orElse(null);
    }

    public ChangeSuggestionDto updateChangeSuggestion(ChangeSuggestionDto changeSuggestionDto) {
        if(isNull(changeSuggestionDto) || isNull(changeSuggestionDto.getId())) {
            throw new RuntimeException("Cannot update null or without id change suggestion");
        }

        Optional<ChangeSuggestion> changeSuggestionOptional = changeSuggestionRepository.findById(changeSuggestionDto.getId());

        if(!changeSuggestionOptional.isPresent()) {
            throw new RuntimeException("Cannot find change suggestion with given id");
        }

        ChangeSuggestion changeSuggestion = changeSuggestionOptional.get();

        if(nonNull(changeSuggestionDto.getEducationProgramId())) {
            Optional<EducationProgram> educationProgram = educationProgramRepository.findById(changeSuggestionDto.getEducationProgramId());
            educationProgram.ifPresent(changeSuggestion::setEducationProgram);
        }

        if(!StringUtils.isEmpty(changeSuggestionDto.getChangeSuggestionType())) {
            ChangeSuggestionType changeSuggestionType = ChangeSuggestionType.fromRegionalizedString(changeSuggestionDto.getChangeSuggestionType());
            if(nonNull(changeSuggestionType)) {
                changeSuggestion.setChangeSuggestionType(changeSuggestionType);
            }
        }

        if(nonNull(changeSuggestionDto.getDepartmentId())) {
            Optional<Department> department = departmentRepository.findById(changeSuggestionDto.getDepartmentId());
            department.ifPresent(changeSuggestion::setDepartment);
        }

        if(nonNull(changeSuggestionDto.getFieldOfStudyId())) {
            Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findById(changeSuggestionDto.getFieldOfStudyId());
            fieldOfStudy.ifPresent(changeSuggestion::setFieldOfStudy);
        }

        if(!StringUtils.isEmpty(changeSuggestionDto.getContent())) {
            changeSuggestion.setContent(changeSuggestionDto.getContent());
        }

        ChangeSuggestion savedChangeSuggestion = changeSuggestionRepository.save(changeSuggestion);
        return changeSuggestionMapper.toDto(savedChangeSuggestion);
    }

    public void deleteById(Long id) {
        changeSuggestionRepository.deleteById(id);
    }
}