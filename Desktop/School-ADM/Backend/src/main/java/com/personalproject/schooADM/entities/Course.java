package com.personalproject.schooADM.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name= "course_name", nullable = false, unique=true)
    private String name;

    @Column(name= "active_status", nullable = false)
    private Boolean activeStatus;

    @OneToMany(mappedBy = "course")
    private List<CourseLevel> courseList;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    public Course(){

    }

    public Course(String name, Boolean activeStatus, Language language) {
        this.name = name;
        this.activeStatus = activeStatus;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<CourseLevel> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseLevel> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId()) && Objects.equals(getName(), course.getName()) && Objects.equals(getActiveStatus(), course.getActiveStatus()) && Objects.equals(getLanguage(), course.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getActiveStatus(), getLanguage());
    }
}
