package com.stpl.assignment.controller;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stpl.assignment.model.LoginBean;
import com.stpl.assignment.model.StudentBean;
import com.stpl.assignment.service.LoginService;
import com.stpl.assignment.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	LoginService loginservice;
	@Autowired
	StudentService studentservice;

	@RequestMapping("/redirect.htm")
	public ModelAndView displayLogin() {
		return new ModelAndView("Login", "comment", new LoginBean());

	}

	@RequestMapping(value = "/Login.htm", method = RequestMethod.POST)
	public ModelAndView submitLogin(@ModelAttribute LoginBean loginbean) {

		ModelAndView model = new ModelAndView("menu");
		model.addObject("userName", loginbean.getUserName());
		model.addObject("password", loginbean.getPassword());
		boolean result = loginservice.validatelogin(loginbean);
		if (result == true) {
			return model;
		} else {

			return new ModelAndView("/Loginfailure");
		}
	}

	@RequestMapping("/menu.htm")
	public ModelAndView displaymenu() {

		return new ModelAndView("menu");

	}

	@RequestMapping("/Addstudent.htm")
	public ModelAndView Addstudentmenu() {

		return new ModelAndView("Addstudent", "command", new StudentBean());

	}

	@RequestMapping(value = "/Addstudent.htm", method = RequestMethod.POST)
	public ModelAndView submitaddstudent(@ModelAttribute StudentBean studentbean)
			throws ClassNotFoundException, SQLException, NamingException {

		// ModelAndView model=new ModelAndView("/menu");
		studentservice.insert(studentbean);
		if (studentbean.equals(null)) {
			return new ModelAndView("/addfailure");
		}
		return new ModelAndView("/addsuccessful");

	}

	@RequestMapping("/Deletestudent.htm")
	public ModelAndView deletestudentmenu() {
		return new ModelAndView("Deletestudent", "command", new StudentBean());

	}

	@RequestMapping(value = "/Deletestudent.htm", method = RequestMethod.POST)
	public ModelAndView submitdeletestudent(@ModelAttribute StudentBean studentbean)
			throws ClassNotFoundException, SQLException, NamingException {
		studentservice.delete(studentbean);
		int studentId = studentbean.getStudentid();
		System.out.println(studentId);
		ModelAndView model = new ModelAndView("/menu");

		return model;
	}

	@RequestMapping("/EditStudent.htm")
	public ModelAndView Editstudentmenu() {
		return new ModelAndView("EditStudent", "command", new StudentBean());

	}

	@RequestMapping(value = "/EditStudent.htm", method = RequestMethod.POST)
	public ModelAndView submitEditstudent(@ModelAttribute StudentBean studentbean)
			throws ClassNotFoundException, SQLException, NamingException {

		ModelAndView model = new ModelAndView("/menu");
		studentservice.update(studentbean);
		return model;
	}

	@RequestMapping("/Displaystudent.htm")
	public ModelAndView Displaystudentmenu() throws ClassNotFoundException, SQLException, NamingException {
		ModelAndView model = new ModelAndView();
		List<StudentBean> obj = studentservice.display();
		model.addObject("list", obj);
		return model;

	}

	@RequestMapping("/Searchstudent.htm")
	public ModelAndView searchstudentmenu() {
		return new ModelAndView("Searchstudent", "command", new StudentBean());

	}

	@RequestMapping(value = "/Searchstudent.htm", method = RequestMethod.POST)
	public ModelAndView submitsearchstudent(@ModelAttribute StudentBean studentbean)
			throws ClassNotFoundException, SQLException, NamingException {

		ModelAndView model = new ModelAndView("/searchview");
		List<StudentBean> obj = studentservice.search(studentbean.getStudentid());
		model.addObject("list", obj);
		return model;

	}

}
