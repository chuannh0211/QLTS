package com.aht.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Roles;

@Repository
@Transactional
public interface RolesRepository extends JpaRepository<Roles, Long> {
	public Roles findByName(String name);
}
