package hometasks.task2.solutions.chapter3;

import java.security.MessageDigest;

// Check package task1.solutions Employeee

public class Employee implements Measurable {

    private double salary;
    private String name;


    public Employee(double salary) {
        this.salary = salary;
    }

    public void setSalary(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    static double average(Measurable[] objects) {
        double averageMeasure = 0.0;
        for (Measurable a : objects) {
            averageMeasure += a.getMeasure();
        }
        return  averageMeasure / (double) objects.length;
    }

    static Measurable largest(Measurable[] objects) {
        double max = 0.0;
        Measurable out = objects[0];
        for (Measurable a: objects) {
            if (a.getMeasure() > max) {
                max = (a.getMeasure());
                out = a;
            }
        }
        return out;
    }
}


