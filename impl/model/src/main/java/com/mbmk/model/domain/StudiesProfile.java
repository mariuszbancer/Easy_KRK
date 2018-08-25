package com.mbmk.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum StudiesProfile {
    PRACTICAL("Praktyczny"), GENERAL_ACADEMIC("Ogolnoakademicki");

    private String profileName;

    StudiesProfile(String profileName) {
        this.profileName = profileName;
    }

    @JsonCreator
    public static StudiesProfile studiesProfile(String profileName) {
        for(StudiesProfile studiesProfile: values()) {
            if(studiesProfile.getProfileName().equalsIgnoreCase(profileName)) {
                return studiesProfile;
            }
        }
        return null;
    }
}
