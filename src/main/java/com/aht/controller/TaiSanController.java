package com.aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entities.DanhMuc;
import com.aht.entities.NhaCungCap;
import com.aht.entities.Nhom;
import com.aht.entities.TaiSan;
import com.aht.serviceImpl.DanhMucServiceImpl;
import com.aht.serviceImpl.NhomServiceImpl;
import com.aht.serviceImpl.SuppliersServiceImpl;
import com.aht.serviceImpl.TaiSanServiceImpl;

@Controller
public class TaiSanController {
	@Autowired
	private TaiSanServiceImpl tsService;
	@Autowired
	private DanhMucServiceImpl dmService;
	@Autowired
	private SuppliersServiceImpl sService;
	@Autowired
	private NhomServiceImpl nService;
	@RequestMapping(value = { "/dsts" }, method = RequestMethod.GET)
	public String getAllAsset(Model model) {
		List<TaiSan> listTs = tsService.getAllTaiSan();
		List<DanhMuc> listDm = dmService.getAllDanhMuc();
		List<NhaCungCap> listNcc = sService.getAllNcc();
		model.addAttribute("lsTs", listTs);
		/* tạo list để lấy danh mục + nhà cung cấp cho phần add + edit */
		model.addAttribute("lsDm", listDm);
		model.addAttribute("lsNcc", listNcc);
//		System.out.println("list size " + listDm.size());
//		for(DanhMuc a : listDm ) {
//			System.out.println("--- "+ a.getName() );
//		}
//		System.out.println("--- "+ listDm );
		return "listasset";
	}

	@RequestMapping(value = "/add-ts")
	public String addAsset(@RequestParam("tentaisan") String tentaisan, @RequestParam("dacdiem") String dacdiem,
			@RequestParam("trangthai") String trangthai, @RequestParam("giatrithuc") String giatrithuc,
			@RequestParam("danhmuc") long dm, @RequestParam("nhacungcap") long ncc) {
		TaiSan newTs = new TaiSan();
		DanhMuc newDm = new DanhMuc();
		NhaCungCap newNcc = new NhaCungCap();
		newDm.setId(dm);
		newNcc.setId(ncc);
		// DanhMuc newDm1 = newDm;
		newTs.setTentaisan(tentaisan);
		newTs.setDacdiem(dacdiem);
		newTs.setGiatrithuc(giatrithuc);
		newTs.setTrangthai(trangthai);
		newTs.setDanhmuc(newDm);
		newTs.setNhacungcap(newNcc);
		tsService.createTaiSan(newTs);
//		System.out.println("----- " + newTs);
//		System.out.println("-----:: " + dm);
		return "redirect:/dsts";
	}

	@RequestMapping(value = { "/edit-ts/{id}" }, method = RequestMethod.GET)
	public String editAsset(@PathVariable("id") int id, Model model) {
		List<DanhMuc> listDm = dmService.getAllDanhMuc();
		List<NhaCungCap> listNcc = sService.getAllNcc();
		model.addAttribute("lsDm", listDm);
		model.addAttribute("lsNcc", listNcc);
		model.addAttribute("ts", tsService.getTaiSanById(id));
		TaiSan ls = tsService.getTaiSanById(id);
		model.addAttribute("newDm", ls.getDanhmuc().getId());
		//
		model.addAttribute("newNcc", ls.getNhacungcap().getId());

		System.out.println("lts: " + ls.getDanhmuc().getId());
		System.out.println("lts: " + ls.getNhacungcap().getId());
		return "editdsts";
	}

	@RequestMapping(value = { "/edit-ts" }, method = RequestMethod.POST)
	public String editAsset(@ModelAttribute("ts") TaiSan ts, @RequestParam("danhmuc") long dm) {

		tsService.updateTaiSan(ts);
		return "redirect:/dsts";
	}

	@RequestMapping(value = "/delete-ts/{id}")
	public String deleteAsset(@PathVariable("id") int id) {
		tsService.deleteTaiSan(id);
		return "redirect:/dsts";
	}

	@RequestMapping(value = "/dcts")
	public String dieuchuyentaisan(Model model) {
		List<DanhMuc> listDm = dmService.getAllDanhMuc();
		model.addAttribute("lsDm", listDm);
		List<TaiSan> listTs = tsService.getAllTaiSan();
		model.addAttribute("lsTs", listTs);
		List<Nhom> listN = nService.getAllNhom();
		model.addAttribute("lsN", listN);
		return "dieuchuyentaisan";
	}
}

//	@RequestMapping(value = "add-taisan", method = RequestMethod.GET)
//	public String addTaiSan() {
//
//		return "taisan/addTaiSan";
//	}
//
//	@RequestMapping(value = "add-taisan", method = RequestMethod.POST)
//	public String addTaiSan(@RequestParam("tentaisan") String tentaisan, @RequestParam("dacdiem") String dacdiem,
//			@RequestParam("trangthai") String trangthai, @RequestParam("giatrithuc") String giatrithuc) {
//		TaiSan newTs = new TaiSan();
//		newTs.setTentaisan(tentaisan);
//		newTs.setDacdiem(dacdiem);
//		newTs.setTrangthai(trangthai);
//		newTs.setGiatrithuc(giatrithuc);
//		tsService.createTaiSan(newTs);
//		return "redirect:/list-taisan";
//	}
//
//	@RequestMapping(value = "list-taisan")
//	public String getAllTaiSan(Model model) {
//		List<TaiSan> ls = tsService.getAllTaiSan();
//		model.addAttribute("list", ls);
//		return "taisan/listTaiSan";
//	}
//
//	@RequestMapping(value = "delete-taisan/{id}")
//	public String deleteTaiSan(@PathVariable("id") int id) {
//		tsService.deleteTaiSan(id);
//		return "redirect:/list-taisan";
//	}
