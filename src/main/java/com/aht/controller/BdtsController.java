package com.aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entities.BienDongTaiSan;
import com.aht.entities.NhaCungCap;
import com.aht.entities.TaiSan;
import com.aht.serviceImpl.BienDongTaiSanServiceImpl;
import com.aht.serviceImpl.SuppliersServiceImpl;
import com.aht.serviceImpl.TaiSanServiceImpl;

@Controller
public class BdtsController {
	@Autowired
	private TaiSanServiceImpl tsService;
	@Autowired
	private SuppliersServiceImpl sService;
	@Autowired
	private BienDongTaiSanServiceImpl bdtsService;

	@RequestMapping(value = "/form-bdts/{idBdts}")
	public String formBdts(Model model, @PathVariable("idBdts") int idBdts) {
		TaiSan nTs = tsService.getTaiSanById(idBdts);
		model.addAttribute("nTs", nTs);
		List<NhaCungCap> ltsNcc = sService.getAllNcc();
		model.addAttribute("ltsNcc", ltsNcc);
		return "form-bdts";
	}

	@RequestMapping(value = { "/add-bdts/{id}" }, method = RequestMethod.POST)
	public String addDcts(@RequestParam("ngaybiendong") String ngaybiendong,
			@RequestParam("nguoighi") String nguoighi, @RequestParam("taisanchinh") TaiSan taisanchinh,
			@RequestParam("taisanbiendong") String taisanbiendong, @RequestParam("trangthai") String trangthai,
			@RequestParam("giatribiendong") String giatribiendong, @RequestParam("baohanh") String baohanh,
			@RequestParam("nhacungcap") String nhacungcap, @RequestParam("hoadon") String hoadon,
			@RequestParam("ghichu") String ghichu) {
		BienDongTaiSan newBdts = new BienDongTaiSan();
		newBdts.setNgaybiendong(ngaybiendong);
		newBdts.setNguoighi(nguoighi);
		newBdts.setNhacungcap(nhacungcap);
		newBdts.setTaisan(taisanchinh);
		newBdts.setTaisanbiendong(taisanbiendong);
		newBdts.setTrangthai(trangthai);
		newBdts.setGiatribiendong(giatribiendong);
		newBdts.setThoigianbaohanh(baohanh);
		newBdts.setSohoadon(hoadon);
		newBdts.setGhichu(ghichu);
		bdtsService.createBDTS(newBdts);
		return "redirect:/view-details/{id}";
	}
	@RequestMapping(value = { "view-details/xoa-bdts" })
	public String deleteDcts(@RequestParam(value = "id") int id, @RequestParam(value = "idts") int idts) {
		bdtsService.deleteBDTS(id);
		return "redirect:/view-details/" + idts;
	}
}
