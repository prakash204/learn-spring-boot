package com.example.learnspringboot.courses.controller;

import com.example.learnspringboot.courses.bean.Course;
import com.example.learnspringboot.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.OptionalDataException;
import java.nio.file.Path;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repository;

    //http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return repository.findAll();
//        return Arrays.asList(new Course(1,"java compiling","shashi"),
//                new Course(2,"c++ compiling","shashi"));
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable long id){
        Optional<Course> course = repository.findById(id);
        if (course.isEmpty()) {
            throw new RuntimeException("Course with id : " + id + ", not found");
        }
        return course.get();
        //return new Course(1,"java compiling 2","shashi");
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course) {
        repository.save(course);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course) {
        repository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id){
        repository.deleteById(id);
    };
}
