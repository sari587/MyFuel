package Entity;

public class orderTable {
	private String name;
	private String type;
	private int amount;
	private double cost;
	private String date;
	private String due;
	
	public orderTable(String name, String type, int amount, double cost, String date, String due) {
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.cost = cost;
		this.date = date;
		this.due = due;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	
}
