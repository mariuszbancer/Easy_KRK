package com.mbmk.rest;

import com.mbmk.dto.ModuleDto;
import com.mbmk.services.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
@Slf4j
public class ModuleController {

    private final ModuleService moduleService;

    @PostMapping("modules")
    @ResponseBody
    public ModuleDto createModules(@RequestBody ModuleDto moduleDto) {
        log.debug("Create module {}", moduleDto);
        return moduleService.createModule(moduleDto);
    }

    @GetMapping("modules")
    @ResponseBody
    public List<ModuleDto> getAllModules() {
        log.debug("Get all modules");
        return moduleService.getAllModules();
    }
}
