package com.cts.hms.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cts.hms.entity.Employee;
import com.cts.hms.helper.EmployeeRowMapper;

@Service
public class EmployeeService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int create(Employee employee) {
		String sql="INSERT INTO Employee VALUES(?,?,?)";
		return jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
	}
	public List<Employee> read() {
		return jdbcTemplate.query("SELECT * FROM Employee", new EmployeeRowMapper());
	}
	public Employee read(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM Employee WHERE id=?", new EmployeeRowMapper(), id);
	}
	public int update(Employee employee) {
		String sql="UPDATE Employee SET firstName=?, lastName=? WHERE id=?";
		return jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
	}
	public int delete(Long id) {
		String sql="DELETE FROM Employee WHERE id=?";
		return jdbcTemplate.update(sql, id);
	}
	
}
