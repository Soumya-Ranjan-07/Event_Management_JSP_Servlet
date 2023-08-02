package event_Management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event_Management.dao.Event_ManagementDao;
@WebServlet("/paymentValidate")
public class Payment_Validate extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		double totalEPrice=0;
		String[] ename = req.getParameterValues("ename");		
		
		if (ename==null)
		{
			out.println("<center><h1>Select atleast one or more Event Names<h1></center>");
			RequestDispatcher rd = req.getRequestDispatcher("preg.jsp");
			rd.include(req, resp);
		}
		
		else
		{
			String cardno = req.getParameter("ccn");
			int exmon = Integer.parseInt(req.getParameter("expireMM")); 
			int exyear = Integer.parseInt(req.getParameter("expireYY"));
			int cvv = Integer.parseInt(req.getParameter("cvv"));
			String chname = req.getParameter("chname");
			
			for (int i = 0; i < ename.length; i++)
			{
				totalEPrice += Event_ManagementDao.returnFee(ename[i]);				
			}
			
			HttpSession payVal = req.getSession();
			
			payVal.setAttribute("ename", ename);
			payVal.setAttribute("cardno", cardno);
			payVal.setAttribute("exmon", exmon);
			payVal.setAttribute("exyear", exyear);
			payVal.setAttribute("chname", chname);
			payVal.setAttribute("tfee", totalEPrice);
			
			RequestDispatcher rd = req.getRequestDispatcher("payment.jsp");
			rd.forward(req, resp);
		}
		
		
	}
}
