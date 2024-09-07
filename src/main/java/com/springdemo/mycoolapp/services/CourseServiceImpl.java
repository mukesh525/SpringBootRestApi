package com.springdemo.mycoolapp.services;

import com.springdemo.mycoolapp.dao.CourseDao;
import com.springdemo.mycoolapp.rest.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourse(Long courseId) {
        Optional<Course> course = this.courseDao.findById(courseId);
        return course.orElse(null); // Return the course if found, or null if not found
    }

    @Override
    public Course addCourse(Course course) {
        return this.courseDao.save(course); // Save and return the course
    }

    @Override
    public Course updateCourse(Course course) {
        if (this.courseDao.existsById(course.getId())) {
            return this.courseDao.save(course); // Update and return the course
        }
        return null; // Return null if the course does not exist
    }

    @Override
    public Course deleteCourse(Long courseId) {
        Optional<Course> courseToRemove = this.courseDao.findById(courseId);
        if (courseToRemove.isPresent()) {
            this.courseDao.deleteById(courseId); // Delete the course by ID
            return courseToRemove.get(); // Return the removed course
        }
        return null; // Return null if the course is not found
    }
}
