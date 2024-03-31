package com.josepedevs.JdbcJpaHibernate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter // from lombok to avoid writting the setters and getters
@Getter
@NoArgsConstructor
@AllArgsConstructor //constructor using lombok to avoid writting the constructor
@ToString
public class Course {

    @Id
    private Long id;

    @Column(name = "name")//required if used fetch = FetchType.EAGER
    private String name;

    @Column(name = "author")//this is not required if the column name matches the attribute
    private String author;

}
