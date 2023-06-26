package com.unitech.backoffice.repository;

import com.unitech.backoffice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    UserModel findByLogin(String subject);
}
