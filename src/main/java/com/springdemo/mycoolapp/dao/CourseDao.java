package com.springdemo.mycoolapp.dao;

import com.springdemo.mycoolapp.rest.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {


    // Custom JPQL query to find courses by title
    @Query("SELECT c FROM Course c WHERE c.title = :title")
    List<Course> findCoursesByTitle(@Param("title") String title);

    // Custom SQL query to find courses by description
    @Query(value = "SELECT * FROM Course WHERE description = :description", nativeQuery = true)
    List<Course> findCoursesByDescription(@Param("description") String description);

    // Custom query method to find courses containing a keyword in the title
    List<Course> findByTitleContaining(String keyword);
}
