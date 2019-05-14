package com.aht.service;

import java.util.List;

import com.aht.entities.TaiSan;

public interface TaiSanService {
	public TaiSan createTaiSan(TaiSan ts);

	public TaiSan updateTaiSan(TaiSan ts);

	public boolean deleteTaiSan(long id);

	public TaiSan getTaiSanById(long id);

	public List<TaiSan> getAllTaiSan();
	
}
