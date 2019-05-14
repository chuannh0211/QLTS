package com.aht.service;

import java.util.List;

import com.aht.entities.DanhMuc;

public interface DanhMucService {
	public DanhMuc createDanhMuc(DanhMuc dm);

	public DanhMuc updateDanhMuc(DanhMuc dm);

	public boolean deleteDanhMuc(long id);

	public DanhMuc getDanhMucById(long id);

	public List<DanhMuc> getAllDanhMuc();
}
