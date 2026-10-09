package ua.edu.university.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.edu.university.model.University;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/** Перетворення університету у JSON і назад, запис у файл та читання з файлу. */
public class JsonManager {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /** Об'єкт -> текст JSON. */
    public String toJson(University university) {
        return gson.toJson(university);
    }

    /** Текст JSON -> об'єкт. */
    public University fromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    /** Запис університету у файл у форматі JSON. */
    public void writeToFile(University university, Path path) throws IOException {
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            gson.toJson(university, writer);
        }
    }

    /** Читання університету з JSON-файлу. */
    public University readFromFile(Path path) throws IOException {
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, University.class);
        }
    }
}
