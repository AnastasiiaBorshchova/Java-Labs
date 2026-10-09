package ua.edu.university.controller;

import ua.edu.university.model.Human;
import ua.edu.university.model.Sex;

public class HumanCreator implements Creator<Human> {
    private static int counter = 0;

    @Override
    public Human create() {
        counter++;
        Sex sex = (counter % 2 == 0) ? Sex.FEMALE : Sex.MALE;
        return new Human("Ім'я" + counter, "Прізвище" + counter, "Побатькові" + counter, sex);
    }
}
