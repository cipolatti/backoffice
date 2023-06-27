package com.unitech.backoffice.model.validations;

import com.unitech.backoffice.dto.teacher.RegisterTeacherDto;
import com.unitech.backoffice.model.TeacherModel;
import com.unitech.backoffice.model.UserModel;
import com.unitech.backoffice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateTeacherId {

    @Autowired
    private TeacherRepository repository;

    public TeacherModel validate(Long id, UserModel userModel, TeacherModel teacher) {
        var teacherDto = new RegisterTeacherDto(teacher.getName(), teacher.getLogin());
        if (!userModel.getRoleModels().get(0).getRoleName().name().equals("ADMIN")) {
            if (!userModel.getLogin().equalsIgnoreCase(teacherDto.login())) {
                id = repository.findByLogin(userModel.getLogin());
                return repository.getReferenceById(id);
            }
        }
        return teacher;
    }
}

