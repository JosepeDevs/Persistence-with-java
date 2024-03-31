package com.josepedevs.JdbcJpaHibernate.SpringJPA;

import com.josepedevs.JdbcJpaHibernate.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//we have to say the type that we are using and the type of the primary key
public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {

    //We can use @Query to use a JPQL query to get custom methods using jpa
    //@param is used to bind a parameter to the query
    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Course findCourseById(@Param("id") Long id);

}
