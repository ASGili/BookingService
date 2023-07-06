package com.example.CourseBookingSystem.repositories;

import com.example.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookings_Course_Name(String name);

    List<Customer> findByBookings_Course_NameAndTownIgnoreCase(String name, String town);

    List<Customer> findByTownAndBookings_Course_NameAndAgeGreaterThan(String town, String name, int age);

    List<Customer> findByTownIgnoreCase(String town);



}
