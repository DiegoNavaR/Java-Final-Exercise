package com.university.model;

import java.util.List;

public class Class {
    private String className;
    private String classroom;
    private Teacher teacher;
    private List<Student> students;

    public Class(String className, String classroom, Teacher teacher, List<Student> students) {
        this.className = className;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public String getClassroom() {
        return classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Class: " + className + " in " + classroom + "\nTeacher: " + teacher.getName() + "\nStudents: " + students;
    }
}