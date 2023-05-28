package com.project.cinemaBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nameClient;

    private double price;
    private String paymentCode;
    private boolean reserve;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ProjectionMovie projectionMovie;

    // constructors
    public Ticket() {
    }

    public Ticket(String nameClient, double price, boolean reserve, Seat seat, ProjectionMovie projectionMovie) {
        this.nameClient = nameClient;
        this.price = price;
        this.reserve = reserve;
        this.seat =seat;
        this.projectionMovie = projectionMovie;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public boolean getReserve() {
        return reserve;
    }

    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public ProjectionMovie getProjectionMovie() {
        return projectionMovie;
    }

    public void setProjectionMovie(ProjectionMovie projectionMovie) {
        this.projectionMovie = projectionMovie;
    }
}
