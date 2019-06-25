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

import com.aht.entities.Users;
import com.aht.serviceImpl.UserServiceImpl;

@Controller
public class UsersController {
	@Autowired
	private UserServiceImpl uServiceImpl;

	@RequestMapping(value = { "/info-user-popup/{id}" }, method = RequestMethod.GET)
	public String viewInfo(Model model, @PathVariable("id") long id) {
		Users nUser = uServiceImpl.getUserById(id);
		model.addAttribute("nUser", nUser);
		return "viewInfoUser";
	}

	@RequestMapping(value = { "/info-user/{id}" }, method = RequestMethod.GET)
	public String viewInfoRedirect(Model model, @PathVariable("id") long id) {
		Users nUser = uServiceImpl.getUserById(id);
		model.addAttribute("nUser", nUser);
		return "users/userDetails";
	}

	@RequestMapping(value = { "/listAccounts" }, method = RequestMethod.GET)
	public String getAllUsers(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<Users> pages = uServiceImpl.findAll(pageable);
//		List<Users> ltsTk = uServiceImpl.getAllUsers();
		model.addAttribute("ltsTk", pages.getContent());
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
		return "listuser";
	}

	/*
	 * @RequestMapping(value = { "/edit-dstk/{id}" }, method = RequestMethod.GET)
	 * public String editUser(@PathVariable("id") int id, Model model) {
	 * model.addAttribute("user", uServiceImpl.getUserById(id)); return "editdstk";
	 * }
	 */

	@RequestMapping(value = { "/edit-dstk/{id}" }, method = RequestMethod.GET)
	public String editUserPopup(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", uServiceImpl.getUserById(id));
		return "editUserPopup";
	}

	@RequestMapping(value = "/edit-dstk", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") Users user) {
		uServiceImpl.updateUser(user);
		return "redirect:/listAccounts";
	}

	@RequestMapping(value = "/delete-dstk/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		uServiceImpl.deleteUser(id);
		return "redirect:/listAccounts";
	}
}
