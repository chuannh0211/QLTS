package com.aht.service;

import java.util.List;

import com.aht.entities.Roles;

public interface RolesService {
	public Roles createRoles(Roles role);

	public Roles updateRoles(Roles role);

	public boolean deleteRoles(long id);

	public Roles getRolesById(long id);

	public List<Roles> getAllRoles();
	
	
}
