package com.aht.model;

public class TaiSanDTO {
	private long id;
	private String tentaisan;
	private String dacdiem;
	private String trangthai;

	public TaiSanDTO() {
		// TODO Auto-generated constructor stub
	}

	public TaiSanDTO(long id, String tentaisan, String dacdiem, String trangthai) {
		this.id = id;
		this.tentaisan = tentaisan;
		this.dacdiem = dacdiem;
		this.trangthai = trangthai;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTentaisan() {
		return tentaisan;
	}

	public void setTentaisan(String tentaisan) {
		this.tentaisan = tentaisan;
	}

	public String getDacdiem() {
		return dacdiem;
	}

	public void setDacdiem(String dacdiem) {
		this.dacdiem = dacdiem;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

}
