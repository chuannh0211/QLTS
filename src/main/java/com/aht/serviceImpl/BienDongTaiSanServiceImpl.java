package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.BienDongTaiSan;
import com.aht.repository.BienDongTaiSanRepository;
import com.aht.service.BienDongTaiSanService;

@Service
public class BienDongTaiSanServiceImpl implements BienDongTaiSanService {
	@Autowired
	private BienDongTaiSanRepository repository;

	@Override
	public BienDongTaiSan createBDTS(BienDongTaiSan bdts) {
		// TODO Auto-generated method stub
		return repository.save(bdts);
	}

	@Override
	public BienDongTaiSan updateBDTS(BienDongTaiSan bdts) {
		// TODO Auto-generated method stub
		BienDongTaiSan newBdts = repository.findById(bdts.getId()).get();
		newBdts.setNgaybiendong(bdts.getNgaybiendong());
		newBdts.setNguoighi(bdts.getNguoighi());
		newBdts.setTaisan(bdts.getTaisan());
		newBdts.setTaisanbiendong(bdts.getTaisanbiendong());
		newBdts.setTrangthai(bdts.getTrangthai());
		newBdts.setGiatribiendong(bdts.getGiatribiendong());
		newBdts.setThoigianbaohanh(bdts.getThoigianbaohanh());
		newBdts.setNhacungcap(bdts.getNhacungcap());
		newBdts.setSohoadon(bdts.getSohoadon());
		newBdts.setGhichu(bdts.getGhichu());
		return repository.save(newBdts);
	}

	@Override
	public boolean deleteBDTS(long id) {
		// TODO Auto-generated method stub
		repository.delete(repository.findById(id).get());
		return true;
	}

	@Override
	public BienDongTaiSan getBDTSById(long id) {
		// TODO Auto-generated method stub
		Optional<BienDongTaiSan> listBDTS = repository.findById(id);
		if (listBDTS.isPresent()) {
			return listBDTS.get();
		}
		return null;
	}

	@Override
	public List<BienDongTaiSan> getAllBienDongTaiSan() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
