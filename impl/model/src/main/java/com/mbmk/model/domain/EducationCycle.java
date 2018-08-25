package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class EducationCycle {

    @Id @GeneratedValue
    private Long id;
    private LocalDate startedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationCycle that = (EducationCycle) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startedAt, that.startedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startedAt);
    }
}