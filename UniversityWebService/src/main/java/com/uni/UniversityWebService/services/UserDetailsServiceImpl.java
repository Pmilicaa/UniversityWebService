package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.User;
import com.uni.UniversityWebService.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);

	    if (user == null) {
	      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	    } else {
	    	List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	    	grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

	    	UserDetails userDetails = new org.springframework.security.core.userdetails.User(
					user.getUserName(),
					user.getPassword(),
					grantedAuthorities);

	    	return userDetails;
	    }
	}
	
	

}
