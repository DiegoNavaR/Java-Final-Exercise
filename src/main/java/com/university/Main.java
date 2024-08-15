package com.university;

import com.university.model.*;
import com.university.model.Class;
import com.university.service.University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University();

        FullTimeTeacher fullTimeTeacher1 = new FullTimeTeacher("Diego", 1300000, 5);
        FullTimeTeacher fullTimeTeacher2 = new FullTimeTeacher("Juan", 1300000, 10);
        PartTimeTeacher partTimeTeacher1 = new PartTimeTeacher("Alex", 1300000, 20);
        PartTimeTeacher partTimeTeacher2 = new PartTimeTeacher("Pablo", 1300000, 15);
        university.addTeacher(fullTimeTeacher1);
        university.addTeacher(fullTimeTeacher2);
        university.addTeacher(partTimeTeacher1);
        university.addTeacher(partTimeTeacher2);

        Student student1 = new Student("Karen", 1, 20);
        Student student2 = new Student("Luisa", 2, 21);
        Student student3 = new Student("Brigith", 3, 22);
        Student student4 = new Student("Mabel", 4, 23);
        Student student5 = new Student("Stephany", 5, 24);
        Student student6 = new Student("Jorge", 6, 25);
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
        university.addStudent(student4);
        university.addStudent(student5);
        university.addStudent(student6);

        Class class1 = new Class("Philosophy", "Room 1", fullTimeTeacher1, Arrays.asList(student1, student2, student3));
        Class class2 = new Class("Biology", "Room 2", fullTimeTeacher2, Arrays.asList(student2, student3, student4));
        Class class3 = new Class("Chemistry", "Room 3", partTimeTeacher1, Arrays.asList(student1, student4, student5));
        Class class4 = new Class("Physics", "Room 4", partTimeTeacher2, Arrays.asList(student3, student5, student6));
        university.addClass(class1);
        university.addClass(class2);
        university.addClass(class3);
        university.addClass(class4);

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("University Tracker of Classes");
            System.out.println("1. Print all professors");
            System.out.println("2. Print all classes");
            System.out.println("3. Create a new student and add to a class");
            System.out.println("4. Create a new class");
            System.out.println("5. List all classes for a student by ID");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    university.printAllProfessors();
                    break;
                case 2:
                    university.printAllClasses();
                    System.out.print("Enter class name to view details: ");
                    String className = scanner.nextLine();
                    Class selectedClass = university.findClassByName(className);
                    if (selectedClass != null) {
                        System.out.println(selectedClass);
                    } else {
                        System.out.println("Class not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine();

                    Student newStudent = new Student(studentName, studentId, studentAge);
                    university.addStudent(newStudent);

                    System.out.print("Enter class name to add the student: ");
                    String classNameForStudent = scanner.nextLine();
                    Class classForStudent = university.findClassByName(classNameForStudent);
                    if (classForStudent != null) {
                        classForStudent.getStudents().add(newStudent);
                        System.out.println("Student added to class.");
                    } else {
                        System.out.println("Class not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter class name: ");
                    String newClassName = scanner.nextLine();
                    System.out.print("Enter classroom: ");
                    String newClassroom = scanner.nextLine();

                    System.out.print("Enter teacher name: ");
                    String teacherName = scanner.nextLine();
                    Teacher assignedTeacher = null;
                    for (Teacher t : university.getTeachers()) {
                        if (t.getName().equals(teacherName)) {
                            assignedTeacher = t;
                            break;
                        }
                    }

                    if (assignedTeacher == null) {
                        System.out.println("Teacher not found.");
                        break;
                    }

                    System.out.print("Enter student IDs separated by commas: ");
                    String[] studentIds = scanner.nextLine().split(",");
                    List<Student> assignedStudents = new ArrayList<>();
                    for (String id : studentIds) {
                        for (Student s : university.getStudents()) {
                            if (s.getId() == Integer.parseInt(id.trim())) {
                                assignedStudents.add(s);
                                break;
                            }
                        }
                    }

                    Class newClass = new Class(newClassName, newClassroom, assignedTeacher, assignedStudents);
                    university.addClass(newClass);
                    System.out.println("Class created and added to university.");
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    List<Class> studentClasses = university.getClassesForStudent(id);
                    if (studentClasses.isEmpty()) {
                        System.out.println("No classes found for the student.");
                    } else {
                        for (Class c : studentClasses) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 6);

        scanner.close();
    }
}