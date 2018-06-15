package com.mbmk.security;

import com.mbmk.model.domain.User;
import com.mbmk.model.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
public final class TokenHandler {

    @Value("${app.jwt.secret}")
    private String secret;

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDetails> parseUserFromToken(String token) {
        final Optional<User> userOptional = userRepository.findOneByCurrentAuthToken(token);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            if(user.getTokenExpiryDate() == null || user.getTokenExpiryDate().isAfter(LocalDate.now())) {
                throw new AuthenticationServiceException("Authorization token expired");
            }
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public String createTokenForUser(User user) {
        final LocalDate afterOneDay = LocalDate.now().plusDays(1);
        final String randomUUID = UUID.randomUUID().toString();

        String authToken = Jwts.builder()
                .setSubject(randomUUID)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(
                        Date.from(afterOneDay.
                                atTime(LocalTime.MAX)
                                .toInstant(ZoneOffset.UTC)
                        )
                )
                .compact();

        user.setCurrentAuthToken(authToken);
        user.setTokenExpiryDate(afterOneDay);
        userRepository.save(user);
        return authToken;
    }
}
