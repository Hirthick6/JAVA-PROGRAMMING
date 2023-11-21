/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrk1;
import java.util.Scanner;

class Employee {
    String name;
    int age;
    int empId;

    public Employee(String name, int age, int empId) {
        this.name = name;
        this.age = age;
        this.empId = empId;
    }
}

class Payroll extends Employee {
    String designation;
    double basicSalary;

    public Payroll(String name, int age, int empId, String designation, double basicSalary) {
        super(name, age, empId);
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    public double calculateAllowance() {
        // Calculate allowances based on designation (assuming some arbitrary rules)
        if (designation.equals("Manager")) {
            return 0.2 * basicSalary;
        } else if (designation.equals("Employee")) {
            return 0.15 * basicSalary;
        } else {
            return 0.1 * basicSalary;
        }
    }

    public double calculateDeduction() {
        // Calculate deductions (assuming some arbitrary rules)
        // For example, 5% of basic salary as deduction
        return 0.05 * basicSalary;
    }

    public double calculateNetSalary() {
        double allowance = calculateAllowance();
        double deduction = calculateDeduction();
        return basicSalary + allowance - deduction;
    }
}

public class PayrollGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        Payroll[] employees = new Payroll[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = scanner.next();
            System.out.print("Enter employee age: ");
            int age = scanner.nextInt();
            System.out.print("Enter employee ID: ");
            int empId = scanner.nextInt();
            System.out.print("Enter employee designation (Manager/Employee/Other): ");
            String designation = scanner.next();
            System.out.print("Enter basic salary: ");
            double basicSalary = scanner.nextDouble();

            employees[i] = new Payroll(name, age, empId, designation, basicSalary);
        }

        System.out.println("\nEmployee Payroll Details:");
        for (Payroll employee : employees) {
            double netSalary = employee.calculateNetSalary();
            System.out.println("Name: " + employee.name);
            System.out.println("Age: " + employee.age);
            System.out.println("Employee ID: " + employee.empId);
            System.out.println("Designation: " + employee.designation);
            System.out.println("Basic Salary: " + employee.basicSalary);
            System.out.println("Allowance: " + employee.calculateAllowance());
            System.out.println("Deduction: " + employee.calculateDeduction());
            System.out.println("Net Salary: " + netSalary);
            
        }

        scanner.close();
    }
}

