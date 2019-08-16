package com.aht.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String index(Model model, Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		System.out.println(name + "," + role);
		model.addAttribute("msgg", " " + principal.getName());
		return "homePage";
	}

	@RequestMapping(value = { "/login" })
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng.");
		if (logout != null)
			model.addAttribute("messagee", "Đăng xuất thành công.");
		return "login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {

		return "login";
	}

	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public String registrator(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword, @RequestParam("fullname") String fullname,
			@RequestParam("email") String email, @RequestParam("phone") String phone) {
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setPasswordConfirm(confirmPassword);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setPhone(phone);
		uService.createUser(user);
		return "redirect:/user/listAccounts";
	}

	@RequestMapping("access-denied")
	public String accessDenied(Model model, Principal principal) {
		if (principal != null) {
			model.addAttribute("message",
					"<h1>Xin lỗi, " + principal.getName() + "</br> Bạn không có quyền truy cập vào trang này!</h1>");
		} else {
			model.addAttribute("msg", "Bạn không có quyền truy cập vào trang này!");
		}
		return "errorPage";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		model.addAttribute("messageee", "Logged out!");
		return "login";
	}
}
