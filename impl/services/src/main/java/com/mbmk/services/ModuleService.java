package com.mbmk.services;

import com.mbmk.dto.CourseDto;
import com.mbmk.dto.ModuleDto;
import com.mbmk.mappers.ModuleMapper;
import com.mbmk.model.domain.Course;
import com.mbmk.model.domain.Module;
import com.mbmk.model.repository.CourseRepository;
import com.mbmk.model.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Transactional
public class ModuleService {
    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;
    private final CourseRepository courseRepository;

    public ModuleDto createModule(ModuleDto moduleDto) {
        Module.ModuleBuilder builder = Module.builder();
        if(nonNull(moduleDto.getName())){
            builder.name(moduleDto.getName());
        }
        if(!CollectionUtils.isEmpty(moduleDto.getCourses())) {
            List<Long> coursesIds = moduleDto.getCourses().stream().map(CourseDto::getId).collect(Collectors.toList());
            List<Course> courses = courseRepository.findAllById(coursesIds);
            builder.courses(courses);
        }
        builder.name(moduleDto.getName());
        Module module = builder.build();
        Module savedModule = moduleRepository.save(module);
        savedModule.getCourses().forEach(course -> course.getModules().add(savedModule));
        courseRepository.saveAll(savedModule.getCourses());
        return moduleMapper.toDto(savedModule);
    }
}