package ua.edu.university.controller;

import ua.edu.university.model.Department;
import ua.edu.university.model.Faculty;
import ua.edu.university.model.Group;
import ua.edu.university.model.Student;
import ua.edu.university.model.University;

public class Run {
    public static void main(String[] args) {
        University university = createTypycalUniversity();
        printUniversity(university);
    }

    /** Створює типовий університет: 2 факультети, по 2 кафедри, по 2 групи, по 3 студенти. */
    public static University createTypycalUniversity() {
        UniversityCreator creator = new UniversityCreator(2, 2, 2, 3);
        return creator.create();
    }

    public static void printUniversity(University university) {
        System.out.println(university);
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("  " + faculty);
            for (Department department : faculty.getDepartments()) {
                System.out.println("    " + department);
                for (Group group : department.getGroups()) {
                    System.out.println("      " + group);
                    for (Student student : group.getStudents()) {
                        System.out.println("        Студент: " + student);
                    }
                }
            }
        }
    }
}
