package com.springdemo.mycoolapp.services;

import com.springdemo.mycoolapp.rest.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(Long courseId);

    public Course deleteCourse(Long courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course);
}
