package com.unitech.backoffice.repository;

import com.unitech.backoffice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    UserDetails findByLogin(String subject);
}
