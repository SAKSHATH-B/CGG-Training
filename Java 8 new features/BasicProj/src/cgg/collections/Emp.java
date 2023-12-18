package cgg.collections;

public class Emp {
	private String name;
	private String phoneno;
	private int empId;
	
	public Emp(String name, String phoneno, int empId) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", phoneno=" + phoneno + ", empId=" + empId + "]";
	}

	
}
