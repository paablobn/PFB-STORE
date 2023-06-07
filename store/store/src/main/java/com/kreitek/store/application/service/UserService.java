package com.kreitek.store.application.service;

import com.kreitek.store.application.dto.UserLoginDTO;
import com.kreitek.store.application.dto.UserRegisterDTO;
import com.kreitek.store.infraestructure.persistence.UserRepository;

import java.util.Optional;

public interface UserService {
    Optional<UserRegisterDTO> getUserById(Long userId);
    UserRegisterDTO saveUser(UserRegisterDTO userRegisterDTO);
    UserRegisterDTO loginUser(UserLoginDTO userLoginDTO);
}
