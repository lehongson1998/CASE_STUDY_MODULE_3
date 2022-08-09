package model.person.employee;

import model.person.Person;

import java.time.LocalDate;

public class Employee extends Person {
    private double salary;
    private int positionId;
    private int educationDegreeId;
    private int divisionId;


    public Employee(int id, String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address) {
        super(id, name, dateOfBirth, idCard, phoneNumber, email, address);
    }

    public Employee(String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, double salary, int positionId, int educationDegreeId, int divisionId) {
        super(name, dateOfBirth, idCard, phoneNumber, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
}
