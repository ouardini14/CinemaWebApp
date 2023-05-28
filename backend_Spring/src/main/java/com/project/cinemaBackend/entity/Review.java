package com.project.cinemaBackend.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private User user;

    // constructors
    public Review() {
    }
    public Review(String message) {
        this.message = message;
    }

    public Review(String message, Movie movie) {
        this.message = message;
        this.movie = movie;
    }

    public Review(String message, Movie movie, User user) {
        this.message = message;
        this.movie = movie;
        this.user = user;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
