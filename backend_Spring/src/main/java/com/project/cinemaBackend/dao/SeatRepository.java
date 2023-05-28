package com.project.cinemaBackend.dao;

import com.project.cinemaBackend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
