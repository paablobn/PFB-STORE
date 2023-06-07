package com.kreitek.store.infraestructure.persistence;

import com.kreitek.store.domain.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegister, Long>, JpaSpecificationExecutor<UserRegister> {

   UserRegister findByNick(String nick);
}
