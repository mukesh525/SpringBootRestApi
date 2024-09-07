package com.springdemo.mycoolapp.services;

import com.springdemo.mycoolapp.rest.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;

    public CourseServiceImpl() {
        this.list = new ArrayList<>();
        list.add(new Course(145, "Java Core", "this course contains basic"));
        list.add(new Course(146, "Spring Boot", "this course contains basic"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(Long courseId) {
        Course course = null;
        for (Course course1 : this.list) {
            if (course1.getId() == courseId) {
                course = course1;
                break;
            }
        }

        return course;
    }

    @Override
    public Course deleteCourse(Long courseId) {
        Course courseToRemove = null;

        for (Course course : this.list) {
            if (course.getId() == courseId) {
                courseToRemove = course;
                this.list.remove(course); // Remove the course from the list
                break;
            }
        }

        return courseToRemove; // Return the removed course, or null if not found
    }


    @Override
    public Course addCourse(Course course) {
        this.list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        for (Course existingCourse : this.list) {
            if (existingCourse.getId() == (course.getId())) {
                // Update the details of the course
                existingCourse.setTitle(course.getTitle());
                existingCourse.setDescription(course.getDescription());
                return existingCourse; // Return the updated course
            }
        }
        return null; // Return null if the course is not found
    }
}
