package com.groovy;

public class Mapping {


    private String item;
    private String description;
    private String groups;

    public Mapping(String item, String description, String groups) {
        this.item = item;
        this.description = description;
        this.groups = groups;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "item='" + item + '\'' +
                ", description='" + description + '\'' +
                ", groups='" + groups + '\'' +
                '}';
    }
}
