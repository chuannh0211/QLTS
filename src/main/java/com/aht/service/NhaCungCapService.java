package com.aht.service;

import java.util.List;

import com.aht.entities.NhaCungCap;

public interface NhaCungCapService {
	public NhaCungCap createNcc(NhaCungCap ncc);

	public NhaCungCap updateNcc(NhaCungCap ncc);

	public boolean deleteNcc(long id);

	public NhaCungCap getNccById(long id);

	public List<NhaCungCap> getAllNcc();
}
