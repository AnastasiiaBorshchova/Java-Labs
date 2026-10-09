package ua.edu.university.controller;

import ua.edu.university.model.Subdivision;

/** Базовий клас для створювачів підрозділів: кожен підрозділ має голову та лічильник для назв. */
public abstract class AbstractSubdivisionCreator<T extends Subdivision> implements Creator<T> {
    protected final HumanCreator humanCreator = new HumanCreator();
    protected final int childrenCount;
    private int counter = 0;

    protected AbstractSubdivisionCreator(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    protected String nextName(String prefix) {
        counter++;
        return prefix + " " + counter;
    }
}
