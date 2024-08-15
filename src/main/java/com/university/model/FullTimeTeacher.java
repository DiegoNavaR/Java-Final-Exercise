package com.university.model;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;

    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * (1.10 * experienceYears);
    }

    @Override
    public String toString() {
        return getName() + " (Full-Time), Salary: " + calculateSalary();
    }
}