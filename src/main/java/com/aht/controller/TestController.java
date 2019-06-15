package com.aht.controller;

import java.util.Collection;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entities.Users;
import com.aht.serviceImpl.UserServiceImpl;

@Controller
public class TestController {
	@Autowired
	private UserServiceImpl uService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		System.out.println(name + "," + role);
		return "homePage";
	}

	@RequestMapping(value = { "/login" })
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng.");
		return "login";
	}

	/*
	 * @RequestMapping("/register-form") public String registrator(Users user, Model
	 * model) { model.addAttribute("user", user); return "listuser"; }
	 */

	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public String registrator(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("passwordConfirm") String passwordConfirm, @RequestParam("fullname") String fullname,
			@RequestParam("email") String email, @RequestParam("phone") String phone) {
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setPhone(phone);
		uService.createUser(user);

		return "redirect:/dstk";
	}

	@RequestMapping("/user-index")
	public String userIndex() {

		return "users/index";
	}

	@RequestMapping("/admin-index")
	public String adminIndex() {

		return "admins/index";
	}

	@RequestMapping("access-denied")
	public String accessDenied() {

		return "error";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("message", "Logged out!");
		return "login";
	}
}
