package com.aht.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aht.entities.DanhMuc;

public interface DanhMucService {
	public DanhMuc createDanhMuc(DanhMuc dm);

	public DanhMuc updateDanhMuc(DanhMuc dm);

	public boolean deleteDanhMuc(long id);

	public DanhMuc getDanhMucById(long id);

	// public List<DanhMuc> getAllDanhMuc();

	List<DanhMuc> dmList();

	Page<DanhMuc> findAll(Pageable pageable);
	
	boolean writeFileCSV(int id);

//	public List<DanhMuc> findDanhMuc(String property, Object value);
}
