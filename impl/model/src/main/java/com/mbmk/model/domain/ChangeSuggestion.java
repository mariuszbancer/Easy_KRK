package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.*;
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

    @Id @GeneratedValue
    private Long id;
    private String content;
    private LocalDate notifiedAt;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private EducationProgram educationProgram;

    @Enumerated(EnumType.STRING)
    private ChangeSuggestionType changeSuggestionType;

    @ManyToOne
    private Department department;

    @ManyToOne
    private FieldOfStudy fieldOfStudy;

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