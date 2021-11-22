package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo.entity.Branch;

public class BranchDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle rb=ResourceBundle.getBundle("db");
		Class.forName(rb.getString("driver"));
		return DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
	}
	
	public int create(Branch branch) throws ClassNotFoundException, SQLException {
		//insert
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("INSERT INTO Branch1 VALUES(?,?,?, NULL)");
		st.setString(1, branch.getBid());
		st.setString(2, branch.getBname());
		st.setString(3, branch.getBcity());
		int no=st.executeUpdate();
		con.close();
		return no;
	}
	public List<Branch> read() throws ClassNotFoundException, SQLException {
		//select all
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * from Branch1");
		ResultSet rs = st.executeQuery();
		//rs contains records. each record should be stored in a Branch object. All objects in a List<Branch>
		List<Branch> branchList=new ArrayList<>();
		while(rs.next())
		{
			Branch branch=new Branch(rs.getString(1), rs.getString(2), rs.getString(3));
			branchList.add(branch);
		}
		con.close();
		return branchList;
		
	}
	public Branch read(String bid) throws ClassNotFoundException, SQLException {
		//select by id
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * from Branch1 WHERE bid=?");
		st.setString(1, bid);
		ResultSet rs = st.executeQuery();
		Branch branch=null;
		if(rs.next())
		{
			branch=new Branch(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		con.close();
		return branch;
	}
	public int update(Branch branch) throws ClassNotFoundException, SQLException {
		//update
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("UPDATE Branch1 SET bname=?, bcity=? WHERE bid=?");
		st.setString(1, branch.getBname());
		st.setString(2, branch.getBcity());
		st.setString(3, branch.getBid());
		int no=st.executeUpdate();
		con.close();
		return no;
	}
	public int delete(String bid) throws ClassNotFoundException, SQLException {
		//delete
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM Branch1 WHERE bid=?");
		st.setString(1, bid);
		int no=st.executeUpdate();
		con.close();
		return no;
	}
	
}
