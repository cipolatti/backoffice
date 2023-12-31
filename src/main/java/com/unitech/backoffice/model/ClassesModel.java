package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.classes.LinkClassTeacherDto;
import com.unitech.backoffice.dto.classes.RegisterClassesDto;
import com.unitech.backoffice.dto.classes.UpdateClassesDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Table(name = "classes")
@Entity(name = "Classes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClassesModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descrition;
    @Column(name = "expected_class_date")
    private String expectedClassDate;
    @Column(name = "id_teacher")
    private Long idTeacher;

    public ClassesModel(RegisterClassesDto data) {
        this.title = data.title();
        this.descrition = data.descrition();
        this.expectedClassDate = data.expectedClassDate();
    }

    public ClassesModel(ClassesModel classesModel) {
        this.id = classesModel.getId();
        this.title = classesModel.getTitle();
        this.descrition = classesModel.getDescrition();
        this.expectedClassDate = classesModel.getExpectedClassDate();
    }

    public ClassesModel(List<ClassesModel> aClasses) {
        for (ClassesModel item: aClasses) {
            this.id = item.getId();
            this.title = item.getTitle();
            this.descrition = item.getDescrition();
            this.expectedClassDate = item.getExpectedClassDate();
            this.idTeacher = item.getIdTeacher();
        }
    }

    public void updateInfo(UpdateClassesDto data) {
        if(data.title() != null){
            this.title = data.title();
        }
        if(data.descrition() != null){
            this.descrition = data.descrition();
        }
        if(data.expectedClassDate() != null){
            this.expectedClassDate = data.expectedClassDate();
        }
    }

    public void linkClassTeacher(LinkClassTeacherDto data) {
        this.idTeacher = data.idTeacher();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassesModel classesModel = (ClassesModel) o;
        return getId() != null && Objects.equals(getId(), classesModel.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
