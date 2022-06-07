package com.example.learnspringboot.courses.bean;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String author;

    public Course() {
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public long getId() {
        return id;
    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString(){
        return "[" + "id: " + id + "," + "name: " + name + "author: " + author + "]";
    }
}
