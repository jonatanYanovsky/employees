package com.assessment;

import java.util.Date;

/**

You are modifying a human resources application. The current Employee class looks like
this:

Employee
- managerFlag : boolean
- name : String
- dateHired : Date
- id : int
+ getName() : String
+ getID() : String
+ getDateHired() : Date
+ isManager() : boolean

Currently everyone is an Employee and some of those are Managers, which is
determined by calling the isManager() method. The company has now started hiring part-
time employees, so the system must be modified to keep track of them.
Create a new implementation of the Employee class which provides the flexibility
required to support the new part-time employee notion. You are free to refactor this class
as required and add additional classes if needed.

 */


// assume a manager can also be working part time
// part time workers should not work more than 40 hours a week. keep track of hours worked for part time
// add a set/get for hours worked, and trigger an alert if more than 40
// part-time is a child of employee, as they share fields and methods
// usages of the Employee class will not require complex rework - just some special cases to check if an Employee is also PartTime
// add some examples showing polymorphism checks for PartTime vs Employee 
// add some examples getting error messages when adding more than 40 hours to a part time employee


public final class App {
    public static void main(String[] args) {
        // assume this is some system that operates on Employee objects

        // create some fake employees

        int employee_id = 0;

        Date debra_date_hired = new Date();
        Employee debra = new Employee(true, "Debra Bush", debra_date_hired, employee_id++);
        performEmployeeMutation(debra);


        Date emily_date_hired = new Date();
        Employee emily = new Employee(false, "Emily Onion", emily_date_hired, employee_id++);
        performEmployeeMutation(emily);


        Date elijah_date_hired = new Date();
        PartTimeEmployee elijah = new PartTimeEmployee(false, "Elijah Conan", elijah_date_hired, employee_id++, 35f);
        performEmployeeMutation(elijah);


        Date sandra_date_hired = new Date();
        PartTimeEmployee sandra = new PartTimeEmployee(true, "Sandra Su", sandra_date_hired, employee_id++, 22f);
        performEmployeeMutation(sandra);


    }

    // example method showing how Employees can be mutated
    private static void performEmployeeMutation(Employee employee) {
        if (employee instanceof PartTimeEmployee) {
            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
            try {
                partTimeEmployee.addHours(5f);
                System.out.println("Part Time Employee " + partTimeEmployee.getName() + " is working " + partTimeEmployee.getHoursWorked() + " hours.");
            } catch (PartTimeEmployeeHourLimitException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        System.out.println("Employee " + employee.getName() + " is: " + (employee.getManagerFlag() ? "a manager": "not a manager") + "\n");
    }
}
