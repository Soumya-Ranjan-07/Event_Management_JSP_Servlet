package event_Management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event_Management.dao.Event_ManagementDao;
import event_Management.factory.ConnectionFactory;

@WebServlet("/valReg")
public class Validate_Registration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Event_ManagementDao em = new Event_ManagementDao();
		Connection con = null;
		
		String namereg = req.getParameter("namereg");
		String unamereg = req.getParameter("unamereg");
		String upwdreg = req.getParameter("upwdreg");
		String conupwdreg = req.getParameter("conupwdreg");
		String umailreg = req.getParameter("umailreg");
				
		if (!upwdreg.equals(conupwdreg))
		{			
			out.println("<center><h1>Registration Failure! Password and Confirm Password should match<h1></center>");
			RequestDispatcher rd = req.getRequestDispatcher("registerpar.html");
			rd.include(req, resp);
		}
		
		else
		{			
				if (em.validateParUserCheck(unamereg, umailreg))
				{
					out.println("<center><h1>Registration Failure! User name or email-Id already EXISTED<h1></center>");
					out.println("<center><h2>Enter new user name and email id<h2></center>");
					RequestDispatcher rd = req.getRequestDispatcher("registerpar.html");
					rd.include(req, resp);
				}
				else {
					if (em.insertUserData(namereg, unamereg, upwdreg, umailreg))
					{
						out.println("<center><h1>Registration Successful! Please LOGIN <h1></center>");
						RequestDispatcher rd = req.getRequestDispatcher("parlogin.html");
						rd.include(req, resp);
					}
					else {
						out.println("<center><h1>Registration Failure!<h1></center>");
						RequestDispatcher rd = req.getRequestDispatcher("/registerpar.html");
						rd.include(req, resp);
					}
				}
				
			
		}
		
		
	}
}
