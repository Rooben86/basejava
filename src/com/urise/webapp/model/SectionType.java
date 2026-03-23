package com.urise.webapp.model;

public enum SectionType {
    OBJECTIVE("Desired position"),
    PERSONAL("Personal qualities"),
    ACHIEVEMENT("Professional achievements"),
    QUALIFICATIONS("Professional qualifications"),
    EXPERIENCE("Professional experience"),
    EDUCATION("Education");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
