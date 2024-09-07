package com.springdemo.mycoolapp.rest;

import com.springdemo.mycoolapp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();

    }

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));

    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable String courseId) {
        try {
            boolean isDeleted = this.courseService.deleteCourse(Long.parseLong(courseId)) != null;

            if (isDeleted) {
                ApiResponse response = new ApiResponse("Course deleted successfully", HttpStatus.OK);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("Course not found", HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("An error occurred while deleting the course", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);

    }

    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);

    }
}
