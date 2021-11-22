package group_1.my_jdbc_project_1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BranchRowMapper implements RowMapper<Branch>
{

	public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {
		Branch branch=new Branch();
		branch.setBid(rs.getString(1));
		branch.setBname(rs.getString(2));
		branch.setBcity(rs.getString(3));
		return branch;
	}

}
