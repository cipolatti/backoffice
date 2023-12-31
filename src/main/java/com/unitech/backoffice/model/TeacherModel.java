package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.teacher.RegisterTeacherDto;
import com.unitech.backoffice.dto.teacher.UpdateTeacherDto;
import com.unitech.backoffice.dto.teacher.UpdateTeacherStatusDto;
import com.unitech.backoffice.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "teacher")
@Entity(name = "Teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TeacherModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    @Enumerated(EnumType.STRING)
    private Status status;

    public TeacherModel(RegisterTeacherDto data) {
        this.name = data.name();
        this.login = data.login();
        this.status = Status.PENDING;
    }

    public void updateInfo(UpdateTeacherDto data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.login() != null){
            this.login = data.login();
        }
    }

    public void updateStatus(UpdateTeacherStatusDto data) {
        this.status = data.status();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeacherModel teacher = (TeacherModel) o;
        return getId() != null && Objects.equals(getId(), teacher.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}