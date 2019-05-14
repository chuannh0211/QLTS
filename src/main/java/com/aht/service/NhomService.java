package com.aht.service;

import java.util.List;

import com.aht.entities.Nhom;

public interface NhomService {
	public Nhom createNhom(Nhom nhom);

	public Nhom updateNhom(Nhom nhom);

	public boolean deleteNhom(long id);

	public Nhom getNhomById(long id);

	public List<Nhom> getAllNhom();
}
