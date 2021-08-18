package com.assessment;

import java.util.Date;

public class PartTimeEmployee extends Employee {
    private float hoursWorked;

    public PartTimeEmployee(boolean managerFlag, String name, Date dateHired, int id, float hoursWorked) {
        super(managerFlag, name, dateHired, id);
        this.hoursWorked = hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void addHours(float hours) throws PartTimeEmployeeHourLimitException {
        checkHoursWorked(hoursWorked + hours);
        hoursWorked += hours;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    private void checkHoursWorked(float hoursWorked) throws PartTimeEmployeeHourLimitException {
        if (hoursWorked >= 40f) {
            throw new PartTimeEmployeeHourLimitException("Part-Time employee " + name + " has worked more than 40 hours!");
        }
    }
}
