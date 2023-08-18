package Com.SpringCore.Constructor;

public class Student {

	private String name;
	
	private int rollno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public Student(int rollno,String name) {
		super();
		this.name = name;
		this.rollno = rollno;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + "]";
	}
	
	
	
}
