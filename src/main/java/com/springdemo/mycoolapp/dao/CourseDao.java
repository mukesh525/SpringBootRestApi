package com.springdemo.mycoolapp.dao;

import com.springdemo.mycoolapp.rest.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
