package ua.edu.university.controller;

import ua.edu.university.model.Human;
import ua.edu.university.model.Student;

public class StudentCreator implements Creator<Student> {
    private final HumanCreator humanCreator = new HumanCreator();

    @Override
    public Student create() {
        Human h = humanCreator.create();
        return new Student(h.getName(), h.getSurname(), h.getPatronymic(), h.getSex());
    }
}
