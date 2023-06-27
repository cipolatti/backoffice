package com.unitech.backoffice.repository;

import com.unitech.backoffice.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {

    @Query("select t.id from Teacher t where t.login = ?1")
    Long findByLogin(String login);
}
