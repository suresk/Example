package com.experticity.domain.person;

import com.experticity.domain.course.Course;

import java.util.Collection;

public class Student extends Person
{
    private String studentNumber;
    private Double gpa;
    private Collection<Course> courses;

    public String getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    public Double getGpa()
    {
        return gpa;
    }

    public void setGpa(Double gpa)
    {
        this.gpa = gpa;
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

  