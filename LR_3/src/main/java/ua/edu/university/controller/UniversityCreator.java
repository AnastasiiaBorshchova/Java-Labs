package ua.edu.university.controller;

import ua.edu.university.model.University;

public class UniversityCreator extends AbstractSubdivisionCreator<University> {
    private final FacultyCreator facultyCreator;

    public UniversityCreator(int facultiesCount, int departmentsCount, int groupsCount, int studentsCount) {
        super(facultiesCount);
        this.facultyCreator = new FacultyCreator(departmentsCount, groupsCount, studentsCount);
    }

    @Override
    public University create() {
        University university = new University(nextName("Університет"), humanCreator.create());
        for (int i = 0; i < childrenCount; i++) {
            university.getFaculties().add(facultyCreator.create());
        }
        return university;
    }
}
