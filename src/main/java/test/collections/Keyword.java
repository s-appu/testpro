package test.collections;

public class Keyword {

	private String key;
	private String value;
	private String group;
	
	
	public Keyword(final String key, final String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	public String toString() {
		return "Keyword is " + key + " ; " + value + " ; " + group;
	}
}
