package com.uni.UniversityWebService.model;

import javax.persistence.*;

@Entity
@Table(name = "teachingType")
public class TeachingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public TeachingType(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public TeachingType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
