package com.itfactory;



public class Job
{
    private int id;
    private String name;
    private String domain;
    private double baseSalary;

    public Job(int id, String name, String domain, double baseSalary)
    {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.baseSalary = baseSalary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDomain()
    {
        return domain;
    }

    public double getBaseSalary()
    {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}