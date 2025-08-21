package com.majorProject.airBnbApp.airBnbApp.repository;

import com.majorProject.airBnbApp.airBnbApp.entity.Guest;
import com.majorProject.airBnbApp.airBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {
    List<Guest> findByUser(User user);
}
