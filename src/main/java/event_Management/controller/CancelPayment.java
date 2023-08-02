package event_Management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cancel")
public class CancelPayment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		
		hs.removeAttribute("cardno");
		hs.removeAttribute("exmon");
		hs.removeAttribute("exyear");
		hs.removeAttribute("chname");
		hs.removeAttribute("ename");
		
		RequestDispatcher rd = req.getRequestDispatcher("pareventdetails.html");
		rd.forward(req, resp);
	}
}
