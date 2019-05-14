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
import com.aht.entities.TaiSan;
import com.aht.serviceImpl.DanhMucServiceImpl;
import com.aht.serviceImpl.TaiSanServiceImpl;

@Controller
public class CategoriesController {

	@Autowired
	private DanhMucServiceImpl dmService;
	@Autowired
	private TaiSanServiceImpl tsService;

	@RequestMapping(value = { "/dsdm" }, method = RequestMethod.GET)
	public String dsdm(Model model) {
		List<DanhMuc> ltsDm = dmService.getAllDanhMuc();
		model.addAttribute("listDm", ltsDm);
//		System.out.println("---------++" + ls);
		return "listcategories";
	}

	@RequestMapping(value = { "/add-dsdm" }, method = RequestMethod.POST)
	public String addCategory(@RequestParam("name") String name) {
		DanhMuc dm = new DanhMuc();
		dm.setName(name);
		dmService.createDanhMuc(dm);
		return "redirect:/dsdm";
	}

	@RequestMapping(value = { "/edit-dsdm/{id}" }, method = RequestMethod.GET)
	public String editCategory(@PathVariable("id") int id, Model model) {
		model.addAttribute("dm", dmService.getDanhMucById(id));
		return "editdsdm";
	}

	@RequestMapping(value = "/edit-dsdm", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute("dm") DanhMuc dm) {
		dmService.updateDanhMuc(dm);
		return "redirect:/dsdm";
	}

	@RequestMapping(value = "/delete-dsdm/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		dmService.deleteDanhMuc(id);
		return "redirect:/dsdm";
	}

	@RequestMapping(value = "/view-category-details/{id}")
	public String viewCategories(@PathVariable("id") int id, Model model) {
		DanhMuc dmById = dmService.getDanhMucById(id);
		Set<TaiSan> ltsTsById = dmById.getListTaiSan();
		model.addAttribute("ltsTsById", ltsTsById);
//		System.out.println(dmById);
//		System.out.println(ltsTsById);
		return "listCategorieDetails";
	}

//	@RequestMapping("list-categories")
//	public String getAllCategories(Model model) {
//		List<DanhMuc> ls = dmService.getAllDanhMuc();
//		model.addAttribute("list", ls);
//		return "/categories/listCategories";
//	}

//	@RequestMapping(value = { "/add-category" }, method = RequestMethod.GET)
//	public String addCategory() {
//
//		return "/categories/addCategory";
//	}
//
//	@RequestMapping(value = { "/add-category" }, method = RequestMethod.POST)
//	public String addCategory(@RequestParam("name") String name) {
//		DanhMuc dm = new DanhMuc();
//		dm.setName(name);
//		dmService.createDanhMuc(dm);
//		return "redirect:/list-categories";
//	}

//	@RequestMapping(value = { "edit-category/{id}" }, method = RequestMethod.GET)
//	public String editCategory(@PathVariable("id") int id, Model model) {
//		model.addAttribute("dm", dmService.getDanhMucById(id));
//		return "/categories/editCategory";
//	}
//
//	@RequestMapping(value = "/edit-category", method = RequestMethod.POST)
//	public String editCategory(@ModelAttribute("dm") DanhMuc dm) {
//		dmService.updateDanhMuc(dm);
//		return "redirect:/list-categories";
//	}

//	@RequestMapping(value = "delete-category/{id}")
//	public String deleteCategory(@PathVariable("id") int id) {
//		dmService.deleteDanhMuc(id);
//		return "redirect:/list-categories";
//	}
}
