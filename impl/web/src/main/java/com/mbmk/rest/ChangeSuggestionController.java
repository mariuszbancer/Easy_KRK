package com.mbmk.rest;

import com.mbmk.dto.ChangeSuggestionDto;
import com.mbmk.services.ChangeSuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ChangeSuggestionController {

    private final ChangeSuggestionService changeSuggestionService;

    @GetMapping("changeSuggestions")
    @ResponseBody
    public List<ChangeSuggestionDto> getChangeSuggestions() {
        log.debug("Get change suggestions");
        return changeSuggestionService.getChangeSuggestions();
    }

    @GetMapping("changeSuggestions/{id}")
    @ResponseBody
    public ChangeSuggestionDto getById(@PathVariable("id") Long id) {
        log.debug("Get change suggestion by id {}", id);
        return changeSuggestionService.getById(id);
    }

    @PutMapping("changeSuggestions")
    @ResponseBody
    public ChangeSuggestionDto updateChangeSuggestion(@RequestBody ChangeSuggestionDto changeSuggestionDto) {
        log.debug("Update change suggestion {}", changeSuggestionDto);
        return changeSuggestionService.updateChangeSuggestion(changeSuggestionDto);
    }

    @PostMapping("changeSuggestions")
    @ResponseBody
    public ChangeSuggestionDto createChangeSuggestions(@RequestBody ChangeSuggestionDto changeSuggestionDto) {
        log.debug("Create change suggestion {}", changeSuggestionDto);
        return changeSuggestionService.createChangeSuggestion(changeSuggestionDto);
    }

    @DeleteMapping("changeSuggestions/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.debug("Delete change suggestion by id {}", id);
        changeSuggestionService.deleteById(id);
    }

}
