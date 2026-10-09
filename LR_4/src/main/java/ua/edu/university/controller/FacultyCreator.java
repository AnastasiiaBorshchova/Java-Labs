package ua.edu.university.controller;

import ua.edu.university.model.Faculty;

public class FacultyCreator extends AbstractSubdivisionCreator<Faculty> {
    private final DepartmentCreator departmentCreator;

    public FacultyCreator(int departmentsCount, int groupsCount, int studentsCount) {
        super(departmentsCount);
        this.departmentCreator = new DepartmentCreator(groupsCount, studentsCount);
    }

    @Override
    public Faculty create() {
        Faculty faculty = new Faculty(nextName("Факультет"), humanCreator.create());
        for (int i = 0; i < childrenCount; i++) {
            faculty.getDepartments().add(departmentCreator.create());
        }
        return faculty;
    }
}
