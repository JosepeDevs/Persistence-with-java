package com.josepedevs.JdbcJpaHibernate;

import com.josepedevs.JdbcJpaHibernate.SpringJPA.CourseSpringJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //@Autowired
    //private CourseJdbcRepository repository; //To use JDBC

//    @Autowired
//    private CourseJpaRepository repository; //To use JPA

    @Autowired
    private CourseSpringJpaRepository repository; //To use Spring data JPA

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1L, "curso 1", "josepe"));
        repository.save(new Course(2L, "curso 2", "josepe"));
        repository.save(new Course(3L, "curso 3", "josepe"));
        repository.save(new Course(4L, "curso 4", "josepe"));
        repository.save(new Course(5L, "curso 5", "josepe"));
        repository.deleteById(1L);
        Course curso = new Course();
        curso = repository.findCourseById(2L);
        System.out.println(curso.toString());
    }
}
