package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;

public class Department extends Subdivision {
    private List<Group> groups = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Human head) {
        super(name, head);
    }

    public List<Group> getGroups() { return groups; }
    public void setGroups(List<Group> groups) { this.groups = groups; }
}
