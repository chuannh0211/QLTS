package com.aht.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entities.DanhMuc;
import com.aht.entities.DieuChuyenTaiSan;
import com.aht.entities.NhaCungCap;
import com.aht.entities.TaiSan;
import com.aht.serviceImpl.DanhMucServiceImpl;
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
		model.addAttribute("lsDm", dmService.getAllDanhMuc());
		model.addAttribute("lsNcc", sService.getAllNcc());
		model.addAttribute("ts", tsService.getTaiSanById(id));
		TaiSan ls = tsService.getTaiSanById(id);
		model.addAttribute("newDm", ls.getDanhmuc().getId());
		//
		model.addAttribute("newNcc", ls.getNhacungcap().getId());
//		System.out.println("lts: " + ls.getDanhmuc().getId());
//		System.out.println("lts: " + ls.getNhacungcap().getId());
		return "editdsts";
	}

	@RequestMapping(value = { "/edit-ts" }, method = RequestMethod.POST)
	public String editAsset(@ModelAttribute("ts") TaiSan ts) {
		tsService.updateTaiSan(ts);
		return "redirect:/dsts";
	}

	@RequestMapping(value = "/delete-ts/{id}")
	public String deleteAsset(@PathVariable("id") int id) {
		tsService.deleteTaiSan(id);
		return "redirect:/dsts";
	}

	@RequestMapping(value = { "view-details/{id}" })
	public String viewDetails(@PathVariable("id") long id, Model model) {
		TaiSan newTs = tsService.getTaiSanById(id);
		model.addAttribute("ts", newTs);
		Set<DieuChuyenTaiSan> ltsDcts = newTs.getListDieuchuyentaisan();
		model.addAttribute("ltsDcts", ltsDcts);
		System.out.println("==: " + newTs);
		System.out.println("--: " + ltsDcts);
		return "listAssetsDetails";
	}
}
