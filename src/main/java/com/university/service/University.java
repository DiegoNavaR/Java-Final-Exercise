package com.university.service;

import com.university.model.*;
import com.university.model.Class;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Class> classes;

    public University() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        classes = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addClass(Class newClass) {
        classes.add(newClass);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void printAllProfessors() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void printAllClasses() {
        for (Class c : classes) {
            System.out.println(c);
        }
    }

    public Class findClassByName(String name) {
        for (Class c : classes) {
            if (c.getClassName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public List<Class> getClassesForStudent(int studentId) {
        List<Class> studentClasses = new ArrayList<>();
        for (Class c : classes) {
            for (Student s : c.getStudents()) {
                if (s.getId() == studentId) {
                    studentClasses.add(c);
                }
            }
        }
        return studentClasses;
    }
}