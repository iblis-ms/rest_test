package com.github.iblis.ms.SpringRestTest.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private List<Book> books;
}
