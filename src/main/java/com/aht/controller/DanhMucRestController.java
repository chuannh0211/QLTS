//package com.aht.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.aht.service.DanhMucService;
//import com.aht.entities.DanhMuc;
//
//@RestController
//@RequestMapping("/api")
//public class DanhMucRestController {
//	public static Logger logger = LoggerFactory.getLogger(DanhMucRestController.class);
//
//	@Autowired
//	private DanhMucService service;
//
//	@RequestMapping(value = "/categories/", method = RequestMethod.GET)
//	public ResponseEntity<List<DanhMuc>> listAllCategories() {
//		List<DanhMuc> listCategories = service.getAllDanhMuc();
////		if(service.isEmpty()) {
////			return new ResponseEntity(HttpStatus.NO_CONTENT);
////		}
//		return new ResponseEntity<List<DanhMuc>>(listCategories, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
//	public DanhMuc findCategories(@PathVariable("id") long id) {
//		DanhMuc category = service.getDanhMucById(id);
//		if (category == null) {
//			ResponseEntity.notFound().build();
//		}
//		return category;
//	}
//
//	@RequestMapping(value = "/categories/", method = RequestMethod.POST)
//	public DanhMuc saveContact(@Valid @RequestBody DanhMuc dm) {
//		return service.createDanhMuc(dm);
//	}
//
//	@RequestMapping(value = "/contact/", method = RequestMethod.PUT)
//	public ResponseEntity<DanhMuc> updateContact(@PathVariable(value = "id") Long id,
//			@Valid @RequestBody DanhMuc contactForm) {
//		DanhMuc dm = service.getDanhMucById(id);
//		if (dm == null) {
//			return ResponseEntity.notFound().build();
//		}
//		dm.setName(contactForm.getName());
//
//		DanhMuc updatedContact = service.createDanhMuc(dm);
//		return ResponseEntity.ok(updatedContact);
//	}
//
//	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<DanhMuc> deleteContact(@PathVariable(value = "id") Long id) {
//		DanhMuc contact = service.getDanhMucById(id);
//		if (contact == null) {
//			return ResponseEntity.notFound().build();
//		}
//
//		service.deleteDanhMuc(id);
//		return ResponseEntity.ok().build();
//	}
//}
