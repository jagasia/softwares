package group_1.my_jdbc_project_1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("bdao")
public class BranchDAO {
	
	@Autowired
	JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public List<Branch> read()
	{
		return jt.query("SELECT * FROM branch", new BranchRowMapper());
	}
}
