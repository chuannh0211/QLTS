package com.aht.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "taisan")
public class TaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tentaisan")
	private String tentaisan;
	@Column(name = "dacdiem")
	private String dacdiem;
	@Column(name = "trangthai")
	private String trangthai;
	@Column(name = "giatrithuc")
	private String giatrithuc;
//	private long maDM;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taisan")
	private Set<DieuChuyenTaiSan> listDieuchuyentaisan = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "madanhmuc", nullable = false)
	private DanhMuc danhmuc;
	@ManyToOne
	@JoinColumn(name = "manhacungcap", nullable = false)
	private NhaCungCap nhacungcap;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taisan")
	private Set<BienDongTaiSan> listBiendongtaisan = new HashSet<>();

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

	public String getGiatrithuc() {
		return giatrithuc;
	}

	public void setGiatrithuc(String giatrithuc) {
		this.giatrithuc = giatrithuc;
	}

	public Set<DieuChuyenTaiSan> getListDieuchuyentaisan() {
		return listDieuchuyentaisan;
	}

	public void setListDieuchuyentaisan(Set<DieuChuyenTaiSan> listDieuchuyentaisan) {
		this.listDieuchuyentaisan = listDieuchuyentaisan;
	}

	public DanhMuc getDanhmuc() {
		return danhmuc;
	}

	public String getNameDm() {
		return danhmuc.getName();
	}

	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public NhaCungCap getNhacungcap() {
		return nhacungcap;
	}

	public String getNameNcc() {

		return nhacungcap.getTencongty();
	}

	public void setNhacungcap(NhaCungCap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

//	public long getMaDM() {
//		return maDM = danhmuc.getId();
//	}

	public Set<BienDongTaiSan> getListBiendongtaisan() {
		return listBiendongtaisan;
	}

	public void setListBiendongtaisan(Set<BienDongTaiSan> listBiendongtaisan) {
		this.listBiendongtaisan = listBiendongtaisan;
	}

	@Override
	public String toString() {
		return "TaiSan [id=" + id + ", tentaisan=" + tentaisan + ", dacdiem=" + dacdiem + ", trangthai=" + trangthai
				+ ", giatrithuc=" + giatrithuc + ", danhmuc=" + danhmuc + ", nhacungcap=" + nhacungcap + "]";
	}

}
