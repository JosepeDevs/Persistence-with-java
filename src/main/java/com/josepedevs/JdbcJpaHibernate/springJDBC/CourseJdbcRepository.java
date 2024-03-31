package com.josepedevs.JdbcJpaHibernate.springJDBC;

import com.josepedevs.JdbcJpaHibernate.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {


    @Autowired
private JdbcTemplate springJdbcTemplate;

    private final String INSERT_QUERY = "INSERT INTO course (id, name, author) values (?, ?, ?)";
    private final String DELETE_QUERY = "DELETE FROM course WHERE ID=?";
    private final String SELECT_QUERY = "SELECT * FROM course WHERE ID=?";

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(Long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
    public Course getById(Long id){
        return springJdbcTemplate.queryForObject(
                SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), // This helps map the table to a bean with Course properties class
                id);
    };

}
