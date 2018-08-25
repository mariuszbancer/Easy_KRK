package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class StudiesProgram {

    @Id @GeneratedValue
    private Long id;

    private String description;
    private LocalDate adoptionDate;
    private LocalDate startsAt;

    @ManyToMany
    @JoinTable(
            name = "studies_programs_modules",
            joinColumns = { @JoinColumn(name = "studies_program_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "module_id", referencedColumnName = "id") }
    )
    private List<Module> modules;

    @OneToMany(mappedBy = "studiesProgram")
    private List<EducationProgram> educationPrograms;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudiesProgram that = (StudiesProgram) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(adoptionDate, that.adoptionDate) &&
                Objects.equals(startsAt, that.startsAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, adoptionDate, startsAt);
    }
}