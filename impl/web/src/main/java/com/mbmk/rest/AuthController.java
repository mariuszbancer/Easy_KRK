package com.mbmk.rest;

import com.mbmk.dto.auth.auth.AuthParamsDto;
import com.mbmk.dto.auth.auth.AuthResponseDto;
import com.mbmk.security.TokenHandler;
import com.mbmk.services.SecurityContextService;
import com.mbmk.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private SecurityContextService securityContextService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthResponseDto auth(@RequestBody AuthParamsDto params) throws AuthenticationException {
        log.debug("REST request to login user {}", params);
        final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return securityContextService.currentUser().map(u -> {
            final String token = tokenHandler.createTokenForUser(u);
            return new AuthResponseDto(token);
        }).orElseThrow(RuntimeException::new);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody AuthParamsDto params) {
        log.debug("REST request to register user {}", params);
        userService.registerUser(params);
        return ResponseEntity.ok().build();
    }

}
