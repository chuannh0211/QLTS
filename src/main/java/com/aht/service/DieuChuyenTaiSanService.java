package com.aht.service;

import java.util.List;

import com.aht.entities.DieuChuyenTaiSan;

public interface DieuChuyenTaiSanService {
	public DieuChuyenTaiSan createDCTS(DieuChuyenTaiSan dcts);

	public DieuChuyenTaiSan updateDCTS(DieuChuyenTaiSan dcts);

	public boolean deleteDCTS(Long id);

	public DieuChuyenTaiSan getDCTSById(Long id);

	public List<DieuChuyenTaiSan> getAllDCTS();
}
