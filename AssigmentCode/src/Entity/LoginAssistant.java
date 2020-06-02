package Entity;

import java.io.Serializable;

public class LoginAssistant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7157174747746044009L;
	private String username;
	private String password;

	public LoginAssistant(String username, String password) {
		
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	

	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	

}
