package com.aht.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "dieuchuyentaisan")
public class DieuChuyenTaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "ngaydieuchuyen")
	private Date ngaydieuchuyen;
	@Column(name = "tentaisan")
	private String tentaisan;
	@Column(name = "nguoiquanly")
	private String nguoiquanly;
	@Column(name = "ghichu")
	private String ghichu;
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

	public Date getNgaydieuchuyen() {
		return ngaydieuchuyen;
	}

	public void setNgaydieuchuyen(Date ngaydieuchuyen) {
		this.ngaydieuchuyen = ngaydieuchuyen;
	}

	public String getTentaisan() {
		return tentaisan;
	}

	public void setTentaisan(String tentaisan) {
		this.tentaisan = tentaisan;
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

}
