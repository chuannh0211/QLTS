package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.DieuChuyenTaiSan;
import com.aht.repository.DieuChuyenTaiSanRepository;
import com.aht.service.DieuChuyenTaiSanService;

@Service
public class DieuChuyenTaiSanServiceImpl implements DieuChuyenTaiSanService {
	@Autowired
	private DieuChuyenTaiSanRepository repository;

	@Override
	public DieuChuyenTaiSan createDCTS(DieuChuyenTaiSan dcts) {
		// TODO Auto-generated method stub
		return repository.save(dcts);
	}

	@Override
	public DieuChuyenTaiSan updateDCTS(DieuChuyenTaiSan dcts) {
		// TODO Auto-generated method stub
		DieuChuyenTaiSan newDCTS = repository.findById(dcts.getId()).get();
		newDCTS.setNgaydieuchuyen(dcts.getNgaydieuchuyen());
		newDCTS.setTentaisan(dcts.getTentaisan());
		newDCTS.setNguoiquanly(dcts.getNguoiquanly());
		newDCTS.setGhichu(dcts.getGhichu());
		return repository.save(newDCTS);
	}

	@Override
	public boolean deleteDCTS(Long id) {
		// TODO Auto-generated method stub
		repository.delete(repository.findById(id).get());
		return true;
	}

	@Override
	public DieuChuyenTaiSan getDCTSById(Long id) {
		// TODO Auto-generated method stub
		Optional<DieuChuyenTaiSan> dcts = repository.findById(id);
		if (dcts.isPresent()) {
			return dcts.get();
		}
		return null;
	}

	@Override
	public List<DieuChuyenTaiSan> getAllDCTS() {
		// TODO Auto-generated method stub

		return repository.findAll();
	}

}
