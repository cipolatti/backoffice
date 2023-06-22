package com.unitech.backoffice.controller;

import com.unitech.backoffice.model.Classes;
import com.unitech.backoffice.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unitech.backoffice.dto.DataRegisterClass;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassesRepository repository;
    @PostMapping
    public void register(@RequestBody DataRegisterClass data) {
        repository.save(new Classes(data));
    }
}
