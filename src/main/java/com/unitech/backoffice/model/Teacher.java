package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.teacher.RegisterTeacherDto;
import com.unitech.backoffice.dto.teacher.UpdateTeacherDto;
import com.unitech.backoffice.dto.teacher.UpdateTeacherStatusDto;
import com.unitech.backoffice.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "teacher")
@Entity(name = "Teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Teacher{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    @Setter
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Teacher(RegisterTeacherDto data) {
        this.name = data.name();
        this.login = data.login();
        this.password = data.password();
        this.status = Status.PENDING;
    }

    public void updateInfo(UpdateTeacherDto data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.login() != null){
            this.login = data.login();
        }
        if(data.password() != null){
            this.password = data.password();
        }
    }

    public void updateStatus(UpdateTeacherStatusDto data) {
        this.status = data.status();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Teacher teacher = (Teacher) o;
        return getId() != null && Objects.equals(getId(), teacher.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}