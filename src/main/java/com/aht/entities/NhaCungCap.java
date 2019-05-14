package com.aht.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tencongty")
	private String tencongty;
	@Column(name = "tentat")
	private String tentat;
	@Column(name = "diachi")
	private String diachi;
	@Column(name = "sodienthoai")
	private String dienthoai;
	@Column(name = "email")
	private String email;
	@Column(name = "masothue")
	private String masothue;
	@Column(name = "nguoidaidien")
	private String nguoidaidien;
	@Column(name = "Company")
	private String company;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhacungcap",cascade=CascadeType.REMOVE)
	private Set<TaiSan> listTaiSan = new HashSet<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTencongty() {
		return tencongty;
	}
	public void setTencongty(String tencongty) {
		this.tencongty = tencongty;
	}
	public String getTentat() {
		return tentat;
	}
	public void setTentat(String tentat) {
		this.tentat = tentat;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMasothue() {
		return masothue;
	}
	public void setMasothue(String masothue) {
		this.masothue = masothue;
	}
	public String getNguoidaidien() {
		return nguoidaidien;
	}
	public void setNguoidaidien(String nguoidaidien) {
		this.nguoidaidien = nguoidaidien;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Set<TaiSan> getListTaiSan() {
		return listTaiSan;
	}
	public void setListTaiSan(Set<TaiSan> listTaiSan) {
		this.listTaiSan = listTaiSan;
	}

	

}
