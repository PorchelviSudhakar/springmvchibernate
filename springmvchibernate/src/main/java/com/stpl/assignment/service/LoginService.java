package com.stpl.assignment.service;


import com.stpl.assignment.model.LoginBean;
public class LoginService {

	public boolean validatelogin(LoginBean loginbean) {

		if (loginbean.getUserName().equals("admin") && loginbean.getPassword().equals("admin")) {
			return true;
		} else {
			return false;
		}

	}

}