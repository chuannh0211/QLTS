package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.Roles;
import com.aht.repository.RolesRepository;
import com.aht.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	private RolesRepository repository;

	@Override
	public Roles createRoles(Roles role) {
		// TODO Auto-generated method stub
		return repository.save(role);
	}

	@Override
	public Roles updateRoles(Roles role) {
		// TODO Auto-generated method stub
		Roles newRole = repository.findById(role.getId()).get();
		newRole.setName(role.getName());
		return repository.save(newRole);
	}

	@Override
	public boolean deleteRoles(long id) {
		// TODO Auto-generated method stubre
		repository.delete(repository.findById(id).get());
		return true;
	}

	@Override
	public Roles getRolesById(long id) {
		// TODO Auto-generated method stub
		Optional<Roles> roles = repository.findById(id);
		if (roles.isPresent())
			return roles.get();
		return null;
	}

	@Override
	public List<Roles> getAllRoles() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
