package casestudy;

public class Passenger {
	private String name;
	private int age;
	private String Gender;
	
	public Passenger() {}
	
	public Passenger(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		Gender = gender;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return  name + "\t" + "\t" + age + "\t" +  Gender ;
	}
	
	
}
