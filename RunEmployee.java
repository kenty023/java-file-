package com.mycompany.runemployee;

import java.util.*;

public class RunEmployee {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = console.nextLine();

        System.out.print("Enter 'F' for Full Time or 'P' for Part Time: ");
        char employeeType = console.next().charAt(0);

        if (employeeType == 'F' || employeeType == 'f') {
        System.out.print("Enter monthly salary: ");
        double monthlySalary = console.nextDouble();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, monthlySalary);
        fullTimeEmployee.displayInfo();
        } else if (employeeType == 'P' || employeeType == 'p') {
        System.out.print("Enter rate per hour and number of hours worked (separated by space): ");
        double ratePerHour = console.nextDouble();
        int hoursWorked = console.nextInt();
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, ratePerHour, hoursWorked);
        partTimeEmployee.displayInfo();
        } else {
            System.out.println("Invalid input. Please enter 'F' for Full Time or 'P' for Part Time.");
        }
    }
}

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    public void displayInfo() {
        System.out.println("Name: " + super.name);
        System.out.println("Monthly Salary: $" + String.format("%.2f", monthlySalary));
    }
}

class PartTimeEmployee extends Employee {
    private double ratePerHour;
    private int hoursWorked;

    public PartTimeEmployee(String name, double ratePerHour, int hoursWorked) {
        super(name);
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
    }

    public void displayInfo() {
        System.out.println("Name: " + super.name);
        System.out.println("Wage: $" + String.format("%.2f", ratePerHour * hoursWorked));
    }
}
