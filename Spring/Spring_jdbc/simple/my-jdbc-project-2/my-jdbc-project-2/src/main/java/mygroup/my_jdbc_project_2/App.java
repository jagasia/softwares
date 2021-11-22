package mygroup.my_jdbc_project_2;

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
        System.out.println( "Hello World! this is from chirag" );
        //spring jdbc		
        //	1) DriverManagerDataSource		2) JdbcTemplate
//        DriverManagerDataSource dmds=new DriverManagerDataSource();
//        dmds.setDriverClassName("com.mysql.jdbc.Driver");
//        dmds.setUrl("jdbc:mysql://localhost:3306/bank");
//        dmds.setUsername("root");
//        dmds.setPassword("");
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        DriverManagerDataSource dmds=(DriverManagerDataSource) ctx.getBean("dmds");
        
//        JdbcTemplate jt=new JdbcTemplate();
//        jt.setDataSource(dmds);
        
        JdbcTemplate jt=	(JdbcTemplate) ctx.getBean("jt");
        
        jt.update("INSERT INTO branch VALUES(?,?,?)","B00015","Raja sttreet","Coimbatore");
        System.out.println("Done....");
    }
}
