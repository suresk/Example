package com.experticity.domain.course;

import com.experticity.domain.person.Student;
import com.experticity.domain.person.Teacher;

import java.util.Collection;

public class Course
{
    private Long id;
    private String name;
    private Teacher teacher;
    private Collection<Student> students;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public Collection<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Collection<Student> students)
    {
        this.students = students;
    }
}

  