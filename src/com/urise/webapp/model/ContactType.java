package com.urise.webapp.model;

public enum ContactType {
    PHONE("Tel."),
    MOBILE("Mobile"),
    HOME_PHONE("Home Phone"),
    SKYPE("Skype"),
    MAIL("Email address"),
    LINKEDIN("LinkedIn account"),
    GITHUB("Github profile"),
    STACKOVERFLOW("Stackoverflow profile"),
    HOME_PAGE("Home page");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
