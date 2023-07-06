package com.example.CourseBookingSystem.other;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Course bakingCourse = new Course("Baking for beginners", "Luxembourg", 4);
        courseRepository.save(bakingCourse);
        Customer Ben = new Customer("Ben", "Edinburgh", 40);
        Customer Jen = new Customer("Jen", "Glasgow", 45);
        Customer Ken = new Customer("Ken", "Street", 20);
        customerRepository.save(Ben);
        customerRepository.save(Jen);
        customerRepository.save(Ken);
        Booking booking1 = new Booking("05-JUL", bakingCourse, Ben);
        Booking booking2 = new Booking("05-JUL", bakingCourse, Jen);
        Booking booking3 = new Booking("25-DEC", bakingCourse, Ken);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);

    }
    }
