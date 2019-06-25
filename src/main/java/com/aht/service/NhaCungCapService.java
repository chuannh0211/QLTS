package com.aht.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aht.entities.NhaCungCap;

public interface NhaCungCapService {
	public NhaCungCap createNcc(NhaCungCap ncc);

	public NhaCungCap updateNcc(NhaCungCap ncc);

	public boolean deleteNcc(long id);

	public NhaCungCap getNccById(long id);

	public List<NhaCungCap> getAllNcc();
	
	Page<NhaCungCap> findAll(Pageable pageable);
}
