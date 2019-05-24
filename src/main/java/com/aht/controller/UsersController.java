package com.aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = { "/dstk" }, method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		List<Users> ltsTk = uServiceImpl.getAllUsers();
		model.addAttribute("ltsTk", ltsTk);
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
		return "redirect:/dstk";
	}
	
	

	@RequestMapping(value = "/delete-dstk/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		uServiceImpl.deleteUser(id);
		return "redirect:/dstk";
	}
}
