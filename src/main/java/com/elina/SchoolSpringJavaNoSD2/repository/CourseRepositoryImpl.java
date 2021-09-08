package com.elina.SchoolSpringJavaNoSD2.repository;


import com.elina.SchoolSpringJavaNoSD2.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("courseRepository")
public class CourseRepositoryImpl extends AbstractJPARepository<Course>{

    public CourseRepositoryImpl(){
        setClazz(Course.class );
    }

}
