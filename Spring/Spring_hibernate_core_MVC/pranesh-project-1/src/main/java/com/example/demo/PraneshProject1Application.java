package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PraneshProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(PraneshProject1Application.class, args);
		  ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	        EmployeeDAO edao= (EmployeeDAO) ctx.getBean("edao");
	        List<Employee> emps = edao.getEmployees();
	        for(Employee e:emps)
	        	System.out.println(e);
	}

}
