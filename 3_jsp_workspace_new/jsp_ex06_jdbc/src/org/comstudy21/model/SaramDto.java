package org.comstudy21.model;

public class SaramDto {
	private int no;
	private String name;
	private String email;
	private String phone;
	
	public SaramDto() {
		no = 0;
		name = "";
		email = "";
		phone = "";
	}

	public SaramDto(int no, String name, String email, String phone) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toTable() {
		return "<tr><td>" + no + "</td><td>" + name + "</td><td>" + email + "</td><td>" + phone + "</td></tr>";
	}
	
	@Override
	public String toString() {
		return "SaramDto [no=" + no + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof SaramDto) {
			SaramDto dto = (SaramDto)obj;
			if(no == dto.no && name.equals(dto.name)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return no;
	}
	
}
