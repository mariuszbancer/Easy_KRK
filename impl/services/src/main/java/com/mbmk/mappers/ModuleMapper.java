package com.mbmk.mappers;

import com.mbmk.dto.ModuleDto;
import com.mbmk.model.domain.Module;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ModuleMapper {

    private final CourseMapper courseMapper;

    public ModuleDto toDto(Module module) {
        return ModuleDto.builder()
                .id(module.getId())
                .name(module.getName())
                .courses(!CollectionUtils.isEmpty(module.getCourses()) ? courseMapper.toDtos(module.getCourses()): new ArrayList<>())
                .build();
    }

    public List<ModuleDto> toDtos(List<Module> modules) {
        return modules.stream().map(this::toDto).collect(Collectors.toList());
    }

}