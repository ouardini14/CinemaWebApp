package com.project.cinemaBackend.dao;

import com.project.cinemaBackend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface RoomRepository extends JpaRepository<Room, Long> {

    
        int countByCinemaId(Long cinemaId);
}
