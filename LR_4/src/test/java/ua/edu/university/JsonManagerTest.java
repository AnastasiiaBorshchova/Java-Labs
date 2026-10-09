package ua.edu.university;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.edu.university.controller.JsonManager;
import ua.edu.university.controller.UniversityCreator;
import ua.edu.university.model.University;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonManagerTest {

    @TempDir
    Path tempDir;

    @Test
    void universityWrittenToFileAndReadBackIsEqual() throws IOException {
        // у кожному підрозділі по два підрозділи нижчого рівня
        University oldUniversity = new UniversityCreator(2, 2, 2, 2).create();
        JsonManager jsonManager = new JsonManager();
        Path file = tempDir.resolve("university.json");

        jsonManager.writeToFile(oldUniversity, file);
        University newUniversity = jsonManager.readFromFile(file);

        assertTrue(oldUniversity.equals(newUniversity));
        assertEquals(oldUniversity, newUniversity);
    }

    @Test
    void universityRestoredFromJsonString() {
        University oldUniversity = new UniversityCreator(2, 2, 2, 2).create();
        JsonManager jsonManager = new JsonManager();

        String json = jsonManager.toJson(oldUniversity);
        University newUniversity = jsonManager.fromJson(json);

        assertEquals(oldUniversity, newUniversity);
    }
}
