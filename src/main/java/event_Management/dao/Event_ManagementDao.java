package event_Management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import event_Management.factory.ConnectionFactory;

public class Event_ManagementDao {
	public boolean validateAdLog(String unamead,String upwdadm)
	{
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select * from admin_user where uname = ? and pwd  = ?");
			ps.setString(1, unamead);
			ps.setString(2, upwdadm);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				if (con!=null)
				{
					ConnectionFactory.getConObj();
				}
				return true;
			}
						
		} catch (Exception e) {
			return false;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}				
		return false;
	}
	
	public boolean validateParLog(String unamepar,String upwdpar)
	{
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select * from par_user where uname = ? and pwd  = ?");
			ps.setString(1, unamepar);
			ps.setString(2, upwdpar);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				if (con!=null)
				{
					ConnectionFactory.getConObj();
				}
				return true;
			}
						
		} catch (Exception e) {
			return false;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}			
		return false;
	}
	
	public boolean validateParUserCheck(String unamereg,String umailreg)
	{
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select * from par_user where uname = ? or email  = ?");
			ps.setString(1, unamereg);
			ps.setString(2, umailreg);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				if (con!=null)
				{
					ConnectionFactory.getConObj();
				}
				return true;
			}
						
		} catch (Exception e) {
			return false;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}			
		return false;
	}
	
	public boolean insertUserData(String namereg, String unamereg, String upwdreg, String umailreg )
	{
		int maxId=1;
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps1 = con.prepareStatement("Select max(id) from par_user");
			ResultSet rs= ps1.executeQuery();
			if (rs.next())
			{
				maxId = rs.getInt(1);
			}
			
			PreparedStatement ps = con.prepareStatement("insert into par_user values (?, ? , ? , ?, ?)");
			ps.setInt(1, maxId+1);
			ps.setString(2, unamereg);
			ps.setString(3, upwdreg);
			ps.setString(4, namereg);						
			ps.setString(5, umailreg);
			
			int rowSet = ps.executeUpdate();
			
			if (rowSet==1)
			{
				if (con!=null)
				{
					ConnectionFactory.getConObj();
				}
				return true;
			}
						
		} catch (Exception e) {
			return false;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}			
		return false;
	}
	
	public boolean validateEvent(int eventno)
	{
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select * from event_add where eno = ?");
			ps.setInt(1, eventno);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				if (con!=null)
				{
					ConnectionFactory.getConObj();
				}
				return true;
			}
						
		} catch (Exception e) {
			return false;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}
		return false;
	}
	
	public boolean insertEventData(int eventno, String eventname, String coname, int cono, float feereg, String eventvenue, String eventdate )
	{
		
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			
			PreparedStatement ps = con.prepareStatement("insert into event_add values (?, ? , ? , ?, ?, ?, ?)");
			ps.setInt(1, eventno);
			ps.setString(2, eventname);
			ps.setString(3, coname);
			ps.setInt(4, cono);					
			ps.setFloat(5, feereg);
			ps.setString(6, eventvenue);
			ps.setString(7, eventdate);
			
			int rowSet = ps.executeUpdate();
			
			if (rowSet==1)
			{
				if (con!=null)
				{
					ConnectionFactory.getConObj();
				}
				return true;
			}
						
		} catch (Exception e) {
			if (con!=null)
			{
				ConnectionFactory.getConObj();
			}
			return false;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}			
		return false;
	}
	
	public static ResultSet viewEvent()
	{
		Connection con = null;
		ResultSet rs = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select * from event_add");
						
			rs = ps.executeQuery();		
		} catch (Exception e) {
			if (con!=null)
			{
				ConnectionFactory.getConObj();
			}
			return null;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}
		
		return rs;
	}
	
	public static double returnFee(String ename)
	{
		double fee=0;
		Connection con = null;
		ResultSet rs = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select feereg from event_add where ename=?");
			ps.setString(1, ename);
			rs = ps.executeQuery();
			if (rs.next())
			{
				fee = rs.getDouble(1);
			}			
			
		} catch (Exception e) {
			if (con!=null)
			{
				ConnectionFactory.getConObj();
			}
			return 0;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}
		return fee;
	}
	
	public static void insertUserEvent(String ename, String user, String cardno, int exmon, int exyear, String chname)
	{
		int max = 0;
		Connection con = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps1 = con.prepareStatement("Select max(id) from event_pay");
			ResultSet rs= ps1.executeQuery();
			if (rs.next())
			{
				max = rs.getInt(1);
			}
			
			
			PreparedStatement ps = con.prepareStatement("insert into event_pay values (?, ? , ? , ?, ?, ?, ?)");
			ps.setInt(1, max+1);
			ps.setString(2, ename);
			ps.setString(3, user);
			ps.setString(4, cardno);
			ps.setInt(5, exmon);				
			ps.setInt(6, exyear);
			ps.setString(7, chname);
						
			int rowSet = ps.executeUpdate();			
						
		}
		catch (Exception e) {
			if (con!=null)
			{
				ConnectionFactory.getConObj();
			}
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}
	}
	
	public static ResultSet viewAddedEvents(String user)
	{
		Connection con = null;
		ResultSet rs = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select * from event_add where ename=any(Select ename from event_pay where user=?)");
			ps.setString(1, user);		
			rs = ps.executeQuery();		
		} catch (Exception e) {
			if (con!=null)
			{
				ConnectionFactory.getConObj();
			}
			return null;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}		
		return rs;		
	}
	
	public static ResultSet viewParticipant()
	{
		Connection con = null;
		ResultSet rs = null;
		try {		
			con = ConnectionFactory.getConObj();
			PreparedStatement ps = con.prepareStatement("Select ename, user from event_pay");
					
			rs = ps.executeQuery();		
		} catch (Exception e) {
			if (con!=null)
			{
				ConnectionFactory.getConObj();
			}
			return null;
		}
		if (con!=null)
		{
			ConnectionFactory.getConObj();
		}		
		return rs;		
	}
}
