package com.springbootapi.springbootapi.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String jobTitle;

    @Column
    private int salary;

    @OneToOne(mappedBy = "job", cascade = CascadeType.ALL)
    @JsonBackReference
    private Person person;


    public Job(long id, String jobTitle, int salary, Person person) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.person = person;
    }


    public Job(String jobTitle, int salary, Person person) {
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.person = person;
    }

    public Job() {
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
