package com.majorProject.airBnbApp.airBnbApp.repository;

import com.majorProject.airBnbApp.airBnbApp.entity.Room;
import com.majorProject.airBnbApp.airBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

}
