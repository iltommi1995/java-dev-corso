package entities;

public class Person {
	public String name;
	public String type;
	public Person(String name, String type) 
	{
		setName(name);
		setType(type);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString()
	{
		return "Name: " + name + "\n"
								+ "Type: " + type + "\n";
	}
	
}
