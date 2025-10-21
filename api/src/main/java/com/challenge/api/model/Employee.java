package com.challenge.api.model;

import java.util.Objects;
import java.util.UUID;

public class Employee {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private Double salary;
    private String title;

    // default constructor
    public Employee() {
        this.uuid = UUID.randomUUID();
    }

    // constructor with general fields besides uuid
    public Employee(String firstName, String lastName, String email, String department, Double salary, String title) {
        this.uuid = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.title = title;
    }

    // getters and setters

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // employee comparison override method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(uuid, employee.uuid);
    }

    // quick lookup method
    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    // outputs information and not just memory addresses
    @Override
    public String toString() {
        return "Employee{" + "uuid="
                + uuid + ", firstName='"
                + firstName + '\'' + ", lastName='"
                + lastName + '\'' + ", email='"
                + email + '\'' + ", department='"
                + department + '\'' + ", salary="
                + salary + ", title='"
                + title + '\'' + '}';
    }
}
