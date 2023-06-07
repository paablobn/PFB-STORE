package com.kreitek.store.application.mapper;

import com.kreitek.store.application.dto.UserRegisterDTO;
import com.kreitek.store.domain.entity.UserRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper extends EntityMapper<UserRegisterDTO, UserRegister> {

    @Override
    UserRegister toEntity(UserRegisterDTO dto);

    @Override
    UserRegisterDTO toDto(UserRegister entity);

    default UserRegister fromId(Long id){
        if(id == null){
            return null;
        }
        UserRegister userRegister = new UserRegister();
        userRegister.setId(id);
        return userRegister;
    }
}
