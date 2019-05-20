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

import com.aht.entities.NhaCungCap;
import com.aht.serviceImpl.SuppliersServiceImpl;

@Controller
public class SuppliersController {
	@Autowired
	private SuppliersServiceImpl sService;

	@RequestMapping(value = "/dsncc")
	public String getAllSuppliers(Model model) {
		List<NhaCungCap> ls = sService.getAllNcc();
		model.addAttribute("list", ls);
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
		return "redirect:/dsncc";
	}
	@RequestMapping(value = "/edit-ncc/{id}", method = RequestMethod.GET)
	public String editSupplier(@PathVariable("id") int id, Model model) {
		model.addAttribute("ncc", sService.getNccById(id));
		return "editdsncc";
	}

	@RequestMapping(value = "/edit-ncc", method = RequestMethod.POST)
	public String editSupplier(@ModelAttribute("ncc") NhaCungCap ncc) {
		sService.updateNcc(ncc);
		return "redirect:/dsncc";
	}

	@RequestMapping(value = "delete-ncc/{id}")
	public String deleteSupplier(@PathVariable("id") int id) {
		sService.deleteNcc(id);
		return "redirect:/dsncc";
	}
//	@RequestMapping(value = "/add-supplier", method = RequestMethod.GET)
//	public String addSupplier() {
//
//		return "suppliers/addSuppliers";
//	}

//	@RequestMapping(value = "/add-supplier", method = RequestMethod.POST)
//	public String addSupplier(@RequestParam("tencongty") String tencongty, @RequestParam("tentat") String tentat,
//			@RequestParam("diachi") String diachi, @RequestParam("dienthoai") String dienthoai,
//			@RequestParam("email") String email, @RequestParam("masothue") String masothue,
//			@RequestParam("nguoidaidien") String nguoidaidien, @RequestParam("company") String company) {
//		NhaCungCap newNcc = new NhaCungCap();
//		newNcc.setTencongty(tencongty);
//		newNcc.setTentat(tentat);
//		newNcc.setDiachi(diachi);
//		newNcc.setDienthoai(dienthoai);
//		newNcc.setEmail(email);
//		newNcc.setMasothue(masothue);
//		newNcc.setNguoidaidien(nguoidaidien);
//		newNcc.setCompany(company);
//		sService.createNcc(newNcc);
//		return "redirect:/list-suppliers";
//	}
//
//	@RequestMapping(value = "/list-suppliers")
//	public String getAllSuppliers(Model model) {
//		List<NhaCungCap> ls = sService.getAllNcc();
//		model.addAttribute("list", ls);
//		return "suppliers/listSuppliers";
//	}
//
//	@RequestMapping(value = "/edit-supplier/{id}", method = RequestMethod.GET)
//	public String editSupplier(@PathVariable("id") int id, Model model) {
//		model.addAttribute("ncc", sService.getNccById(id));
//		return "suppliers/editSuppliers";
//	}
//
//	@RequestMapping(value = "/edit-supplier", method = RequestMethod.POST)
//	public String editSupplier(@ModelAttribute("ncc") NhaCungCap ncc) {
//		sService.updateNcc(ncc);
//		return "redirect:/list-suppliers";
//	}
//
//	@RequestMapping(value = "delete-supplier/{id}")
//	public String deleteSupplier(@PathVariable("id") int id) {
//		sService.deleteNcc(id);
//		return "redirect:/list-suppliers";
//	}

}