package com.kreitek.store.domain.persistence;

import com.kreitek.store.application.dto.UserLoginDTO;
import com.kreitek.store.application.dto.UserRegisterDTO;
import com.kreitek.store.domain.entity.Item;
import com.kreitek.store.domain.entity.UserRegister;

import java.util.Optional;

public interface UserPersistence {
    Optional<UserRegister> getUserById(Long userId);
    UserRegister saveUser(UserRegister user);

    UserRegister getUserByNick(String nick);

    UserRegister getAuth(UserLoginDTO userLoginDTO);
}
