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

import com.aht.entities.DieuChuyenTaiSan;
import com.aht.entities.Nhom;
import com.aht.entities.TaiSan;
import com.aht.serviceImpl.DieuChuyenTaiSanServiceImpl;
import com.aht.serviceImpl.NhomServiceImpl;
import com.aht.serviceImpl.TaiSanServiceImpl;

@Controller
@RequestMapping(value = "/dcts")
public class DctsController {
	@Autowired
	private TaiSanServiceImpl tsService;
	@Autowired
	private NhomServiceImpl nService;
	@Autowired
	private DieuChuyenTaiSanServiceImpl dctsService;

	@RequestMapping(value = "/form-dcts/{id}")
	public String formDcts(Model model, @PathVariable("id") int id) {
		List<Nhom> listN = nService.getAllNhom();
		model.addAttribute("lsN", listN);
		TaiSan newTs = tsService.getTaiSanById(id);
		model.addAttribute("tsDcts", newTs);
		return "form-dcts";
	}

	@RequestMapping(value = { "/add-dcts/{id}" }, method = RequestMethod.POST)
	public String addDcts(@RequestParam("ngaydieuchuyen") String ngaydieuchuyen,
			@RequestParam("tentaisan") TaiSan tentaisan, @RequestParam("nguoiquanly") String nguoiquanly,
			@RequestParam("nhom") Nhom nhom, @RequestParam("ghichu") String ghichu) {
		DieuChuyenTaiSan newDcts = new DieuChuyenTaiSan();
		newDcts.setNgaydieuchuyen(ngaydieuchuyen);
		newDcts.setTaisan(tentaisan);
		newDcts.setNguoiquanly(nguoiquanly);
		newDcts.setNhom(nhom);
		newDcts.setGhichu(ghichu);
		dctsService.createDCTS(newDcts);
		return "redirect:/asset/view-details/{id}";
	}

	@RequestMapping(value = { "view-details/xoa-dcts" })
	public String deleteDcts(@RequestParam(value = "id") int id, @RequestParam(value = "idts") int idts) {
		dctsService.deleteDCTS(id);
		return "redirect:/asset/view-details/" + idts;
	}

	/* redirect */
	@RequestMapping(value = { "/view-details/sua-dcts/{id}" }, method = RequestMethod.GET)
	public String editDcts(@PathVariable("id") int id, Model model) {
		DieuChuyenTaiSan newDcts = dctsService.getDCTSById(id);
		model.addAttribute("listNhom", nService.getAllNhom());
		model.addAttribute("newN", newDcts.getNhom().getId());
		model.addAttribute("dcts", dctsService.getDCTSById(id));
		// newDcts.getIdTaiSan(id);
		model.addAttribute("id_ts", newDcts.getIdTaiSan(id));
		return "editChitietdieuchuyen";
	}

	/* popup */
	@RequestMapping(value = { "/view-details/sua-dctsX/{id}" }, method = RequestMethod.GET)
	public String editDctsX(@PathVariable("id") int id, Model model) {
		DieuChuyenTaiSan newDcts = dctsService.getDCTSById(id);
		model.addAttribute("listNhom", nService.getAllNhom());
		model.addAttribute("newN", newDcts.getNhom().getId());
		model.addAttribute("dcts", dctsService.getDCTSById(id));
		model.addAttribute("id_ts", newDcts.getTaisan().getId());
		return "editChitietdieuchuyenPopup";
	}

	@RequestMapping(value = { "/view-details/sua-dctsX/{id}" }, method = RequestMethod.POST)
	public String editDctsX(@ModelAttribute("dcts") DieuChuyenTaiSan dcts) {
		// System.out.println("check id" + id);
		dctsService.updateDCTS(dcts);
		return "redirect:/asset/view-details/{id}";
	}

}
