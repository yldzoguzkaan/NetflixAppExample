package Model;

public class User {
	private int id;
	private String username;
	private String email;
	private String password;
	private String date;
	
	
	public User() {
	}

	public User(String username, String email, String password, String date) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "User [ id="+ id + ", username=" + username + ", email=" + email + ", password=" + password + ", date=" + date + "]";
	}
}
