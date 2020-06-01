package Entity;

import java.io.Serializable;

public class CreditCard implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2422073191324981839L;
	/**
	 * 
	 */

	private int num;
	private int code;
	private int Month;
	private int Year;

	public CreditCard(int num, int code, int Month, int Year) {

		this.Year = Year;
		this.Month = Month;
		this.num = num;
		this.code = code;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
