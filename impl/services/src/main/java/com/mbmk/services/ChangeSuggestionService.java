package com.mbmk.services;

import com.mbmk.dto.ChangeSuggestionDto;
import com.mbmk.mappers.ChangeSuggestionMapper;
import com.mbmk.model.domain.ChangeSuggestion;
import com.mbmk.model.domain.ChangeSuggestionType;
import com.mbmk.model.domain.EducationProgram;
import com.mbmk.model.domain.User;
import com.mbmk.model.repository.ChangeSuggestionRepository;
import com.mbmk.model.repository.EducationProgramRepository;
import com.mbmk.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ChangeSuggestionService {

    private final ChangeSuggestionRepository changeSuggestionRepository;
    private final ChangeSuggestionMapper changeSuggestionMapper;
    private final EducationProgramRepository educationProgramRepository;
    private final UserRepository userRepository;

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        user.map(changeSuggestionBuilder::createdBy);

        ChangeSuggestion changeSuggestion = changeSuggestionBuilder.build();
        changeSuggestionRepository.save(changeSuggestion);

        return changeSuggestionMapper.toDto(changeSuggestion);
    }
}