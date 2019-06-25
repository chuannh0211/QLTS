package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.aht.entities.NhaCungCap;
import com.aht.serviceImpl.SuppliersServiceImpl;

@Controller
public class SuppliersController {
	@Autowired
	private SuppliersServiceImpl sService;

	@RequestMapping(value = "/listSuppliers")
	public String getAllSuppliers(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<NhaCungCap> pages = sService.findAll(pageable);
		
//		List<NhaCungCap> ls = sService.getAllNcc();
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElement", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("list", pages.getContent());
		
		int current = pages.getNumber() + 1;
		int begin = Math.max(1, current);
		int end = pages.getTotalPages();
		model.addAttribute("end", end);
		model.addAttribute("begin", begin);
		model.addAttribute("current", current);
		return "listsuppliers";
	}

	@RequestMapping(value = "/add-ncc", method = RequestMethod.POST)
	public String addSupplier(@RequestParam("tencongty") String tencongty, @RequestParam("tentat") String tentat,
			@RequestParam("diachi") String diachi, @RequestParam("dienthoai") String dienthoai,
			@RequestParam("email") String email, @RequestParam("masothue") String masothue,
			@RequestParam("nguoidaidien") String nguoidaidien, @RequestParam("company") String company) {
		NhaCungCap newNcc = new NhaCungCap();
		newNcc.setTencongty(tencongty);
		newNcc.setTentat(tentat);
		newNcc.setDiachi(diachi);
		newNcc.setDienthoai(dienthoai);
		newNcc.setEmail(email);
		newNcc.setMasothue(masothue);
		newNcc.setNguoidaidien(nguoidaidien);
		newNcc.setCompany(company);
		sService.createNcc(newNcc);
		return "redirect:/listSuppliers";
	}

	@RequestMapping(value = "/nccDetails/{id}", method = RequestMethod.GET)
	public String viewSupplier(@PathVariable("id") int id, Model model) {
		model.addAttribute("ncc", sService.getNccById(id));
		NhaCungCap newNcc = sService.getNccById(id);
		model.addAttribute("newNcc", newNcc);
		return "viewSuppDetails";
	}

	@RequestMapping(value = "/edit-ncc/{id}", method = RequestMethod.GET)
	public String editSupplier(@PathVariable("id") int id, Model model) {
		model.addAttribute("ncc", sService.getNccById(id));
		NhaCungCap newNcc = sService.getNccById(id);
		model.addAttribute("newNcc", newNcc);
		return "editSupplierPopup";
	}

	@RequestMapping(value = "/edit-ncc", method = RequestMethod.POST)
	public String editSupplier(@ModelAttribute("ncc") NhaCungCap ncc) {
		sService.updateNcc(ncc);
		return "redirect:/listSuppliers";
	}

	@RequestMapping(value = "delete-ncc/{id}")
	public String deleteSupplier(@PathVariable("id") int id) {
		sService.deleteNcc(id);
		return "redirect:/listSuppliers";
	}

}