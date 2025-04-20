package studypal;

public abstract class User {
	protected String name;
	protected int age;
	
	public User(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public abstract void displayInfo();

}
