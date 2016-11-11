package aegis.security;
import java.util.List;

public interface ISecurityRuleDAO {
	public List<SecurityRule> getAllRules();
	public SecurityRule getRuleByID(int id);
	// etc.
	boolean updateRule(SecurityRule rule);
	boolean deleteRule(SecurityRule rule);
	boolean createRule(SecurityRule rule);
}
