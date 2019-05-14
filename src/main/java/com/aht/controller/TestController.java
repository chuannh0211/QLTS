package com.aht.controller;

import java.util.Collection;

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
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
		if (error != null) {
			Model message = model.addAttribute("message", "Login Failed!");
			System.out.println(message);
		}
		return "login";

	}

	@RequestMapping("/register-form")
	public String registrator(Users user, Model model) {
		model.addAttribute("user", user);
		return "listuser";
	}

	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public String registrator(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("passwordConfirm") String passwordConfirm) {
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);
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

//	@RequestMapping(value = { "/dsn" }, method = RequestMethod.GET)
//	public String dsn(Model model) {
//		List<Nhom> ltsNhom = nService.getAllNhom();
//		model.addAttribute("list", ltsNhom);
//		return "listgroups";
//	}
//
//	@RequestMapping(value = { "/dsncc" }, method = RequestMethod.GET)
//	public String dsncc(Model model) {
//		List<NhaCungCap> ls = sService.getAllNcc();
//		model.addAttribute("list", ls);
//		return "listsuppliers";
//	}
//
//	@RequestMapping(value = { "/dsts" }, method = RequestMethod.GET)
//	public String dsts(Model model) {
//		List<TaiSan> listTs = tsService.getAllTaiSan();
//		List<DanhMuc> listDm = dmService.getAllDanhMuc();
//		List<NhaCungCap> listNcc = sService.getAllNcc();
//		model.addAttribute("lsDm", listDm);
//		
//		model.addAttribute("lsTs", listTs);
//		
//		model.addAttribute("lsNcc",listNcc);
//		
////		System.out.println("list size " + listDm.size());
////		for(DanhMuc a : listDm ) {
////			System.out.println("--- "+ a.getName() );
////		}
////		System.out.println("--- "+ listDm );
//		return "listasset";
//	}
//
//	@RequestMapping(value = { "/dstk" }, method = RequestMethod.GET)
//	public String dstk(Model model) {
//		return "listuser";
//	}
}
