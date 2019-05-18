package com.aht.service;

import java.util.List;

import com.aht.entities.DieuChuyenTaiSan;

public interface DieuChuyenTaiSanService {
	public DieuChuyenTaiSan createDCTS(DieuChuyenTaiSan dcts);

	public DieuChuyenTaiSan updateDCTS(DieuChuyenTaiSan dcts);

	public boolean deleteDCTS(long id);

	public DieuChuyenTaiSan getDCTSById(long id);

	public List<DieuChuyenTaiSan> getAllDCTS();
	
	//public DieuChuyenTaiSan findByTentaisan(String tentaisan);
}
