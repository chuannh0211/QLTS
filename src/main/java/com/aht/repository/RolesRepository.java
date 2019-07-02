package com.aht.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aht.entities.Roles;

@Repository
@Transactional
public interface RolesRepository extends JpaRepository<Roles, Long> {
	@Query("SELECT r FROM Roles r WHERE r.name = 'ROLE_USER'")
	public Set<Roles> findByName(String name);
}
