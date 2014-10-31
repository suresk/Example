package com.experticity.domain.person;

import com.experticity.domain.course.Course;

import java.util.Collection;

public class Teacher extends Person
{
    private Double salary;
    private Collection<Course> courses;

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    public Collection<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(Collection<Course> courses)
    {
        this.courses = courses;
    }

}

  