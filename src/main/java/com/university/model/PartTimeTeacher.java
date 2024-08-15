package com.university.model;

public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, int activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * activeHoursPerWeek;
    }

    @Override
    public String toString() {
        return getName() + " (Part-Time), Salary: " + calculateSalary();
    }
}