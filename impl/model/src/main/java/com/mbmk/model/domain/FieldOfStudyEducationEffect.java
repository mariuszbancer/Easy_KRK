package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class FieldOfStudyEducationEffect {

    @Id @GeneratedValue
    private Long id;
    private String symbol;
    private String content;

    @ManyToOne
    private EducationProgram educationProgram;

    @ManyToMany
    @JoinTable(
            name = "fields_ministerials_education_effects",
            joinColumns = { @JoinColumn(name = "field_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "ministerial_id", referencedColumnName = "id") }
    )
    private List<MinisterialEducationEffect> ministerialEducationEffects;

}