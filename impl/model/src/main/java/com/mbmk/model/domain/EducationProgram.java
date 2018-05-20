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
public class EducationProgram {

    @Id
    private Long id;
    private String fieldOfStury;
    private LevelOfEducation levelOfEducation;
    private StudiesForm studiesForm;
    private StudiesProfile studiesProfile;
    private String language;

    @OneToOne
    private Department department;

    @ManyToOne
    private EducationCycle educationCycle;

    @OneToMany(mappedBy = "educationProgram")
    private List<FieldOfStudyEducationEffect> fieldOfStudyEducationEffects;

    @OneToMany(mappedBy = "educationProgram")
    private List<ChangeSuggestion> changeSuggestions;

    @ManyToOne
    private StudiesPlan studiesPlan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationProgram that = (EducationProgram) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(fieldOfStury, that.fieldOfStury) &&
                levelOfEducation == that.levelOfEducation &&
                studiesForm == that.studiesForm &&
                studiesProfile == that.studiesProfile &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fieldOfStury, levelOfEducation, studiesForm, studiesProfile, language);
    }
}