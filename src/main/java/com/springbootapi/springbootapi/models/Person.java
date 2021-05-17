package com.springbootapi.springbootapi.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private Date dateJoined;

    @Column
    private Date dateUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    @JsonManagedReference
    private Job job;


    public Person() {
    }


    public Person(long id, String name, int age, Date dateJoined, Date dateUpdated, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
        this.job = job;
    }


    public Person(String name, int age, Date dateJoined, Date dateUpdated, Job job) {
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
        this.job = job;
    }

    public Person(long id, String name, int age, Date dateJoined, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.job = job;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateJoined() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.dateJoined);
    }

    public Date dateDateType(){
        return this.dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getDateUpdated() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.dateUpdated);
    }

    public void setDateUpdated(Date date) {
        this.dateUpdated = date;
    }


    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    
}
