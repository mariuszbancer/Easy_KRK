package com.mbmk.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum CourseType {

    MANDATORY("Obowiązkowy"), CHOOSABLE("Wybieralny");

    private String typeName;

    CourseType(String typeName) {
        this.typeName = typeName;
    }

    @JsonCreator
    public static CourseType courseType(String profileName) {
        for(CourseType courseType: values()) {
            if(courseType.getTypeName().equalsIgnoreCase(profileName)) {
                return courseType;
            }
        }
        return null;
    }

}
