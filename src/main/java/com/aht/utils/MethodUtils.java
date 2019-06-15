package com.aht.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.aht.entities.DanhMuc;
import com.aht.serviceImpl.DanhMucServiceImpl;

@Component
public class MethodUtils {
	
	@Autowired
	private static DanhMucServiceImpl dmService;

	public static void pageModel(Model model, Pageable fPageable) {
//		 fPageable = PageRequest.of(0, 2, Sort.by("id"));
//		 System.out.println("fPageable" + fPageable);
//		Page<DanhMuc> pDm = dmService.pageAble(fPageable);
//		System.out.println("pDmMe" + pDm);
//		model.addAttribute("number", pDm.getNumber());
//		model.addAttribute("totalPages", pDm.getTotalPages());
//		model.addAttribute("totalElements", pDm.getTotalElements());
//		model.addAttribute("size", pDm.getSize());
//		model.addAttribute("pDm", pDm.getContent());
//		System.out.println("pDm.getContent(): " + pDm.getContent());
//		int current = pDm.getNumber() + 1;
//		int begin = Math.max(1, current);
//		int end = pDm.getTotalPages();
//		model.addAttribute("end", end);
//		model.addAttribute("begin", begin);
//		model.addAttribute("current", current);
//		model.addAttribute("totalPages", pDm.getTotalPages());
//		model.addAttribute("totalElement", pDm.getTotalElements());

	}
}
