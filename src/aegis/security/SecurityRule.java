package aegis.security;
/*
 * POJO representation of a SecurityRule
 * 6-tuple as described in the AEGIS paper
 */

public class SecurityRule {
	private int id;
	private String application;
	private String directive;
	private String api;
	private String instructions;
	private String input;
	private String output;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
	public String getDirective() {
		return directive;
	}
	public void setDirective(String directive) {
		this.directive = directive;
	}
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	@Override
	public String toString() {
		return "SecurityRule [id=" + id + ", application=" + application + ", directive=" + directive + ", api=" + api
				+ ", instructions=" + instructions + ", input=" + input + ", output=" + output + "]";
	}
	
}
