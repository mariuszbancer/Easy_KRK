package com.mbmk.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum LevelOfEducation {
    BSC("Licencjacki"), BENG("Inzynierski"), MGR("Magisterski");

    private String levelName;

    LevelOfEducation(String levelName) {
        this.levelName = levelName;
    }

    @JsonCreator
    public static LevelOfEducation levelOfEducation(String profileName) {
        for(LevelOfEducation levelOfEducation: values()) {
            if(levelOfEducation.getLevelName().equalsIgnoreCase(profileName)) {
                return levelOfEducation;
            }
        }
        return null;
    }
}
