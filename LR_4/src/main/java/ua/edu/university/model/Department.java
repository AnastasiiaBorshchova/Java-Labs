package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department extends Subdivision {
    private List<Group> groups = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Human head) {
        super(name, head);
    }

    public List<Group> getGroups() { return groups; }
    public void setGroups(List<Group> groups) { this.groups = groups; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groups);
    }
}
