package com.project.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String course;

    public Student(int id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCourse() { return course; }
}