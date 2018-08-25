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
public class FieldOfStudy {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private EducationProgram educationProgram;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "fieldOfStudy")
    private List<ChangeSuggestion> changeSuggestions;
}
