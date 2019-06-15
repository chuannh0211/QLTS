package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.Nhom;
import com.aht.repository.NhomRepository;
import com.aht.service.NhomService;

@Service
public class NhomServiceImpl implements NhomService {
	@Autowired
	private NhomRepository repository;

	@Override
	public Nhom createNhom(Nhom nhom) {
		// TODO Auto-generated method stub
		return repository.save(nhom);
	}

	@Override
	public Nhom updateNhom(Nhom nhom) {
		// TODO Auto-generated method stub
		Nhom newNhom = repository.findById(nhom.getId()).get();
		newNhom.setName(nhom.getName());
		newNhom.setPm(nhom.getPm());

		return repository.save(newNhom);
	}

	@Override
	public boolean deleteNhom(long id) {
		// TODO Auto-generated method stub
		repository.delete(repository.findById(id).get());
		return true;
	}

	@Override
	public Nhom getNhomById(long id) {
		// TODO Auto-generated method stub
		Optional<Nhom> nhoms = repository.findById(id);
		if (nhoms.isPresent())
			return nhoms.get();
		return null;
	}

	@Override
	public List<Nhom> getAllNhom() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
