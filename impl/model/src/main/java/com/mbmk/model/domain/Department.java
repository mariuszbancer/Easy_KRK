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
public class Department {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToOne
    private Department department;

    @OneToMany(mappedBy = "department")
    private List<EducationProgram> educationPrograms;

    @OneToMany(mappedBy = "department")
    private List<FieldOfStudy> fieldOfStudies;

    @OneToMany(mappedBy = "department")
    private List<ChangeSuggestion> changeSuggestions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}