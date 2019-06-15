package com.aht.service;

import java.util.List;

import com.aht.entities.BienDongTaiSan;

public interface BienDongTaiSanService {
	public BienDongTaiSan createBDTS(BienDongTaiSan bdts);

	public BienDongTaiSan updateBDTS(BienDongTaiSan bdts);

	public boolean deleteBDTS(long id);

	public BienDongTaiSan getBDTSById(long id);

	public List<BienDongTaiSan> getAllBienDongTaiSan();

}
