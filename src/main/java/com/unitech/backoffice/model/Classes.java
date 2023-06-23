package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.classes.RegisterClassesDto;
import com.unitech.backoffice.dto.classes.UpdateClassesDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "classes")
@Entity(name = "Classes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Classes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descrition;
    @Column(name = "expected_class_date")
    private String expectedClassDate;
    @Column(name = "id_teacher")
    private Long idTeacher;

    public Classes(RegisterClassesDto data) {
        this.title = data.title();
        this.descrition = data.descrition();
        this.expectedClassDate = data.expectedClassDate();
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

    public Classes(Classes classes) {
        this.id = classes.getId();
        this.title = classes.getTitle();
        this.expectedClassDate = classes.getExpectedClassDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Classes classes = (Classes) o;
        return getId() != null && Objects.equals(getId(), classes.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
