package com.mbmk.rest;

import com.mbmk.dto.UserDto;
import com.mbmk.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class UserController {

    private final UserService userService;

    @RequestMapping("users")
    public List<UserDto> getAll() {
        return userService.getAll();
    }
}
