package com.aht.service;

import java.util.List;

import com.aht.entities.BienDongTaiSan;

public interface BienDongTaiSanService {
	public BienDongTaiSan createBDTS(BienDongTaiSan bdts);

	public BienDongTaiSan updateBDTS(BienDongTaiSan bdts);

	public boolean deleteBDTS(Long id);

	public BienDongTaiSan getBDTSById(Long id);

	public List<BienDongTaiSan> getAllBienDongTaiSan();
}
