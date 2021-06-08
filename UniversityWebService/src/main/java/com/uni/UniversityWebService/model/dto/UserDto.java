package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.User;

public class UserDto {

    private long id;
    private String username;
    private Role role;

    public UserDto(User user){
        this.id = user.getId();
        this.username = user.getUserName();
        this.role = user.getRole();
    }
    
    public User convertUserDtoToUser(User user) {
    	user.setId(this.getId());
    	user.setUserName(this.getUsername());
    	return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
