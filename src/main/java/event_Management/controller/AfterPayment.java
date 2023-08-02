package event_Management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event_Management.dao.Event_ManagementDao;

@WebServlet("/afterpayment")
public class AfterPayment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession hs = req.getSession();
		
		String user = (String)hs.getAttribute("user");
		String cardno = (String)hs.getAttribute("cardno");
		int exmon = (int)hs.getAttribute("exmon");
		int exyear = (int)hs.getAttribute("exyear");
		String chname = (String)hs.getAttribute("chname");
		String[] ename = (String[]) hs.getAttribute("ename");
				
		for (int i = 0; i < ename.length; i++)
		{
			Event_ManagementDao.insertUserEvent(ename[i], user, cardno, exmon, exyear, chname);
		}
		
		out.println("<center><h1>Payment Done Successfully<h1></center>");
		RequestDispatcher rd = req.getRequestDispatcher("pareventdetails.html");
		rd.include(req, resp);
				
	}
}
