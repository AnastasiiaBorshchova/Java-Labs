package ua.edu.university.model;

public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Sex sex;

    public Human() {
    }

    public Human(String name, String surname, String patronymic, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public Sex getSex() { return sex; }
    public void setSex(Sex sex) { this.sex = sex; }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " (" + sex + ")";
    }
}
