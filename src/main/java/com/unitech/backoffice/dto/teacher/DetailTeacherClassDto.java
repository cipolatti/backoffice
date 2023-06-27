package com.unitech.backoffice.dto.teacher;

import com.unitech.backoffice.model.ClassesModel;
import com.unitech.backoffice.model.TeacherModel;
import com.unitech.backoffice.model.enums.Status;

import java.util.List;

public record DetailTeacherClassDto(Long id, String name, String login, Status stastus, List<ClassesModel> aClasses) {

    public DetailTeacherClassDto(TeacherModel teacher, List<ClassesModel> aClasses) {
        this(teacher.getId(), teacher.getName(), teacher.getLogin(), teacher.getStatus(), aClasses);
    }
}
