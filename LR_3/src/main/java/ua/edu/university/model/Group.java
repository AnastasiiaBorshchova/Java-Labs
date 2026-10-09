package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;

public class Group extends Subdivision {
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(String name, Human head) {
        super(name, head);
    }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
