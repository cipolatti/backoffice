package com.unitech.backoffice.dto.teacher;

import com.unitech.backoffice.model.Classes;
import com.unitech.backoffice.model.enums.Status;
import com.unitech.backoffice.model.Teacher;

import java.util.List;

public record DetailTeacherClassDto(Long id, String name, String login, Status stastus, List<Classes> classes) {

    public DetailTeacherClassDto(Teacher teacher, List<Classes> classes) {
        this(teacher.getId(), teacher.getName(), teacher.getLogin(), teacher.getStatus(), classes);
    }
}
