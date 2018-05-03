package com.mbmk.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class MinisterialEducationEffect {

    @Id
    private Long id;
    private String symbol;
    private String content;

    @ManyToMany(mappedBy = "ministerialEducationEffects")
    private List<FieldOfStudyEducationEffect> fieldOfStudyEducationEffects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinisterialEducationEffect that = (MinisterialEducationEffect) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, content);
    }
}