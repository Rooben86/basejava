package com.urise.webapp.model;

public enum ContactType {
    PHONE("Home tel."),
    MOBILE("Mobile"),
    SKYPE("Skype"),
    EMAIL("Email"),
    LINKEDIN("Linkedin Profile"),
    GITHUB("Github profile"),
    STACKOVERFLOW("Stackoverflow profile"),
    HOME_PAGE("Personal page");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
