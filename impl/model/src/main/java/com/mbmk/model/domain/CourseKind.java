package com.mbmk.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum CourseKind {

    GENERAL_EDUCATION("Kształcenia ogólnego"), BASIC("Podstawowy"), DIRECTIONAL("Kierunkowy"), SPECIALIZED("Specjalnosciowy");

    private String kindName;

    CourseKind(String kindName) {
        this.kindName = kindName;
    }

    @JsonCreator
    public static CourseKind courseKind(String profileName) {
        for(CourseKind courseKind: values()) {
            if(courseKind.getKindName().equalsIgnoreCase(profileName)) {
                return courseKind;
            }
        }
        return null;
    }
}
