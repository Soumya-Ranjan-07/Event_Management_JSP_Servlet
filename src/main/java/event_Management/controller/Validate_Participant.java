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

@WebServlet("/valparticipant")
public class Validate_Participant extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Event_ManagementDao em = new Event_ManagementDao();
				
		String unamepar = req.getParameter("unamepar");
		String upwdpar = req.getParameter("upwdpar");
				
		
		if (em.validateParLog(unamepar,upwdpar))
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("user", unamepar);
			
			RequestDispatcher rd = req.getRequestDispatcher("pareventdetails.html");
			rd.forward(req, resp);
		}
		
		else {
			out.println("<center><h1>Login Failure! Please enter valid username and password<h1></center>");
			RequestDispatcher rd = req.getRequestDispatcher("parlogin.html");
			rd.include(req, resp);
		}
	}
}
