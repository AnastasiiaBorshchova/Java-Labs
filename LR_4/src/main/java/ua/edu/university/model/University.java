package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University extends Subdivision {
    private List<Faculty> faculties = new ArrayList<>();

    public University() {
    }

    public University(String name, Human head) {
        super(name, head);
    }

    public List<Faculty> getFaculties() { return faculties; }
    public void setFaculties(List<Faculty> faculties) { this.faculties = faculties; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculties);
    }
}
