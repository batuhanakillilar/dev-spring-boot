package com.batu.springboot.cruddemo.entity;

import jakarta.persistence.*;


@Entity
@Table(name="employee")
public class Employee {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //define constructors

    public Employee(){


    }

    public Employee(String firstname, String lastName, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
    }

    //define getter/setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;

    }
    public String getFirstname() {
        return firstname;

    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    //define toString


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
