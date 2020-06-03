package Entity;

import java.sql.SQLException;
import java.sql.Statement;

import Server.mysqlConnection;
import controller.Packet;

public class CompanyMarketingRep {

	public static void OnAddedUser(Object inPacketGoing) throws SQLException
	{
		Packet packet=  (Packet) inPacketGoing;
		Account account = (Account)packet.GetObj();
		Statement s;
		s=mysqlConnection.GetCon().createStatement();
		int haveCreditCard;
		if(account.getCreditCard()!=null)
			haveCreditCard=1;
		else
			
			haveCreditCard=0;
		String UpdateValues=new String("('"+account.getUsername()+"', '"+account.getPassword()+"', '"+"customer"+"', '"+account.getName()+"', '"+account.getFamilyName()+"', '"+account.getEmail()+"', '"+haveCreditCard+"', '"+0+"')");
		s.execute("INSERT INTO `project`.`account` (`Username`, `Password`, `status`, `name`, `familyName`, `email`, `creditcard`, `logged`) VALUES "+UpdateValues);

		
	}
}
