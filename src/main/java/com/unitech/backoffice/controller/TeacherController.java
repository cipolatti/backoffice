package com.unitech.backoffice.controller;

import com.unitech.backoffice.dto.teacher.*;
import com.unitech.backoffice.model.TeacherModel;
import com.unitech.backoffice.model.UserModel;
import com.unitech.backoffice.model.validations.ValidateTeacherId;
import com.unitech.backoffice.repository.ClassesRepository;
import com.unitech.backoffice.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    ValidateTeacherId validateTeacherId;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterTeacherDto data, UriComponentsBuilder uriBuilder) {
        var teacher = new TeacherModel(data);
        repository.save(teacher);
        var uri = uriBuilder.path("/teacher/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsTeacherDto(teacher));
    }

    @GetMapping
    public ResponseEntity<Page<ListTeacherDto>> getAll(@PageableDefault(size = 10) Pageable pagination) {
        var page = repository.findAll(pagination).map(ListTeacherDto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id, @AuthenticationPrincipal UserModel userModel) {
        var teacher = repository.getReferenceById(id);
        var classes = classesRepository.findByIdTeacher(id);
        return ResponseEntity.ok(new DetailTeacherClassDto(validateTeacherId.validate(id, userModel, teacher), classes));
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

    @GetMapping("/port")
    public String getPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição pela porta " + port);
    }
}