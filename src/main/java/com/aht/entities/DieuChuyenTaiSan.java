package com.aht.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dieuchuyentaisan")
public class DieuChuyenTaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "ngaydieuchuyen")
	private String ngaydieuchuyen;
	@Column(name = "nguoiquanly")
	private String nguoiquanly;
	@Column(name = "ghichu")
	private String ghichu;
	//private String tentaisan;
	@ManyToOne
	@JoinColumn(name = "manhom", nullable = false)
	private Nhom nhom;
	@ManyToOne
	@JoinColumn(name = "mataisan", nullable = false)
	private TaiSan taisan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNgaydieuchuyen() {
		return ngaydieuchuyen;
	}

	public void setNgaydieuchuyen(String ngaydieuchuyen) {
		this.ngaydieuchuyen = ngaydieuchuyen;
	}

	public String getNguoiquanly() {
		return nguoiquanly;
	}

	public void setNguoiquanly(String nguoiquanly) {
		this.nguoiquanly = nguoiquanly;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Nhom getNhom() {
		return nhom;
	}

	public void setNhom(Nhom nhom) {
		this.nhom = nhom;
	}

	public TaiSan getTaisan() {
		return taisan;
	}

	public void setTaisan(TaiSan taisan) {
		this.taisan = taisan;
	}

	public long getIdTaiSan(long id) {
		return taisan.getId();
	}
	public String getNameAsset() {
		
		return taisan.getTentaisan();
	}
	public String getGruopAsset() {
		
		return nhom.getName();
	}
}
