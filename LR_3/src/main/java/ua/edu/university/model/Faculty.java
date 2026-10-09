package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Subdivision {
    private List<Department> departments = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }
}
