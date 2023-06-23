package com.unitech.backoffice.repository;

import com.unitech.backoffice.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes, Long> {
    @Query("select c from Classes c where c.idTeacher = ?1")
    List<Classes> findByIdTeacher(Long idTeacher);
}
