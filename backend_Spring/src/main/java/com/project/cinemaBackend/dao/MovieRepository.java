package com.project.cinemaBackend.dao;

import com.project.cinemaBackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
