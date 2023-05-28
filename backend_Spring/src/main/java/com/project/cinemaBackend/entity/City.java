package com.project.cinemaBackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class City implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "city")
    private Collection<Cinema> cinemas;

    // constructors
    public City() { }

    public City(String name) {
        this.name = name;
    }

    public City(String name, Collection<Cinema> cinemas) {
        this.name = name;
        this.cinemas = cinemas;
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

    public Collection<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Collection<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
