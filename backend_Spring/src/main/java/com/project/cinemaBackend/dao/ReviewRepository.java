package com.project.cinemaBackend.dao;

import com.project.cinemaBackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
