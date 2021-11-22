package group_1.my_jdbc_project_1;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! today is friday....," );
        String sql="";
        //drivermanager
        //jdbctemplate
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        DriverManagerDataSource dmds=(DriverManagerDataSource) ctx.getBean("dmds");
      //  DriverManagerDataSource dmds=new DriverManagerDataSource();
//        dmds.setDriverClassName("com.mysql.jdbc.Driver");
//        dmds.setUrl("jdbc:mysql://localhost:3306/bank");
//        dmds.setUsername("root");
//        dmds.setPassword("");
        

          JdbcTemplate jt=(JdbcTemplate) ctx.getBean("jt");
//        JdbcTemplate jt=new JdbcTemplate();
//        jt.setDataSource(dmds);
        
        //insert, update, delete		st.executeUpdate();
//        sql="INSERT INTO branch VALUES(?,?,?)";
//        jt.update(sql, "B00015","M.G.Road","Bengaluru");
//        System.out.println("Please check db");
//        
//          sql="SELECT * FROM branch WHERE bid=?";
//          Branch branch = jt.queryForObject(sql, new BranchRowMapper(),"B00001");
//          System.out.println(branch);
          
//          sql="SELECT * FROM branch";
//          List<Branch> branches = jt.query(sql,new BranchRowMapper());
//          for(Branch b : branches)
//        	  System.out.println(b);
          
//          BranchDAO bdao=new BranchDAO();
//          bdao.setJt(jt);
          BranchDAO bdao=(BranchDAO) ctx.getBean("bdao");
          
          List<Branch> branches = bdao.read();
          for(Branch b: branches)
        	  System.out.println(b);
          
    }
}
