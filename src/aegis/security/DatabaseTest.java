package aegis.security;
import java.util.List;

public class DatabaseTest {
	public static void main(String[] args) {
		SecurityRuleDAO rules = new SecurityRuleDAO();
		List<SecurityRule> all = rules.getAllRules();
		
		for(SecurityRule r : all) {
			System.out.println(r);
		}
	}
}
