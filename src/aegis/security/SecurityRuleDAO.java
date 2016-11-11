package aegis.security;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/*
 * DAO Object to connect to Postgres DB. 
 * Use to manipulate database backend, allowing for POJO business logic
 */

public class SecurityRuleDAO implements ISecurityRuleDAO {
    static final String JDBC_DRIVER = "org.sqlite.JDBC";  
    static final String DB_URL = "jdbc:sqlite:db/test.db";
   
    Connection connection;

    public SecurityRuleDAO() {
  	  connection = null;
  	  try {
  	     Class.forName(JDBC_DRIVER);
  	     connection = DriverManager.getConnection(DB_URL);	 
  	  } catch (Exception e) {
  	     e.printStackTrace();
  	     System.err.println(e.getClass().getName()+": "+e.getMessage());
  	  }
    }
	
	@Override
	public List<SecurityRule> getAllRules() {
        Statement stmt;
		try {
			stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM SECURITY_RULES;" );
	        
	        ArrayList<SecurityRule> result = new ArrayList<SecurityRule>();
	        while(rs.next()) {
	        	SecurityRule rule = new SecurityRule();
	        	rule.setId(rs.getInt("id"));
	        	rule.setApplication(rs.getString("application"));
	        	rule.setDirective(rs.getString("directive"));
	        	rule.setApi(rs.getString("api"));
	        	rule.setInstructions(rs.getString("instructions"));
	        	rule.setInput(rs.getString("input"));
	        	rule.setOutput(rs.getString("output"));
	        	result.add(rule);
	        }
	        
	        return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public SecurityRule getRuleByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRule(SecurityRule rule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRule(SecurityRule rule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRule(SecurityRule rule) {
		// TODO Auto-generated method stub
		return false;
	}

}
