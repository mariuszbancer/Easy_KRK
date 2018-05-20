package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class User {

    @Id
    private Long id;
    private String login;
    private String passwordHash;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogged;

    @OneToMany(mappedBy = "guardian")
    private List<Course> course;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
    )
    private List<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(passwordHash, user.passwordHash) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(lastLogged, user.lastLogged);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, passwordHash, createdAt, lastLogged);
    }
}