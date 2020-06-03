package Entity;

import java.io.Serializable;
 
public class Account implements Serializable {
	/**
	 * 
	 */public static enum status {
			Customer, Worker
	 };
	private static final long serialVersionUID = -7631436194844831449L;
	/**
	 * 
	 */

	private String Username;
	private String Password;
	private String name;
	private String FamilyName;
	private int IdNum;
	private String Email;
	private CreditCard CreditCard=null;
	private int logged=0;
	private status status;

	public Account(String username, String password,status status, String name, String familyName, int idNum, String email,
			Entity.CreditCard creditCard,int logged) {
		this.status=status;
		this.logged=logged;
		Username = username;
		Password = password;
		this.name = name;
		FamilyName = familyName;
		IdNum = idNum;
		Email = email;
		CreditCard = creditCard;
	}
	public int getLogged() {
		return logged;
	}
	public void setLogged(int logged) {
		this.logged = logged;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public String getUsername() {
		return Username;
	}
	public String getPassword() {
		return Password;
	}
	public String getName() {
		return name;
	}

	public int getId() {
		return IdNum;
	}
	public String getEmail() {
		return Email;
	}
	public CreditCard getCreditCard() {
		return CreditCard;
	}
}
