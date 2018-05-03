package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class ChangeSuggestion {

    @Id
    private Long id;
    private String content;
    private LocalDate notifiedAt;

    @ManyToOne
    private EducationProgram educationProgram;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeSuggestion changeSuggestion = (ChangeSuggestion) o;
        return Objects.equals(id, changeSuggestion.id) &&
                Objects.equals(content, changeSuggestion.content) &&
                Objects.equals(notifiedAt, changeSuggestion.notifiedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, notifiedAt);
    }
}