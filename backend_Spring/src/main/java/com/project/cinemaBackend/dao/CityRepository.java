package com.project.cinemaBackend.dao;

import com.project.cinemaBackend.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CityRepository extends JpaRepository<City, Long> {
}
