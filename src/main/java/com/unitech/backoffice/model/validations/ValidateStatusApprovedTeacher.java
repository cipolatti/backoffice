package com.unitech.backoffice.model.validations;

import com.unitech.backoffice.model.enums.Status;
import com.unitech.backoffice.repository.TeacherRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateStatusApprovedTeacher {

    @Autowired
    private TeacherRepository repository;

    public boolean validate(@NotNull Long teacherId) {
        var teacherModel = repository.getReferenceById(teacherId);
        if (teacherModel.getStatus() == Status.APPROVED) {
                return true;
            }
        return false;
    }
}

