package com.uni.UniversityWebService.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Teacher")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="User_id", referencedColumnName = "id")
    private User  user;

    @OneToMany(
            mappedBy = "id",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Teaching> teachings;


    public Teacher(Long id,String firstName,String lastName,List<Teaching> teachings){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.teachings= teachings;
    }

    public Teacher(String firstName,String lastName,List<Teaching> teachings){
        this.firstName=firstName;
        this.lastName=lastName;
        this.teachings= teachings;
    }

    public Teacher(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Teaching> getTeachings() {
        return teachings;
    }

    public void setTeachings(List<Teaching> teachings) {
        this.teachings = teachings;
    }
}
