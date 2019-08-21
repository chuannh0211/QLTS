package com.aht.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aht.entities.TaiSan;
import com.aht.repository.TaiSanRepository;
import com.aht.service.TaiSanService;

@Service
public class TaiSanServiceImpl implements TaiSanService {
	@Autowired
	private TaiSanRepository repository;

	@Override
	public TaiSan createTaiSan(TaiSan ts) {
		// TODO Auto-generated method stub
		return repository.save(ts);
	}

	@Override
	public TaiSan updateTaiSan(TaiSan ts) {
		// TODO Auto-generated method stub
		TaiSan newTs = repository.findById(ts.getId()).get();
		newTs.setTentaisan(ts.getTentaisan());
		newTs.setDacdiem(ts.getDacdiem());
		newTs.setTrangthai(ts.getTrangthai());
		newTs.setGiatrithuc(ts.getGiatrithuc());
		newTs.setDanhmuc(ts.getDanhmuc());
		newTs.setNhacungcap(ts.getNhacungcap());
		return repository.save(newTs);
	}

	@Override
	public boolean deleteTaiSan(long id) {
		System.out.println("-" + id);
		System.out.println("--" + repository.findById(id).get());
		repository.delete(repository.findById(id).get());
		return true;

	}

	@Override
	public TaiSan getTaiSanById(long id) {
		// TODO Auto-generated method stub
		Optional<TaiSan> listTs = repository.findById(id);
		if (listTs.isPresent())
			return listTs.get();
		return null;
	}

	@Override
	public List<TaiSan> getAllTaiSan() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public TaiSan findByTentaisan(String tentaisan) {
		// TODO Auto-generated method stub

		return repository.findByTentaisan(tentaisan);
	}

	@Override
	public Page<TaiSan> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public TaiSan sumTaiSan() {
		// TODO Auto-generated method stub
		return null;
	}


}
