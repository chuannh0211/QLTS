package com.aht.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Users;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
