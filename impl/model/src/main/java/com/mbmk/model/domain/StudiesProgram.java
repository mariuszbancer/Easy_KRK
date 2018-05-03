package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class StudiesProgram {

    @Id
    private Long id;

    private LocalDate adoptionDate;
    private LocalDate startsAt;

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