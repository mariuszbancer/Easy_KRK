package com.mbmk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
class TokenAuthenticationService {

    @Autowired
    private TokenHandler tokenHandler;

    public Authentication getAuthentication(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        if (!authHeader.startsWith("Bearer")) return null;

        final String jwt = authHeader.substring(7);
        if (jwt.isEmpty()) return null;

        return tokenHandler
                .parseUserFromToken(jwt)
                .map(UserAuthentication::new)
                .orElseThrow(() -> new AuthenticationServiceException("User not found or token expired"));
    }
}
