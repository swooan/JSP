package model;

public class MemberTO {
	
	String name;
	String age;
	String weight;
	String height;
	String gender;
	
	public MemberTO(String name, String age, String weight, String height, String gender) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
