package com.mbmk.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PassingMethod {

    EXAM("Egzamin"), CREDIT("Zaliczenie na ocenę");

    private String methodName;

    PassingMethod(String methodName) {
        this.methodName = methodName;
    }

    @JsonCreator
    public static PassingMethod passingMethod(String profileName) {
        for(PassingMethod passingMethod: values()) {
            if(passingMethod.getMethodName().equalsIgnoreCase(profileName)) {
                return passingMethod;
            }
        }
        return null;
    }
}
