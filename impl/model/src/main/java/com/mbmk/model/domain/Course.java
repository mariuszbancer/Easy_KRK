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
public class Course {

    @Id @GeneratedValue
    private Long id;
    private Integer ectsPoIntegers;
    private String code;
    private Integer zzuHours;
    private Integer cnpsHours;
    private CourseForm courseForm;
    private PassingMethod passingMethod;
    private Boolean universityWide;
    private Boolean practical;
    private CourseKind courseKind;
    private CourseType courseType;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Semester> semesters;

    @ManyToMany(mappedBy = "courses")
    private List<Module> modules;

    @ManyToMany
    @JoinTable(
            name = "courses_subjects",
            joinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "subject_id", referencedColumnName = "id") }
    )
    private List<Subject> subjects;

    @ManyToOne
    private User guardian;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(ectsPoIntegers, course.ectsPoIntegers) &&
                Objects.equals(code, course.code) &&
                Objects.equals(zzuHours, course.zzuHours) &&
                Objects.equals(cnpsHours, course.cnpsHours) &&
                courseForm == course.courseForm &&
                passingMethod == course.passingMethod &&
                Objects.equals(universityWide, course.universityWide) &&
                Objects.equals(practical, course.practical) &&
                courseKind == course.courseKind &&
                courseType == course.courseType &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ectsPoIntegers, code, zzuHours, cnpsHours, courseForm, passingMethod, universityWide, practical, courseKind, courseType, name);
    }
}