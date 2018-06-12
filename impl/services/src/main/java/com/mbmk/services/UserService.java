package com.mbmk.services;

import com.mbmk.dto.auth.auth.AuthParamsDto;
import com.mbmk.model.domain.User;
import com.mbmk.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Service call to loadUserByUsername {}", username);
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public void registerUser(AuthParamsDto params) {
        log.debug("Service call to register user {}", params);
        Optional<User> userWithSameUsername = userRepository.findByUsername(params.getUsername());
        if(userWithSameUsername.isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        User user = User.builder()
                .active(true)
                .username(params.getUsername())
                .password(passwordEncoder.encode(params.getPassword()))
                .build();
        userRepository.save(user);
    }

}