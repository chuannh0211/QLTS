package com.aht.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aht.entities.Roles;
import com.aht.entities.Users;
import com.aht.repository.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsersRepository uRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = uRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Cant find " + username);

		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		for (Roles role : user.getRoles()) {
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new User(user.getUsername(), user.getPassword(), grantedAuthority);
	}

}
