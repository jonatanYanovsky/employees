package com.assessment;

import java.util.Date;

/*

Employee
- managerFlag : boolean
- name : String
- dateHired : Date
- id : int
+ getName() : String
+ getID() : String
+ getDateHired() : Date
+ isManager() : boolean

*/

public class Employee {
    protected boolean managerFlag;
    protected String name;
    protected Date dateHired;
    protected int id;

    public Employee(boolean managerFlag, String name, Date dateHired, int id) {
        this.managerFlag = managerFlag;
        this.dateHired = dateHired;
        this.id = id;
        this.name = name;
    }

    public void setManagerFlag(boolean managerFlag) {
        this.managerFlag = managerFlag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean getManagerFlag() {
        return managerFlag;
    }

    public String getName() {
        return name;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public int getId() {
        return id;
    }

}
