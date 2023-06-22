package com.unitech.backoffice.dto;

import com.unitech.backoffice.model.Status;
import com.unitech.backoffice.model.Teacher;

public record DataListTeacher(Long id, String name, String login, Status status) {
    public DataListTeacher(Teacher teacher){
        this(teacher.getId(), teacher.getName(), teacher.getLogin(), teacher.getStatus());
    }
}
