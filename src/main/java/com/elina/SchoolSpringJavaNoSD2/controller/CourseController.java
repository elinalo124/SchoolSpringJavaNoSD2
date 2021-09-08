package com.elina.SchoolSpringJavaNoSD2.controller;

import com.elina.SchoolSpringJavaNoSD2.model.Course;
import com.elina.SchoolSpringJavaNoSD2.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseServiceImpl courseServiceImpl;

    @Autowired
    public void setCourseServiceImpl(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    //CREATE
    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course newCourse){
        System.out.println("Controller is saving:\n"+newCourse);
        courseServiceImpl.save(newCourse);
    }

    //RETRIEVE
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        Course course = courseServiceImpl.findById(id);
        System.out.println("get Course\n"+ course);
        return course;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> courses = courseServiceImpl.findAll();
        System.out.println("All courses\n"+courses);
        return courses;
    }
    //UPDATE
    @PutMapping("/courses/{id}")
    public void replaceCourse(@RequestBody Course newCourse) {
        courseServiceImpl.update(newCourse);
    }

    //DELETE
    @DeleteMapping("/courses/{id}")
    void deleteEmployee(@PathVariable Long id) {
        courseServiceImpl.deleteById(id);
    }

}
