package ua.edu.university.model;

/** Абстрактний структурний підрозділ: має назву та голову (Human). */
public abstract class Subdivision {
    private String name;
    private Human head;

    protected Subdivision() {
    }

    protected Subdivision(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Human getHead() { return head; }
    public void setHead(Human head) { this.head = head; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " \"" + name + "\", голова: " + head;
    }
}
