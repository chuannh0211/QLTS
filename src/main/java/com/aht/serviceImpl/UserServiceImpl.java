package com.aht.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aht.entities.Roles;
import com.aht.entities.Users;
import com.aht.repository.RolesRepository;
import com.aht.repository.UsersRepository;
import com.aht.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {
	@Autowired
	private UsersRepository uRepository;
	@Autowired
	private RolesRepository rRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users createUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
//		user.setRoles(new HashSet<Roles>(rRepository.findAll()));
		user.setRoles(rRepository.findByName("USER"));
		return uRepository.save(user);

	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		Users newU = uRepository.findById(user.getId()).get();
		newU.setFullname(user.getFullname());
		newU.setUsername(user.getUsername());
		newU.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		newU.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		newU.setEmail(user.getEmail());
		newU.setPhone(user.getPhone());
		return uRepository.save(newU);
	}

	@Override
	public boolean deleteUser(long id) {
		// TODO Auto-generated method stub
		uRepository.delete(uRepository.findById(id).get());
		// uRepository.delete(uRepository.findByUsername(username));
		return true;
	}

	@Override
	public Users getUserById(long id) {
		// TODO Auto-generated method stub
		Optional<Users> user = uRepository.findById(id);
		if (user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return uRepository.usersList();
	}

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return uRepository.findByUsername(username);
	}

	@Override
	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return uRepository.findAll(pageable);
	}

}
