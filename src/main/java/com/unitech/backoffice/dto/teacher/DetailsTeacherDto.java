package com.unitech.backoffice.dto.teacher;

import com.unitech.backoffice.model.Status;
import com.unitech.backoffice.model.Teacher;

public record DetailsTeacherDto(Long id, String name, String login, Status stastus) {
    public DetailsTeacherDto(Teacher teacher) {
        this(teacher.getId(), teacher.getName(), teacher.getLogin(), teacher.getStatus());
    }
}
