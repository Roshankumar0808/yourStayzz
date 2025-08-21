package com.majorProject.airBnbApp.airBnbApp.repository;

import com.majorProject.airBnbApp.airBnbApp.entity.Hotel;
import com.majorProject.airBnbApp.airBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByOwner(User user);
}
