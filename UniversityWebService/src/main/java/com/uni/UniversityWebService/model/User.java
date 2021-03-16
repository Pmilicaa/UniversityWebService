package com.uni.UniversityWebService.model;



import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private RoleEnum roleEnum;


    public User(Long id,String userName,String password){

        this.id=id;
        this.userName=userName;
        this.password=password;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.userName = password;
    }
}