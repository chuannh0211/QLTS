package com.aht.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

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
	@Value("${value.trangthaiT},${value.trangthaiH},${value.trangthaiTL}")
	@Column(name = "trangthai")
	private String trangthai;
	@Column(name = "giatrithuc")
	private String giatrithuc;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "taisan", cascade = CascadeType.REMOVE)
	private Set<DieuChuyenTaiSan> listDieuchuyentaisan = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "madanhmuc", nullable = false)
	private DanhMuc danhmuc;
	@ManyToOne
	@JoinColumn(name = "manhacungcap", nullable = false)
	private NhaCungCap nhacungcap;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "taisan", cascade = { CascadeType.REMOVE})
	private Set<BienDongTaiSan> listBiendongtaisan = new HashSet<>();

	public TaiSan() {
		// TODO Auto-generated constructor stub
	}

	public TaiSan(long id, String tentaisan, String dacdiem, String trangthai, String giatrithuc,
			Set<DieuChuyenTaiSan> listDieuchuyentaisan, DanhMuc danhmuc, NhaCungCap nhacungcap,
			Set<BienDongTaiSan> listBiendongtaisan) {
		this.id = id;
		this.tentaisan = tentaisan;
		this.dacdiem = dacdiem;
		this.trangthai = trangthai;
		this.giatrithuc = giatrithuc;
		this.listDieuchuyentaisan = listDieuchuyentaisan;
		this.danhmuc = danhmuc;
		this.nhacungcap = nhacungcap;
		this.listBiendongtaisan = listBiendongtaisan;
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

	public LocalDate getDate() {
		LocalDate localDate = LocalDate.now();
		return localDate;
	}

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
