package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    private Department department;
}
