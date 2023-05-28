package com.project.cinemaBackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<Movie> movies;

    // constructors
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Collection<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }
}
