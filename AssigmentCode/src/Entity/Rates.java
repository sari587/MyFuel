package Entity;

public class Rates {
	private int rateType;
	private int rateDiscount;
	private int rateDiscountEnd;

	// Casual refueling: full
	// monthly subscription – single car : 4% discount
	// monthly subscription – a lot of cars : 4% discount ecah car + 10% full price
	// Full monthly subscription for single car : 4% every time + at end of month 3%
	public Rates(int rateType, int ratePrice,int end) {
		this.rateType = rateType;
		this.rateDiscount = ratePrice;
		this.rateDiscountEnd = end;	
	}

	public double calculatePrice(int type,Order[] orders) {
		if (type == 0) {//casual 
			return orders[0].getAmount() * orders[0].getOrderCost();//one order only
		}
		if (type == 1) {//1car
			return  orders[0].getAmount() * orders[0].getOrderCost()*0.04;//one order only
		}
		if (type == 2) {//a lot of cars
			double tot = 0;
			for(Order odr : orders) {//every car is an order  
				tot=tot+odr.getAmount()*odr.getOrderCost()*0.04;
				}
			return tot*0.1;
		}
		if (type == 3) {//full
			double tot = 0;
			for(Order odr : orders) {//every time customer fuel we add to the order 
				tot=tot+odr.getAmount()*odr.getOrderCost()*0.04;
				}
			return tot*0.03;
		}

		return -1;// error 
	}

	public int getRateType() {
		return rateType;
	}

	public void setRateType(int rateType) {
		this.rateType = rateType;
	}


}
