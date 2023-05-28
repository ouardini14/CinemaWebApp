package com.project.cinemaBackend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Session implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date hourStart;

    // constructors
    public Session() {
    }

    public Session(Date hourStart) {
        this.hourStart = hourStart;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHourStart() {
        return hourStart;
    }

    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
    }
}
