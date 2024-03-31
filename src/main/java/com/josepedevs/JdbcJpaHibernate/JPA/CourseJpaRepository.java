package com.josepedevs.JdbcJpaHibernate.JPA;

import com.josepedevs.JdbcJpaHibernate.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional //required for JPA
public class CourseJpaRepository {
    //@Autowired
    @PersistenceContext //The same than Autowired but better semantic for JPA
    private EntityManager entityManager;


    public void insert(Course course){
        entityManager.merge(course);//
    }

    public Course getById(Long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course =  entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}
