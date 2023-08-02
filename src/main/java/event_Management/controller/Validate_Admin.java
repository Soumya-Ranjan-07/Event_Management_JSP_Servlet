package event_Management.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event_Management.dao.Event_ManagementDao;

@WebServlet("/validateadmin")
public class Validate_Admin extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Event_ManagementDao em = new Event_ManagementDao();
		
		
		String unamead = req.getParameter("unamead");
		String upwdadm = req.getParameter("upwdadm");
		
		if (em.validateAdLog(unamead,upwdadm))
		{
			RequestDispatcher rd = req.getRequestDispatcher("eventdetails.html");
			rd.forward(req, resp);
		}
		
		else {
			out.println("<center><h1>Login Failure! Please enter valid username and password<h1></center>");
			RequestDispatcher rd = req.getRequestDispatcher("alogin.html");
			rd.include(req, resp);
		}
	}
}
