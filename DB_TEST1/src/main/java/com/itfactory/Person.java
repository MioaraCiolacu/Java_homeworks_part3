package com.itfactory;

public class Person {
    private int id;
    private String name;
    private String email;
    private int jobId;

    private String telefon;

    public Person(int id, String name, String email, int jobId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobId = jobId;
    }

    public Person(int id, String name, String email, int jobId, String telefon) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobId = jobId;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTelefon() {
        return telefon;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobId=" + jobId +
                ", telephone='" + telefon + '\'' +
                '}';
    }
}