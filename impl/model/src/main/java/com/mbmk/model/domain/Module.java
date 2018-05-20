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

    @Id
    private Long id;

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
        return Objects.equals(id, module.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}