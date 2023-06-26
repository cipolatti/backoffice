package com.unitech.backoffice.controller;

import com.unitech.backoffice.dto.classes.DetailsClassesDto;
import com.unitech.backoffice.dto.classes.LinkClassTeacherDto;
import com.unitech.backoffice.dto.classes.RegisterClassesDto;
import com.unitech.backoffice.dto.classes.UpdateClassesDto;
import com.unitech.backoffice.model.Classes;
import com.unitech.backoffice.model.enums.Status;
import com.unitech.backoffice.repository.ClassesRepository;
import com.unitech.backoffice.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassesRepository repository;

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public ResponseEntity register(@RequestBody RegisterClassesDto data, UriComponentsBuilder uriBuilder) {
        var classes = new Classes(data);
        repository.save(classes);
        var uri = uriBuilder.path("/class/{id}").buildAndExpand(classes.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsClassesDto(classes));
    }

    @GetMapping
    public ResponseEntity<Page<Classes>> getAll(@PageableDefault(size = 10, sort = {"expectedClassDate"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(Classes::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateClassesDto data) {
        var classes = repository.getReferenceById(data.id());
        classes.updateInfo(data);
        return ResponseEntity.ok(new DetailsClassesDto(classes));
    }

    @PatchMapping
    @Transactional
    public ResponseEntity linkClassTeacher(@RequestBody @Valid LinkClassTeacherDto data) {
        var classes = repository.getReferenceById(data.id());
        var teacher = teacherRepository.getReferenceById(data.idTeacher());
        if(teacher.getStatus() == Status.APPROVED){
            classes.linkClassTeacher(data);
        }
        return  ResponseEntity.ok(new LinkClassTeacherDto(classes));
    }
}