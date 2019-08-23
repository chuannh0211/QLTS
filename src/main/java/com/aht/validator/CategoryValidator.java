package com.aht.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aht.entities.DanhMuc;
import com.aht.service.DanhMucService;

@Component
public class CategoryValidator implements Validator {
	@Autowired
	private DanhMucService dmService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == DanhMuc.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
//		DanhMuc dm = (DanhMuc) target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "msg.required");
//		if (dm.getName() != null) {
//			List<DanhMuc> result = dmService.dmList();
//			if (result != null && !result.isEmpty()) {
//				errors.rejectValue("code", "msg.duplicate");
//			}
//		}

	}

}
