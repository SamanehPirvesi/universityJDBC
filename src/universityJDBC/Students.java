package universityJDBC;

public class Students {
	private String name;
	private int s_id;
	private int u_id;
	public Students() {
		
	}

	public Students(String name, int s_id, int u_id) {

		this.name = name;
		this.s_id = s_id;
		this.u_id = u_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

}
