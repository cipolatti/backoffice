package com.unitech.backoffice.repository;

import com.unitech.backoffice.model.Classes;
import com.unitech.backoffice.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select t.id from Teacher t where t.login = ?1")
    Long findByLogin(String login);
}
