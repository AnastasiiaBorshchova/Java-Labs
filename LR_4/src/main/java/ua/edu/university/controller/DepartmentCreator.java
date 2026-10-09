package ua.edu.university.controller;

import ua.edu.university.model.Department;

public class DepartmentCreator extends AbstractSubdivisionCreator<Department> {
    private final GroupCreator groupCreator;

    public DepartmentCreator(int groupsCount, int studentsCount) {
        super(groupsCount);
        this.groupCreator = new GroupCreator(studentsCount);
    }

    @Override
    public Department create() {
        Department department = new Department(nextName("Кафедра"), humanCreator.create());
        for (int i = 0; i < childrenCount; i++) {
            department.getGroups().add(groupCreator.create());
        }
        return department;
    }
}
