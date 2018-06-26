package com.mbmk.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum CourseForm {

    TRADITIONAL("Tradycyjna"), REMOTE("Zdalna");

    private String formName;

    CourseForm(String formName) {
        this.formName = formName;
    }

    @JsonCreator
    public static CourseForm courseForm(String profileName) {
        for(CourseForm courseForm: values()) {
            if(courseForm.getFormName().equalsIgnoreCase(profileName)) {
                return courseForm;
            }
        }
        return null;
    }
}
