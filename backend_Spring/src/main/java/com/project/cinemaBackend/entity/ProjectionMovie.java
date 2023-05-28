package com.project.cinemaBackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class ProjectionMovie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double price;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "projectionMovie")
    private Collection<Ticket> tickets;

    @ManyToOne
    private Session session;

    // constructor
    public ProjectionMovie() {
    }

    public ProjectionMovie(Date dateProjection, double price, Room room, Movie movie, Session session) {
        this.dateProjection = dateProjection;
        this.price = price;
        this.room = room;
        this.movie = movie;
        this.session = session;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateProjection() {
        return dateProjection;
    }

    public void setDateProjection(Date dateProjection) {
        this.dateProjection = dateProjection;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
