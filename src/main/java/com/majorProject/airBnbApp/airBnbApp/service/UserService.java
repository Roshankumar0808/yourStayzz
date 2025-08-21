package com.majorProject.airBnbApp.airBnbApp.service;

import com.majorProject.airBnbApp.airBnbApp.dto.ProfileUpdateRequestDto;
import com.majorProject.airBnbApp.airBnbApp.dto.UserDto;
import com.majorProject.airBnbApp.airBnbApp.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
