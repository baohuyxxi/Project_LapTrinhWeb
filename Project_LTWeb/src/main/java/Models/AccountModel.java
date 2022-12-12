package Models;

public class AccountModel {
	private int id;
	private String username;
	private String password;
	private int role;
	private String name;
	public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountModel(String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public AccountModel(int id,String name, String username, String password, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
