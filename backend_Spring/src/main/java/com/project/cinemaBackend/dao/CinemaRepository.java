package com.project.cinemaBackend.dao;

import java.util.List;
import com.project.cinemaBackend.entity.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    List<Cinema> findByCityId(Long id);

    long deleteCinemaByIdAndCityId(Long id, Long cityId);

//    Cinema findCinemaByIdAndCityId(Long id, Long cityId);


}
