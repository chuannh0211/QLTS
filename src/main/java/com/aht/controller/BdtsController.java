package com.aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aht.serviceImpl.TaiSanServiceImpl;

@Controller
public class BdtsController {
	@Autowired
	private TaiSanServiceImpl tsService;

	@RequestMapping(value = "/form-dbts/{id}")
	public String formBdts(Model model, @PathVariable("id") int id) {
		System.out.println("aaaaaaaa");
//		TaiSan newTs = tsService.getTaiSanById(id);
//		model.addAttribute("ts", newTs);
		return "form-bdts";
	}
}
