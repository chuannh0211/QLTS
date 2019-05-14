package com.aht.model;

public class NhaCungCapDTO {
	private long id;
	private String tencongty;
	private String tentat;
	private String diachi;
	private String dienthoai;
	private String email;
	private String masothue;
	private String nguoidaidien;
	private String company;

	public NhaCungCapDTO() {
		// TODO Auto-generated constructor stub
	}

	public NhaCungCapDTO(long id, String tencongty, String tentat, String diachi, String dienthoai, String email,
			String masothue, String nguoidaidien, String company) {
		this.id = id;
		this.tencongty = tencongty;
		this.tentat = tentat;
		this.diachi = diachi;
		this.dienthoai = dienthoai;
		this.email = email;
		this.masothue = masothue;
		this.nguoidaidien = nguoidaidien;
		this.company = company;
	}

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

}
