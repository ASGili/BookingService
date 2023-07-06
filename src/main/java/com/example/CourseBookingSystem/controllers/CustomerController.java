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
    public ResponseEntity<List<Customer>> getCustomersByParameter(@RequestParam(name = "coursename", required = false) String name){
        return new ResponseEntity<>(customerRepository.findByBookings_Course_Name(name), HttpStatus.OK);
    }

}
