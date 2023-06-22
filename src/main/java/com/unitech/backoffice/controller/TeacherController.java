package com.unitech.backoffice.controller;

import com.unitech.backoffice.dto.DataRegisterTeacher;
import com.unitech.backoffice.model.Teacher;
import com.unitech.backoffice.dto.DataListTeacher;
import com.unitech.backoffice.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Teacher!";
    }
    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterTeacher data) {
        repository.save(new Teacher(data));
    }

    @GetMapping
    public List<DataListTeacher> getAll() {
        return repository.findAll().stream().map(DataListTeacher::new).toList();
    }

}
