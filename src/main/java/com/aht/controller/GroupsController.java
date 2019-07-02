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

import com.aht.entities.Nhom;
import com.aht.serviceImpl.NhomServiceImpl;

@Controller
@RequestMapping(value = "/group")
public class GroupsController {
	@Autowired
	private NhomServiceImpl nService;

	@RequestMapping(value = "/listGroups")
	public String listGroup(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<Nhom> pages = nService.findAll(pageable);
		// List<Nhom> list = nService.getAllNhom();
		model.addAttribute("list", pages.getContent());
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
		return "listgroups";
	}

	@RequestMapping(value = "/add-group")
	public String addGroup(@RequestParam("name") String name, @RequestParam("pm") String pm) {
		Nhom newN = new Nhom();
		newN.setName(name);
		newN.setPm(pm);
		nService.createNhom(newN);
		return "redirect:/group/listGroups";
	}

	@RequestMapping(value = "/group-details/{id}", method = RequestMethod.GET)
	public String viewGroup(@PathVariable("id") int id, Model model) {
		model.addAttribute("gr", nService.getNhomById(id));
		return "viewGroupDetails";
	}

	@RequestMapping(value = "/edit-group/{id}", method = RequestMethod.GET)
	public String editGroup(@PathVariable("id") int id, Model model) {
		model.addAttribute("gr", nService.getNhomById(id));
		return "editGroupPopup";
	}

	@RequestMapping(value = "/edit-group", method = RequestMethod.POST)
	public String editGroup(@ModelAttribute("gr") Nhom gr) {
		nService.updateNhom(gr);
		return "redirect:/group/listGroups";
	}

	@RequestMapping(value = "/delete-group/{id}")
	public String deleteGroup(@PathVariable("id") int id) {
		nService.deleteNhom(id);
		return "redirect:/group/listGroups";
	}

}
