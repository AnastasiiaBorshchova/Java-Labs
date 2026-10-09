package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;

public class University extends Subdivision {
    private List<Faculty> faculties = new ArrayList<>();

    public University() {
    }

    public University(String name, Human head) {
        super(name, head);
    }

    public List<Faculty> getFaculties() { return faculties; }
    public void setFaculties(List<Faculty> faculties) { this.faculties = faculties; }
}
