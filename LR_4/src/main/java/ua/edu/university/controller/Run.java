package ua.edu.university.controller;

import ua.edu.university.model.Department;
import ua.edu.university.model.Faculty;
import ua.edu.university.model.Group;
import ua.edu.university.model.Student;
import ua.edu.university.model.University;

import java.io.IOException;
import java.nio.file.Path;

public class Run {
    public static void main(String[] args) throws IOException {
        University university = createTypycalUniversity();
        printUniversity(university);

        JsonManager jsonManager = new JsonManager();
        Path file = Path.of("university.json");
        jsonManager.writeToFile(university, file);
        University restored = jsonManager.readFromFile(file);
        System.out.println("Відновлений університет еквівалентний вихідному: " + university.equals(restored));
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
