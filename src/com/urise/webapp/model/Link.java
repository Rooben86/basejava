package com.urise.webapp.model;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String url;

    public Link(String name, String url) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link(" + name + ',' + url + ')';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Link link = (Link) object;

        if (!name.equals(link.name)) return false;
        return Objects.equals(url, link.url);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
