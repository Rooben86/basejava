package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private static final long serialVersionUID = 1L;
    private final List<String> items;

    public ListSection(String... items) {
        this(Arrays.asList(items));
    }
    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ListSection that = (ListSection) object;

        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}
