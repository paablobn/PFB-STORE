package com.kreitek.store.infraestructure.persistence;

import com.kreitek.store.application.dto.UserLoginDTO;
import com.kreitek.store.domain.entity.UserRegister;
import com.kreitek.store.domain.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserPersistenceImpl implements UserPersistence {
    private final UserRepository userRepository;

    @Autowired
    public UserPersistenceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserRegister> getUserById(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public UserRegister saveUser(UserRegister user) {
        return this.userRepository.save(user);
    }

    @Override
    public UserRegister getUserByNick(String nick) {
        return this.userRepository.findByNick(nick);
    }

    @Override
    public UserRegister getAuth(UserLoginDTO userLoginDTO) {
        UserRegister userRegister = getUserByNick(userLoginDTO.getNick());
        if (userRegister.getPassword().equals(userLoginDTO.getPassword())){
            return userRegister;
        }
        return null;
    }

}
