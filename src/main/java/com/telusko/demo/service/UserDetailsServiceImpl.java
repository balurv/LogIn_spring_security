package com.telusko.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.demo.Repository.UserRepository;
import com.telusko.demo.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return new UserPrincipal(user);
		}
		throw new UsernameNotFoundException(username);
	}

//	private List<GrantedAuthority> getAuthorities(User user) {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		// Add role-based authorities for the user
//		authorities.add(new SimpleGrantedAuthority(user.getRole()));
//		return authorities;
//	}

}
