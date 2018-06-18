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
public class StudiesPlan {

    @Id @GeneratedValue
    private Long id;

    private LocalDate adoptionDate;
    private LocalDate startingAt;

    @OneToMany(mappedBy = "studiesPlan")
    private List<EducationProgram> educationPrograms;

    @OneToMany(mappedBy = "studiesPlan")
    private List<Semester> semesters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudiesPlan that = (StudiesPlan) o;
        return Objects.equals(adoptionDate, that.adoptionDate) &&
                Objects.equals(startingAt, that.startingAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(adoptionDate, startingAt);
    }
}