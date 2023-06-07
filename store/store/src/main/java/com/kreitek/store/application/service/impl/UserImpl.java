package com.kreitek.store.application.service.impl;

import com.kreitek.store.application.dto.UserLoginDTO;
import com.kreitek.store.application.dto.UserRegisterDTO;
import com.kreitek.store.application.mapper.UserRegisterMapper;
import com.kreitek.store.application.service.UserService;
import com.kreitek.store.domain.entity.UserRegister;
import com.kreitek.store.domain.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {

    private final UserPersistence persistence;
    private final UserRegisterMapper mapper;

    @Autowired
    public UserImpl(UserPersistence persistence, UserRegisterMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserRegisterDTO> getUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public UserRegisterDTO saveUser(UserRegisterDTO userRegisterDTO) {
        UserRegister userSaved = this.persistence.saveUser(this.mapper.toEntity(userRegisterDTO));
        return this.mapper.toDto(userSaved);
    }

    @Override
    public UserRegisterDTO loginUser(UserLoginDTO userLoginDTO) {
        UserRegisterDTO userAuth = mapper.toDto(persistence.getAuth(userLoginDTO));
        return userAuth;
    }
}
