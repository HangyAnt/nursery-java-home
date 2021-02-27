package com.codecool.nursery.groups;

import com.codecool.nursery.children.Child;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final String NAME;
    private List<Child> group;

    public Group(String name) {
        this.NAME = name;
        group = new ArrayList<>();
    }

    public String getName() {
        return NAME;
    }

    public List<Child> getGroup() {
        return group;
    }

    public void setGroup(List<Child> group) {
        this.group = group;
    }

}
