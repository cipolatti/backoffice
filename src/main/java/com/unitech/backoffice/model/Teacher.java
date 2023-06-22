package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.DataRegisterTeacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Table(name = "teacher")
@Entity(name = "Teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Teacher {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany
    @JoinTable(name="teacher_has_classes", joinColumns=
            {@JoinColumn(name="teacher_id")}, inverseJoinColumns=
            {@JoinColumn(name="classes_id")})
    private List<Classes> listClasses;

    public Teacher(DataRegisterTeacher data) {
        this.name = data.name();
        this.login = data.login();
        this.password = data.password();
        this.status = Status.PENDING;
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
