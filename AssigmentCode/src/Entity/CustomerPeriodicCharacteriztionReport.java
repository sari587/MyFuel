package Entity;

import java.util.ArrayList;

public class CustomerPeriodicCharacteriztionReport {
private ArrayList<Account> ListOfCustomers=new ArrayList<Account>();
public void addCustomer(Account C){
	ListOfCustomers.add(C);
}
public void removeCutomer(int i)
{
	ListOfCustomers.remove(i);
}
public Account cutomerAt(int i)
{
	return ListOfCustomers.get(i);
}
}
