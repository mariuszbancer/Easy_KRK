package com.mbmk.rest;

import com.mbmk.dto.EducationProgramDto;
import com.mbmk.services.EducationProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class EducationProgramController {

    private final EducationProgramService educationProgramService;

    @GetMapping("educationPrograms")
    @ResponseBody
    public List<EducationProgramDto> getEducationPrograms() {
        log.debug("Get change suggestions");
        return educationProgramService.getEducationPrograms();
    }

    @GetMapping("educationPrograms/{id}")
    @ResponseBody
    public EducationProgramDto getById(@PathVariable("id") Long id) {
        log.debug("Get education program by id {}", id);
        return educationProgramService.getById(id);
    }

    @PutMapping("educationPrograms")
    @ResponseBody
    public EducationProgramDto updateEducationProgram(@RequestBody EducationProgramDto educationProgramDto) {
        log.debug("Update education program {}", educationProgramDto);
        return educationProgramService.updateEducationProgram(educationProgramDto);
    }

    @PostMapping("educationPrograms")
    @ResponseBody
    public EducationProgramDto createEducationPrograms(@RequestBody EducationProgramDto educationProgramDto) {
        log.debug("Create education program {}", educationProgramDto);
        return educationProgramService.createEducationProgram(educationProgramDto);
    }

    @DeleteMapping("educationPrograms/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.debug("Delete education program by id {}", id);
        educationProgramService.deleteById(id);
    }
}
