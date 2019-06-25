package com.aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entities.BienDongTaiSan;
import com.aht.entities.DieuChuyenTaiSan;
import com.aht.entities.NhaCungCap;
import com.aht.entities.TaiSan;
import com.aht.serviceImpl.BienDongTaiSanServiceImpl;
import com.aht.serviceImpl.SuppliersServiceImpl;
import com.aht.serviceImpl.TaiSanServiceImpl;

import javassist.expr.NewArray;

@Controller
public class BdtsController {
	@Autowired
	private TaiSanServiceImpl tsService;
	@Autowired
	private SuppliersServiceImpl sService;
	@Autowired
	private BienDongTaiSanServiceImpl bdtsService;
	@Autowired
	private Environment env;
	static String status1, status2, status3, status4, status5;

	@RequestMapping(value = "/form-bdts/{idBdts}")
	public String formBdts(Model model, @PathVariable("idBdts") int idBdts) {
		TaiSan nTs = tsService.getTaiSanById(idBdts);
		model.addAttribute("nTs", nTs);
		List<NhaCungCap> ltsNcc = sService.getAllNcc();
		model.addAttribute("ltsNcc", ltsNcc);
		
		return "form-bdts";
	}

	@RequestMapping(value = { "/add-bdts/{id}" }, method = RequestMethod.POST)
	public String addBdts(@RequestParam("ngaybiendong") String ngaybiendong, @RequestParam("nguoighi") String nguoighi,
			@RequestParam("taisanchinh") TaiSan taisanchinh, @RequestParam("taisanbiendong") String taisanbiendong,
			@RequestParam("trangthai") String trangthai, @RequestParam("giatribiendong") String giatribiendong,
			@RequestParam("baohanh") String baohanh, @RequestParam("nhacungcap") String nhacungcap,
			@RequestParam("hoadon") String hoadon, @RequestParam("ghichu") String ghichu,@RequestParam(value = "id") int id,Model model) {
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
		System.out.println("trang thai: " + trangthai);
		BienDongTaiSan idBdts = bdtsService.getBDTSById(id);
		model.addAttribute("idBdts", idBdts);
		return "redirect:/view-details/{id}";
	}

	@RequestMapping(value = { "view-details/xoa-bdts" })
	public String deleteDcts(@RequestParam(value = "id") int id, @RequestParam(value = "idts") int idts) {
		bdtsService.deleteBDTS(id);
		return "redirect:/view-details/" + idts;
	}

//	@RequestMapping(value = "view-details/form-sua-bdts/{id}", method = RequestMethod.GET)
//	public String editBdts(@PathVariable("id") int pathid, Model model) {
//		BienDongTaiSan nBdts = bdtsService.getBDTSById(pathid);
//		System.out.println("============");
//		System.out.println("Check id url: "+ nBdts.getId());
//		System.out.println("Check id mataisan: " + nBdts.getIdTs(pathid));
//		System.out.println("============");
//		model.addAttribute("nBdts", nBdts);
//		/* giá trị của modelAttribute bên view */
//		model.addAttribute("bdts", bdtsService.getBDTSById(pathid));
//		model.addAttribute("id_ts", nBdts.getIdTs(pathid));
//		
//		System.out.println("id ts-get : " + nBdts.getIdTs(pathid) + " -- " + nBdts.getTaisan().getId());
//
//		return "editBiendongtaisan";
//	}

	@RequestMapping(value = "view-details/form-sua-bdts/{id}", method = RequestMethod.GET)
	public String editBdtsPopup(@PathVariable("id") int pathid, Model model) {
		BienDongTaiSan nBdts = bdtsService.getBDTSById(pathid);
		System.out.println("============");
		System.out.println("Check id url: " + nBdts.getId());
		System.out.println("Check id mataisan: " + nBdts.getIdTs(pathid));
		System.out.println("============");
		model.addAttribute("nBdts", nBdts);
		/* giá trị của modelAttribute bên view */
		model.addAttribute("bdts", bdtsService.getBDTSById(pathid));
		model.addAttribute("id_ts", nBdts.getIdTs(pathid));

		System.out.println("id ts-get : " + nBdts.getIdTs(pathid) + " -- " + nBdts.getTaisan().getId());

		return "editBdtsPopup";
	}

	@RequestMapping(value = "/view-details/form-sua-bdts/{id}", method = RequestMethod.POST)
	public String editBdts(@ModelAttribute("bdts") BienDongTaiSan bdts, @RequestParam("id_bdts") int idBdts) {
		System.out.println("start update");
		System.out.println("check id: " + idBdts);
		BienDongTaiSan nBdts = bdtsService.getBDTSById(idBdts);
		System.out.println("check newBdts:" + nBdts);
		TaiSan nTs = new TaiSan();
		System.out.println("check new Ts: " + nTs);

		nTs.setId(nBdts.getIdTs(idBdts));
		System.out.println("check new Ts: " + nTs.getId());
		bdts.setTaisan(nTs);
		//
		System.out.println("id-ts-post: " + nBdts.getIdTs(idBdts));
		bdtsService.updateBDTS(bdts);
		return "redirect:/view-details/{id}";
	}

}
