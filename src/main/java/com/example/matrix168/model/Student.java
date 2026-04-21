package com.example.matrix168.model;

public class Student {
    private int id;
    private String name;
    private String surname;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int id, String name, String surname, int score) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.score = score;
    }
}
