package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.DataRegisterClass;
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

    public Classes(DataRegisterClass data) {
        this.title = data.title();
        this.descrition = data.descrition();
        this.expectedClassDate = data.expectedClassDate();
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
