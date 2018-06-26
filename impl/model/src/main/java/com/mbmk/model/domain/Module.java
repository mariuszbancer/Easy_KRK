package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class Module {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "modules_courses",
            joinColumns = { @JoinColumn(name = "module_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id") }
    )
    private List<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(name, module.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}