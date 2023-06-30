package entities;

public class User {
    private String name;
    private int age;
    private int id;

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
