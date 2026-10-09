package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends Subdivision {
    private List<Department> departments = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Faculty that = (Faculty) o;
        return Objects.equals(departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departments);
    }
}
