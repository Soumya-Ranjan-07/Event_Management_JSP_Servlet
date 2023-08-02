package event_Management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event_Management.dao.Event_ManagementDao;
@WebServlet("/AddEvent")
public class Add_Event extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Event_ManagementDao em = new Event_ManagementDao();
		
		int eventno = Integer.parseInt(req.getParameter("eventno"));
		String eventname = req.getParameter("eventname");
		String coname = req.getParameter("coname");
		int cono = Integer.parseInt(req.getParameter("cono"));
		float feereg = Float.parseFloat(req.getParameter("feereg"));
		String eventvenue = req.getParameter("eventvenue");
		String eventdate = req.getParameter("eventdate");
				
		if (em.validateEvent(eventno))
		{
			out.println("<center><h1>Event Addition Failure! Event no. already EXISTED<h1></center>");
			out.println("<center><h2>Enter new Event no.<h2></center>");
			RequestDispatcher rd = req.getRequestDispatcher("createEvent.html");
			rd.include(req, resp);
		}
		else {
			if (em.insertEventData(eventno, eventname, coname, cono, feereg, eventvenue, eventdate))
			{
				out.println("<center><h1>Event Added Successfully! <h1></center>");
				RequestDispatcher rd = req.getRequestDispatcher("eventdetails.html");
				rd.include(req, resp);
			}
			else {
				out.println("<center><h1>Event was not added. Had a Failure! Please add again<h1></center>");
				RequestDispatcher rd = req.getRequestDispatcher("createEvent.html");
				rd.include(req, resp);
			}
		}		
	}
}
