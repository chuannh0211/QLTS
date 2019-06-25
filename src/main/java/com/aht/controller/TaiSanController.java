package com.aht.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entities.BienDongTaiSan;
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
	@Autowired
	private Environment env;
	static String status1, status2, status3;

	/* tạo list để lấy danh mục + nhà cung cấp cho phần add + edit */
	@RequestMapping(value = { "/listAsset" }, method = RequestMethod.GET)
	public String getAllAsset(Model model, @RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<TaiSan> pages = tsService.findAll(pageable);
//		List<TaiSan> listTs = tsService.getAllTaiSan();
		List<DanhMuc> listDm = dmService.dmList();
		List<NhaCungCap> listNcc = sService.getAllNcc();
//		model.addAttribute("lsTs", listTs); 
		model.addAttribute("lsTs", pages.getContent());
		model.addAttribute("lsDm", listDm);
		model.addAttribute("lsNcc", listNcc);
		status1 = env.getProperty("trangthaiT");
		status2 = env.getProperty("trangthaiH");
		status3 = env.getProperty("trangthaiTL");
		model.addAttribute("status1", status1);
		model.addAttribute("status2", status2);
		model.addAttribute("status3", status3);
		
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElement", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		
		int current = pages.getNumber() + 1;
		int begin = Math.max(1, current);
		int end = pages.getTotalPages();
		model.addAttribute("end", end);
		model.addAttribute("begin", begin);
		model.addAttribute("current", current);
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
		newTs.setTentaisan(tentaisan);
		newTs.setDacdiem(dacdiem);
		newTs.setGiatrithuc(giatrithuc);
		newTs.setTrangthai(trangthai);
		newTs.setDanhmuc(newDm);
		newTs.setNhacungcap(newNcc);
		tsService.createTaiSan(newTs);
		return "redirect:/listAsset";
	}

//	@RequestMapping(value = { "/edit-ts/{id}" }, method = RequestMethod.GET)
//	public String editAsset(@PathVariable("id") int id, Model model) {
//		model.addAttribute("lsDm", dmService.getAllDanhMuc());
//		model.addAttribute("lsNcc", sService.getAllNcc());
//		model.addAttribute("ts", tsService.getTaiSanById(id));
//		TaiSan ls = tsService.getTaiSanById(id);
//		model.addAttribute("newDm", ls.getDanhmuc().getId());
//		model.addAttribute("newNcc", ls.getNhacungcap().getId());
//		return "editdsts";
//	}

	@RequestMapping(value = { "/edit-ts/{id}" }, method = RequestMethod.GET)
	public String editAssetPopup(@PathVariable("id") int id, Model model) {
		model.addAttribute("lsDm", dmService.dmList());
		model.addAttribute("lsNcc", sService.getAllNcc());
		model.addAttribute("ts", tsService.getTaiSanById(id));
		TaiSan ls = tsService.getTaiSanById(id);
		model.addAttribute("newDm", ls.getDanhmuc().getId());
		model.addAttribute("newNcc", ls.getNhacungcap().getId());
		model.addAttribute("ts", ls);
		return "editInfoAssetPopup";
	}

	@RequestMapping(value = { "/edit-ts" }, method = RequestMethod.POST)
	public String editAsset(@ModelAttribute("ts") TaiSan ts) {
		tsService.updateTaiSan(ts);
		return "redirect:/listAsset";
	}

	@RequestMapping(value = "/delete-ts/{id}")
	public String deleteAsset(@PathVariable("id") int id) {
		tsService.deleteTaiSan(id);
		return "redirect:/listAsset";
	}

	@RequestMapping(value = { "view-details/{id}" })
	public String viewDetails(@PathVariable("id") long id, Model model) {
		TaiSan newTs = tsService.getTaiSanById(id);
		model.addAttribute("ts", newTs);
		Set<DieuChuyenTaiSan> ltsDcts = newTs.getListDieuchuyentaisan();
		model.addAttribute("ltsDcts", ltsDcts);
		Set<BienDongTaiSan> ltsBdts = newTs.getListBiendongtaisan();
		model.addAttribute("ltsBdts", ltsBdts);
		return "listAssetsDetails";
	}

}
