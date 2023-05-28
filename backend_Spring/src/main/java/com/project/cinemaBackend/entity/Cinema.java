package com.project.cinemaBackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cinema implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private String address;
    private int countRooms;

    @OneToMany(mappedBy = "cinema")
    private Collection<Room> rooms;

    @ManyToOne
    private City city;

    // constructors
    public Cinema() {}

    public Cinema(String name, String address, int countRooms) {
        this.name = name;
        this.address = address;
        this.countRooms = countRooms;
    }

    public Cinema(String name, String address, int countRooms, City city) {
        this.name = name;
        this.address = address;
        this.countRooms = countRooms;
        this.city = city;
    }

    // getters & setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
