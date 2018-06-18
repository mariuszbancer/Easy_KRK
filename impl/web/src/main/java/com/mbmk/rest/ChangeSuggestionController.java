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

    @PostMapping("changeSuggestions")
    public ChangeSuggestionDto createChangeSuggestions(@RequestBody ChangeSuggestionDto changeSuggestionDto) {
        log.debug("Create change suggestion {}", changeSuggestionDto);
        return changeSuggestionService.createChangeSuggestion(changeSuggestionDto);
    }

}
