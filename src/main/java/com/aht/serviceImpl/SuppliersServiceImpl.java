package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.NhaCungCap;
import com.aht.repository.NhaCungCapRepository;
import com.aht.service.NhaCungCapService;

@Service
public class SuppliersServiceImpl implements NhaCungCapService {
	@Autowired
	private NhaCungCapRepository repository;

	@Override
	public NhaCungCap createNcc(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return repository.save(ncc);
	}

	@Override
	public NhaCungCap updateNcc(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		NhaCungCap newNcc = repository.findById(ncc.getId()).get();
		newNcc.setTencongty(ncc.getTencongty());
		newNcc.setTentat(ncc.getTentat());
		newNcc.setDiachi(ncc.getDiachi());
		newNcc.setDienthoai(ncc.getDienthoai());
		newNcc.setEmail(ncc.getEmail());
		newNcc.setMasothue(ncc.getMasothue());
		newNcc.setNguoidaidien(ncc.getNguoidaidien());
		newNcc.setCompany(ncc.getCompany());
		return repository.save(newNcc);
	}

	@Override
	public boolean deleteNcc(long id) {
		// TODO Auto-generated method stub
		repository.delete(repository.findById(id).get());
		return true;
	}

	@Override
	public NhaCungCap getNccById(long id) {
		// TODO Auto-generated method stub
		Optional<NhaCungCap> ncc = repository.findById(id);
		if (ncc.isPresent())
			return ncc.get();
		return null;
	}

	@Override
	public List<NhaCungCap> getAllNcc() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
