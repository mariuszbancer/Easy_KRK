package com.mbmk.model.domain;

public enum ChangeSuggestionType {
    STUDIES_PROGRAM("Program studiów"), STUDIES_PLAN("Plan studiów"), EDUCATION_EFFECT("Efekt kształcenia");

    private String regionalizedString;

    ChangeSuggestionType(String regionalizedString) {
        this.regionalizedString = regionalizedString;
    }

    public String getRegionalizedString() {
        return regionalizedString;
    }

    public static ChangeSuggestionType fromRegionalizedString(String regionalizedString) {
        for(ChangeSuggestionType changeSuggestionType: ChangeSuggestionType.values()) {
            if (changeSuggestionType.regionalizedString.equalsIgnoreCase(regionalizedString)) {
                return changeSuggestionType;
            }
        }
        return null;
    }
}
