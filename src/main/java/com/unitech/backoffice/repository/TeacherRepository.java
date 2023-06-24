package com.unitech.backoffice.repository;

import com.unitech.backoffice.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    UserDetails findByLogin(String username);
}
