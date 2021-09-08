package com.elina.SchoolSpringJavaNoSD2.service;

import com.elina.SchoolSpringJavaNoSD2.model.Course;
import com.elina.SchoolSpringJavaNoSD2.repository.CourseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService{

    private CourseRepositoryImpl repository;

    public CourseServiceImpl() {
        System.out.println("Constructing CourseServiceImpl with no args");
    }

    @Autowired
    public void setRepository(CourseRepositoryImpl repository) {
        this.repository = repository;
        System.out.println("Setting repo for CourseServiceImpl");
    }

    @Transactional
    public void save(Course course){
        System.out.println("Service is saving:\n"+course);
        repository.save(course);
    }

    @Transactional
    public Course findById(Long id){
        return repository.findById(id);
    }

    /*
    public List<Course> findByName(String name){
        return repository.findByName(name);
    }
    */


    @Transactional
    public List<Course> findAll(){
        return (List<Course>) repository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public void update(Course newCourse) {
        repository.update(newCourse);
    }

}
