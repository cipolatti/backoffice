package com.unitech.backoffice.dto.teacher;

import com.unitech.backoffice.model.TeacherModel;
import com.unitech.backoffice.model.enums.Status;

public record ListTeacherDto(Long id, String name, String login, Status status) {
    public ListTeacherDto(TeacherModel teacher){
        this(teacher.getId(), teacher.getName(), teacher.getLogin(), teacher.getStatus());
    }
}
