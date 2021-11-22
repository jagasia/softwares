package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Branch;
import com.example.demo.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	BranchService bs;
	
	
	@GetMapping("/")
	public List<Branch> getAllBranches()
	{
		//display all branches
		List<Branch> branches = bs.read();
		return branches;
	}
	
	@GetMapping(value="/{bid}", produces = MediaType.APPLICATION_XML_VALUE)	//?bid=B00017 means @RequestParam		but /{bid} means @PathVariable
	public Branch findBranchById(@PathVariable("bid") String bid)
	{
		return bs.read(bid);
	}
	
	@PostMapping("/")
	public Branch addBranch(@RequestBody Branch branch)
	{
		return bs.create(branch);
	}
	
	@PutMapping("/")
	public Branch modifyBranch(@RequestBody Branch branch)
	{
		return bs.update(branch);
	}
	
	@DeleteMapping("/{bid}")
	public void deleteBranch(@PathVariable("bid") String bid)
	{
		bs.delete(bid);
	}
}
