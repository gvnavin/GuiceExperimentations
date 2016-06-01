package com.discursive.example.student;

/**
 * Created by gnavin on 5/31/16.
 */
public class Student {
    private Integer id;
    private String name;
    private Integer credits;
    private Boolean registered;
    private String major;
    private Integer year;

    public Student() {}

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(final Integer credits) {
        this.credits = credits;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(final Boolean registered) {
        this.registered = registered;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(final String major) {
        this.major = major;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public Student(Integer id, Integer credits ) {
        this.id = id;
        this.credits = credits;
    }
}
