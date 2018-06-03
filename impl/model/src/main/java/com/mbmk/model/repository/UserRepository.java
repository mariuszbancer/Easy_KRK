package com.mbmk.model.repository;

import com.mbmk.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByCurrentAuthToken(String token);

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);
}
