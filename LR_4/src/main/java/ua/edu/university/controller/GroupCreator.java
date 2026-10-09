package ua.edu.university.controller;

import ua.edu.university.model.Group;

public class GroupCreator extends AbstractSubdivisionCreator<Group> {
    private final StudentCreator studentCreator = new StudentCreator();

    public GroupCreator(int studentsCount) {
        super(studentsCount);
    }

    @Override
    public Group create() {
        Group group = new Group(nextName("Група"), humanCreator.create());
        for (int i = 0; i < childrenCount; i++) {
            group.getStudents().add(studentCreator.create());
        }
        return group;
    }
}
