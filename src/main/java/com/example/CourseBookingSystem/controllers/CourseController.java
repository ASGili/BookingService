package com.example.CourseBookingSystem.controllers;

import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourseByRating(
            @RequestParam(value = "rating", required = false) Integer rating,
            @RequestParam(value = "customer", required = false) String customerName){
        if (rating != null){ List<Course> foundCourses = courseRepository.findByRating(rating);
        return new ResponseEntity<>(foundCourses, HttpStatus.OK);}
        else { List<Course> foundCourses = courseRepository.findByBookings_Customer_Name(customerName);
        return new ResponseEntity<>(foundCourses, HttpStatus.OK);}
    }


}
