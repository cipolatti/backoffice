package com.unitech.backoffice.controller;

import com.unitech.backoffice.dto.teacher.*;
import com.unitech.backoffice.model.Teacher;
import com.unitech.backoffice.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterTeacherDto data, UriComponentsBuilder uriBuilder) {
        var teacher = new Teacher(data);
        repository.save(teacher);
        var uri = uriBuilder.path("/teacher/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsTeacherDto(teacher));
    }

    @GetMapping
    public ResponseEntity<Page<ListTeacherDto>> getAll(@PageableDefault(size = 10) Pageable pagination) {
        var page = repository.findAll(pagination).map(ListTeacherDto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateTeacherDto data) {
        var teacher = repository.getReferenceById(data.id());
        teacher.updateInfo(data);
        return ResponseEntity.ok(new DetailsTeacherDto(teacher));
    }

    @PatchMapping
    @Transactional
    public ResponseEntity updateStatus(@RequestBody @Valid UpdateTeacherStatusDto data) {
        var teacher = repository.getReferenceById(data.id());
        teacher.updateStatus(data);
        return ResponseEntity.ok(new DetailsTeacherDto(teacher));
    }

}
