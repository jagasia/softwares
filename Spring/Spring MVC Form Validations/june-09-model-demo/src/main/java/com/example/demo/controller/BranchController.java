package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BranchDao;
import com.example.demo.entity.Branch;

@Controller
public class BranchController {

//	@GetMapping("/branch")
//	public String home(ModelMap modelMap) throws ClassNotFoundException, SQLException
//	{
////		modelMap.addAttribute("username", "Raja");
////		modelMap.addAttribute("role", "Admin");
//		BranchDao bdao=new BranchDao();
//		List<Branch> branchList = bdao.read();
//		modelMap.addAttribute("branches",branchList);
//		return "branch";
//	}
	
	@GetMapping("/branch")
	public ModelAndView home() throws ClassNotFoundException, SQLException
	{
		BranchDao bdao=new BranchDao();
		List<Branch> branchList = bdao.read();
		ModelAndView mv=new ModelAndView();
		mv.addObject("branches", branchList);
		mv.addObject("branch",new Branch());
		mv.setViewName("branch");
		return mv;
	}
	
//	@PostMapping("/add")
//	@ResponseBody	//to inform that this method does not return URL. rather, it returns value to be printed in browser
//	public Branch addBranch(Branch branch) throws ClassNotFoundException, SQLException
//	{
//		BranchDao bdao=new BranchDao();
//		int status = bdao.create(branch);
//		if(status>0)
//			return branch;
//		else
//			return null;
//	}
	
//	@PostMapping("/add")
	@RequestMapping(method = RequestMethod.POST, value = "/branch", params = "add" )
	public ModelAndView addBranch(@Valid Branch branch, BindingResult br) throws ClassNotFoundException, SQLException
	{
		if(br.hasErrors())
		{
			System.out.println("There are some validation errors");
			BranchDao bdao=new BranchDao();
			List<Branch> branchList = bdao.read();
			ModelAndView mv=new ModelAndView();
			mv.addObject("branches", branchList);
			mv.addObject("branch",branch);
			mv.setViewName("branch");
			return mv;
		}
		BranchDao bdao=new BranchDao();
		int status = bdao.create(branch);
		System.out.println(status);
		return home();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/branch", params = "modify" )
	public ModelAndView modifyBranch(@Valid Branch branch, BindingResult br) throws ClassNotFoundException, SQLException
	{
		if(branch.getBname().length()<5)
			br.addError(new FieldError("branch","bname", "Branch name cannot be less than 5 characters"));
		if(br.hasErrors())
		{
			System.out.println("There are some validation errors");
			BranchDao bdao=new BranchDao();
			List<Branch> branchList = bdao.read();
			ModelAndView mv=new ModelAndView();
			mv.addObject("branches", branchList);
			mv.addObject("branch",branch);
			mv.setViewName("branch");
			return mv;
		}
		BranchDao bdao=new BranchDao();
		int status = bdao.update(branch);
		System.out.println(status);
		List<Branch> branchList = bdao.read();
		ModelAndView mv=new ModelAndView();
		mv.addObject("branches", branchList);
		mv.addObject("branch",branch);
		mv.setViewName("branch");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/branch", params = "delete" )
	public ModelAndView deleteBranch(Branch branch) throws ClassNotFoundException, SQLException
	{
		BranchDao bdao=new BranchDao();
		int status = bdao.delete(branch.getBid());
		System.out.println(status);
		return home();
	}
	
//	@GetMapping("/select/{bid}")
//	public ModelAndView select(@PathVariable("bid") String bid) throws ClassNotFoundException, SQLException
//	{
//		BranchDao bdao=new BranchDao();
//		List<Branch> branchList = bdao.read();
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("branches", branchList);
//		Branch branch = bdao.read(bid);
//		mv.addObject("branch", branch);
//		mv.setViewName("branch");
//		return mv;
//	}
	
	@GetMapping("/select")
	public ModelAndView select(@RequestParam("bid") String bid) throws ClassNotFoundException, SQLException
	{
		BranchDao bdao=new BranchDao();
		List<Branch> branchList = bdao.read();
		ModelAndView mv=new ModelAndView();
		mv.addObject("branches", branchList);
		Branch branch = bdao.read(bid);
		mv.addObject("branch", branch);
		mv.setViewName("branch");
		return mv;
	}
	
}
