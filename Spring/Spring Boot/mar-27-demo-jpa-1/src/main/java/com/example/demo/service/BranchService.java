package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Branch;
import com.example.demo.repository.BranchRepository;

@Component("bs")
public class BranchService {

	@Autowired
	private BranchRepository branchRepo;
	
	public Branch create(Branch branch) 
	{
		return branchRepo.save(branch);
	}
	public List<Branch> read() 
	{
		return branchRepo.findAll();
	}
	public Branch read(String bid) 
	{
		return branchRepo.findById(bid).get();
	}
	public Branch update(Branch branch) 
	{
		return branchRepo.save(branch);
	}
	public void delete(String bid) 
	{
		branchRepo.delete(read(bid));
	}
	
}
