package com.aht.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aht.entities.Users;
import com.aht.serviceImpl.UserServiceImpl;


public class UserValidator implements Validator {
	@Autowired
	private UserServiceImpl uService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Users user = (Users) target;

		if (!(user.getPassword().equals(user.getPasswordConfirm()))) {
			errors.rejectValue("confirmPassword", "Pw và pwCf không được trùng nhau!!!");
		}
		if (errors.hasFieldErrors("username")) {
			Users u = uService.findByUsername(user.getUsername());
			if (u != null) {
				errors.rejectValue("username", "Tài khoản đã có người sử dụng!!!");
				
			}
		}
	}

}
