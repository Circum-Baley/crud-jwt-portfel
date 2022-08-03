package com.cirbal.portfel.services;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cirbal.portfel.model.User;
import com.cirbal.portfel.repositories.UserRepository;


//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//import com.cirbal.portfel.model.UserDAO;
//import com.cirbal.portfel.model.UserDTO;
//import com.cirbal.portfel.repositories.UserRepository;
//
//
@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);
	}

}
//	@Autowired
//	private UserRepository userRepository;
//
//	
////	@Autowired
////	private PasswordEncoder bcryptEncoder;
//	
//	@Bean
//	public PasswordEncoder bcryptEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDAO user = userRepository.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}
//	
//	public UserDAO save(UserDTO user) {
//		UserDAO newUser = new UserDAO();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder().encode(user.getPassword()));
//		return userRepository.save(newUser);
//	}
//}