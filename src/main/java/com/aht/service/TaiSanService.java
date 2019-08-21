package com.aht.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aht.entities.TaiSan;

public interface TaiSanService {
	public TaiSan sumTaiSan();

	public TaiSan createTaiSan(TaiSan ts);

	public TaiSan updateTaiSan(TaiSan ts);

	public boolean deleteTaiSan(long id);

	public TaiSan getTaiSanById(long id);

	public List<TaiSan> getAllTaiSan();

	public TaiSan findByTentaisan(String tentaisan);

	Page<TaiSan> findAll(Pageable pageable);
}
