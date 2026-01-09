package com.example.getcash.GetCashApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.getcash.GetCashApi.DaoService.UserService;

@Service
public class CostumeUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean flag = userService.userEmailValidation(username);
		if (flag) {
			return new User(username, username, new ArrayList<>());
		} else
			return (UserDetails) new UsernameNotFoundException("User not found ");

	}

}
