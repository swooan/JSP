package jsp_ex17_EL;

public class saram {
	private int no;
	private String name;
	private String email;
	
	public saram() {}

	public saram(int no, String name, String email) {
		this.no = no;
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "saram [no=" + no + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
