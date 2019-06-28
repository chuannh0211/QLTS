package com.aht.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aht.entities.Users;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query("")
	Users findByUsername(String username);

	@Query("from Users")
	List<Users> usersList();
}
