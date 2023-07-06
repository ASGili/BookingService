package com.example.CourseBookingSystem.controllers;

import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomersByParameter(
            @RequestParam(name = "coursename", required = false) String name,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age){
        if (age != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookings_Course_NameAndAgeGreaterThan(town, name, age), HttpStatus.OK);
        } else if (town != null){
            return new ResponseEntity<>(customerRepository.findByBookings_Course_NameAndTownIgnoreCase(name, town), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findByBookings_Course_Name(name), HttpStatus.OK);
    }

}
