package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aht.entities.DanhMuc;
import com.aht.repository.DanhMucRepository;
import com.aht.service.DanhMucService;

@Service
public class DanhMucServiceImpl implements DanhMucService {
	@Autowired
	private DanhMucRepository dmRepository;

	@Override
	public DanhMuc createDanhMuc(DanhMuc dm) {
		// TODO Auto-generated method stub
		return dmRepository.save(dm);
	}

	@Override
	public DanhMuc updateDanhMuc(DanhMuc dm) {
		// TODO Auto-generated method stub
		DanhMuc newDm = dmRepository.findById(dm.getId()).get();
		newDm.setName(dm.getName());
		return dmRepository.save(dm);
	}

	@Override
	public boolean deleteDanhMuc(long id) {
		// TODO Auto-generated method stub
		dmRepository.delete(dmRepository.findById(id).get());
		return true;
	}

	@Override
	public DanhMuc getDanhMucById(long id) {
		// TODO Auto-generated method stub
		Optional<DanhMuc> dm = dmRepository.findById(id);
		if (dm.isPresent())
			return dm.get();
		return null;
	}

	@Override
	public List<DanhMuc> dmList() {
		// TODO Auto-generated method stub
		return dmRepository.dmList();
	}

	@Override
	public Page<DanhMuc> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return dmRepository.findAll(pageable);
	}

}
