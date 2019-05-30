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

import com.aht.entities.Nhom;
import com.aht.serviceImpl.NhomServiceImpl;

@Controller
public class GroupsController {
	@Autowired
	private NhomServiceImpl nService;

	@RequestMapping(value = "/dsnhom")
	public String listGroup(Model model) {
		List<Nhom> list = nService.getAllNhom();
		model.addAttribute("list", list);
		return "listgroups";
	}

	@RequestMapping(value = "add-dsn")
	public String addGroup(@RequestParam("name") String name, @RequestParam("pm") String pm) {
		Nhom newN = new Nhom();
		newN.setName(name);
		newN.setPm(pm);
		nService.createNhom(newN);
		return "redirect:/dsn";
	}

	@RequestMapping(value = "/group-details/{id}", method = RequestMethod.GET)
	public String viewGroup(@PathVariable("id") int id, Model model) {
		model.addAttribute("gr", nService.getNhomById(id));
		return "viewGroupDetails";
	}

	@RequestMapping(value = "/edit-dsn/{id}", method = RequestMethod.GET)
	public String editGroup(@PathVariable("id") int id, Model model) {
		model.addAttribute("gr", nService.getNhomById(id));
		return "editGroupPopup";
	}

	@RequestMapping(value = "/edit-dsn", method = RequestMethod.POST)
	public String editGroup(@ModelAttribute("gr") Nhom gr) {
		nService.updateNhom(gr);
		return "redirect:/dsn";
	}

	@RequestMapping(value = "/delete-dsn/{id}")
	public String deleteGroup(@PathVariable("id") int id) {
		nService.deleteNhom(id);
		return "redirect:/dsn";
	}

}
