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
public class Semester {

    @Id
    private Long id;

    private LocalDate startsAt;
    private LocalDate endsAt;

    @ManyToOne
    private StudiesPlan studiesPlan;

    @ManyToMany
    @JoinTable(
            name = "semester_courses",
            joinColumns = { @JoinColumn(name = "semester_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id") }
    )
    private List<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return Objects.equals(id, semester.id) &&
                Objects.equals(startsAt, semester.startsAt) &&
                Objects.equals(endsAt, semester.endsAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startsAt, endsAt);
    }
}