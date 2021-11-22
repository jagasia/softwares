package com.example.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView home()
	{
		//retrieve all employees using dao
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		EmployeeDAO edao = (EmployeeDAO) ctx.getBean("edao");
		List<Employee> employees = edao.getEmployees();
		System.out.println(employees.size()+": records");
		//store this list in a model and then redirect to the view
		ModelAndView mv=new ModelAndView();
		mv.addObject("employees",employees);
		mv.setViewName("index");
		return mv;
	}
}
