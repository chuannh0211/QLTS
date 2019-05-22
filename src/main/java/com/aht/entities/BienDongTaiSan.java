package com.aht.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "biendongtaisan")
public class BienDongTaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "ngaybiendong")
	private String ngaybiendong;
	@Column(name = "nguoighi")
	private String nguoighi;
//	@Column(name = "taisanchinh")
//	private String taisanchinh;
	@Column(name = "taisanbiendong")
	private String taisanbiendong;
	@Column(name = "trangthai")
	private String trangthai;
	@Column(name = "giatribiendong")
	private String giatribiendong;
	@Column(name = "thoigianbaohanh")
	private String thoigianbaohanh;
	@Column(name = "nhacungcap")
	private String nhacungcap;
	@Column(name = "sohoadon")
	private String sohoadon;
	@Column(name = "ghichu")
	private String ghichu;
	@ManyToOne
	@JoinColumn(name = "mataisan", nullable = false)
	private TaiSan taisan;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNgaybiendong() {
		return ngaybiendong;
	}

	public void setNgaybiendong(String ngaybiendong) {
		this.ngaybiendong = ngaybiendong;
	}

	public String getNguoighi() {
		return nguoighi;
	}

	public void setNguoighi(String nguoighi) {
		this.nguoighi = nguoighi;
	}

//	public String getTaisanchinh() {
//		return taisanchinh;
//	}
//
//	public void setTaisanchinh(String taisanchinh) {
//		this.taisanchinh = taisanchinh;
//	}

	public String getTaisanbiendong() {
		return taisanbiendong;
	}

	public void setTaisanbiendong(String taisanbiendong) {
		this.taisanbiendong = taisanbiendong;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public String getGiatribiendong() {
		return giatribiendong;
	}

	public void setGiatribiendong(String giatribiendong) {
		this.giatribiendong = giatribiendong;
	}

	public String getThoigianbaohanh() {
		return thoigianbaohanh;
	}

	public void setThoigianbaohanh(String thoigianbaohanh) {
		this.thoigianbaohanh = thoigianbaohanh;
	}

	public String getNhacungcap() {
		return nhacungcap;
	}

	public void setNhacungcap(String nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	public String getSohoadon() {
		return sohoadon;
	}

	public void setSohoadon(String sohoadon) {
		this.sohoadon = sohoadon;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public TaiSan getTaisan() {
		return taisan;
	}

	public void setTaisan(TaiSan taisan) {
		this.taisan = taisan;
	}

	public String getNcc() {
		return taisan.getNameNcc();
	}

	public String getTentaisan() {
		return taisan.getTentaisan();
	}

	public long getIdTs(long id) {
		return taisan.getId();
	}
}
