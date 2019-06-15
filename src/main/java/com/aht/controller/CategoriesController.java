package com.aht.controller;

import java.util.List;
import java.util.Set;

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

import com.aht.entities.DanhMuc;
import com.aht.entities.TaiSan;
import com.aht.repository.DanhMucRepository;
import com.aht.serviceImpl.DanhMucServiceImpl;

@Controller
public class CategoriesController {

	@Autowired
	private DanhMucServiceImpl dmService;

	private DanhMucRepository dmRepo;

	@RequestMapping(value = { "/dsdm" }, method = RequestMethod.GET)
	public String dsdm(Model model) {
		List<DanhMuc> ltsDm = dmService.dmList();
		model.addAttribute("listDm", ltsDm);
		return "listcategories";
	}

	@RequestMapping(value = { "/dsdmPageable" }, method = RequestMethod.GET)
	public String dsdmPageable(Model model, Pageable fPageable) {
		// = PageRequest.of(0, 5, Sort.by("id"));
//		Page<DanhMuc> pDm = dmService.pageAble(fPageable);		
//		model.addAttribute("pDm", pDm.getContent());
		
//		model.addAttribute("totalPages", pDm.getTotalPages());
//		model.addAttribute("totalElement", pDm.getTotalElements());
//		System.out.println("totalPages: " + pDm.getTotalPages() );
		
		Page<DanhMuc> pages = dmService.findAll(fPageable);
//		List<DanhMuc> listDm = dmService.dmList();
//		model.addAttribute("listDm", listDm);
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElement", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("listDm", pages.getContent());
		
		int current = pages.getNumber() + 1;
		int begin = Math.max(1, current  );
		int end = pages.getTotalPages();
		model.addAttribute("end", end);
		model.addAttribute("begin", begin);
		model.addAttribute("current", current);
		return "listcategoriesPageable";
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
		DanhMuc newDm = dmService.getDanhMucById(id);
		model.addAttribute("newDm", newDm);
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
		return "listCategorieDetails";
	}
}
