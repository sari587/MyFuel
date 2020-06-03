package Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Server.mysqlConnection;
import controller.Packet;

enum OrderStatus {
	Available, UnAvailable
};

public class Order {
	/**
		 * 
		 */

	private String OrderType;
	private int amount;
	private String orderName;
	private int orderCost;
	private OrderStatus OrderStatus;
	private String date;
	private String due;

	public Order(String orderType, int amount, String orderName, int orderCost, Entity.OrderStatus orderStatus,String date, String due) {
		this.OrderType = orderType;
		this.amount = amount;
		this.orderName = orderName;
		this.orderCost = orderCost;
		this.OrderStatus = orderStatus;
		this.date = date;
		this.due = due;
	}

	public String getOrderType() {
		return OrderType;
	}

	public int getAmount() {
		return amount;
	}

	public String getOrderName() {
		return orderName;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus;
	}

	public String getDate() {
		return date;
	}

	public String getDue() {
		return due;
	}
	
	public void addOrder(Object orderPacket) {
		Packet packet = (Packet)orderPacket;
		Order order = (Order)packet.GetObj();
		Statement s;
		try {
			s=mysqlConnection.GetCon().createStatement();
			String newOrder=new String("('"+order.getOrderType()+"', '"+order.getAmount()+"', '"+order.getOrderName()+"', '"+order.getOrderCost()+"', '"+order.getOrderStatus()+"', '"+order.getDate()+"', '"+order.getDue()+"')");
			s.execute("INSERT INTO `project`.`account` (`type`, `amount`, `name`, `cost`, `status`, `date`, `due`) VALUES "+newOrder);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public Order getOrderbyName (String name) {
    	ResultSet  rs;
    	Statement s;
    	  try {
    		s=mysqlConnection.GetCon().createStatement();
			rs = s.executeQuery("SELECT * FROM project.orders where nmae LIKE '%"+name+"%'");
	    	return new Order(rs.getString(1), rs.getInt(2), rs.getString(3),rs.getInt(4), OrderStatus.Available, rs.getString(6) ,rs.getString(7)) ;

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//String orderType, int amount, String orderName, int orderCost, Entity.OrderStatus orderStatus,String date, String due) {
		return null;
  		
    }
}
