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
        Statement stmt;
		try {
			stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM SECURITY_RULES WHERE "+
	        								  "ID="+id+";" 
	        								);
	        if (rs.next()) {
	        	SecurityRule rule = new SecurityRule();
	        	rule.setId(rs.getInt("id"));
	        	rule.setApplication(rs.getString("application"));
	        	rule.setDirective(rs.getString("directive"));
	        	rule.setApi(rs.getString("api"));
	        	rule.setInstructions(rs.getString("instructions"));
	        	rule.setInput(rs.getString("input"));
	        	rule.setOutput(rs.getString("output"));
	        	return rule;
	        } else {
	        	return null;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateRule(SecurityRule rule) {
        PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement( "UPDATE SECURITY_RULES"+
												" SET application = ?, directive = ?, api = ?, instructions = ?," + 
												" input = ?, output = ?" +
												" WHERE ID="+rule.getId()+";" );
			stmt.setString(1,rule.getApplication());
			stmt.setString(2,rule.getDirective());
			stmt.setString(3,rule.getApi());
			stmt.setString(4,rule.getInstructions());
			stmt.setString(5,rule.getInput());
			stmt.setString(6,rule.getOutput());
		    stmt.executeUpdate();
		    stmt.close();
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRule(SecurityRule rule) {
        Statement stmt;
		try {
			stmt = connection.createStatement();
	        stmt.executeUpdate( "DELETE FROM SECURITY_RULES WHERE "+
	        								  "ID="+rule.getId()+";" 
	        								);
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createRule(SecurityRule rule) {
        PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement( "INSERT INTO SECURITY_RULES"+
												" (application, directive, api, instructions, input, output)" +
												" values (?,?,?,?,?,?);" );
			stmt.setString(1,rule.getApplication());
			stmt.setString(2,rule.getDirective());
			stmt.setString(3,rule.getApi());
			stmt.setString(4,rule.getInstructions());
			stmt.setString(5,rule.getInput());
			stmt.setString(6,rule.getOutput());
		    stmt.executeUpdate();
		    stmt.close();
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
