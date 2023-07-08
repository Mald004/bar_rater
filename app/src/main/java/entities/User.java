package entities;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private int id;
    private String password;

    public User(int id, int age, String name) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public User(int id, String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
