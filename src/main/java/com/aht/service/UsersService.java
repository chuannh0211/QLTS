package com.aht.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aht.entities.Users;

public interface UsersService {
	public Users createUser(Users user);

	public Users updateUser(Users user);

	public boolean deleteUser(long id);

	public Users getUserById(long id);

	public List<Users> getAllUsers();

	public Users findByUsername(String username);

	Page<Users> findAll(Pageable pageable);

}
