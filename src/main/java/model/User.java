package model;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Boolean isAdmin;

    public User() {
    	
    }	

	public User(Integer id, String username, String password, Boolean isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

}
