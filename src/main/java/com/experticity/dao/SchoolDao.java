package com.experticity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SchoolDao
{

    @Autowired
    ResourceLoader resourceLoader;
    
    public List<Map<String, String>> getStudents()
    {
        return loadTextFile("students.csv");
    }
    
    public Map<String, String> getStudentById(Long studentId)
    {
        for(Map<String,String> student : getStudents())
        {
            if(studentId.equals(Long.valueOf(student.get("id"))))
            {
                return student;
            }
        }
        
        return null;
    }
    
    public List<Map<String, String>> getTeachers()
    {
        return loadTextFile("teachers.csv");
    }
    
    public Map<String, String> getTeacherById(Long teacherId)
    {
        for(Map<String,String> teacher : getTeachers())
        {
            if(teacherId.equals(Long.valueOf(teacher.get("id"))))
            {
                return teacher;
            }
        }
        
        return null;
    }
    
    public List<Map<String, String>> getCourses()
    {
        return loadTextFile("courses.csv");
    }
    
    public Map<String, String> getCourseById(Long courseId)
    {
        for(Map<String,String> course : getCourses())
        {
            if(courseId.equals(Long.valueOf(course.get("id"))))
            {
                return course;
            }
        }
        
        return null;
    }
    
    public List<Long> getStudentIdsForCourse(Long courseId)
    {
        List<Long> studentIds = new ArrayList<>();
        
        List<Map<String, String>> studentCourses = loadTextFile("student-courses.csv");
        
        for(Map<String, String> studentCourse : studentCourses)
        {
            Long candidateCourseId = Long.valueOf(studentCourse.get("courseId"));
            if(candidateCourseId.equals(courseId))
            {
                studentIds.add(Long.valueOf(studentCourse.get("studentId")));
            }
        }
        
        return studentIds;
    }
    
    public List<Long> getCourseIdsForStudent(Long studentId)
    {
        List<Long> courseIds = new ArrayList<>();
        
        List<Map<String, String>> studentCourses = loadTextFile("student-courses.csv");
        
        for(Map<String, String> studentCourse : studentCourses)
        {
            Long candidateStudentId = Long.valueOf(studentCourse.get("studentId"));
            if(candidateStudentId.equals(studentId))
            {
                courseIds.add(Long.valueOf(studentCourse.get("courseId")));
            }
        }
        
        return courseIds;
    }
    
    public List<Map<String, String>> loadTextFile(String name)
    {
        try
        {
            Resource resource = resourceLoader.getResource(String.format("classpath:%s", name));
            InputStream is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String[] headers = null;
            List<Map<String, String>> records = new ArrayList<>();
            
            while(br.ready())
            {
                String line = br.readLine();
                if(headers == null)
                {
                    headers = line.split(",");    
                }
                else
                {
                    String[] data = line.split(",");
                    Map<String, String> record = new HashMap<>();
                    
                    for(int i = 0; i < headers.length; i++)
                    {
                        record.put(headers[i], data[i]);
                    }
                    
                    records.add(record);
                }
            }
            
            return records;
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
}
