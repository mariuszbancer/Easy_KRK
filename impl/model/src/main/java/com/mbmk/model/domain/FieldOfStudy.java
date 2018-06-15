package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class FieldOfStudy {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private Department department;
}
