package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends Subdivision {
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(String name, Human head) {
        super(name, head);
    }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Group that = (Group) o;
        return Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), students);
    }
}
