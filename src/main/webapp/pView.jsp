<%@page import="java.sql.ResultSet"%>
<%@page import="event_Management.dao.Event_ManagementDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%! 
	ResultSet rs =null;
%>

<%
HttpSession hs = request.getSession(false);
String user = (String)hs.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Participated Details</title>
<link rel="stylesheet" href="style1.css">
</head>
<body>	
	<header>
		<div class="main">
			<div class="logo">
				<a href="pareventdetails.html"><img src="logo.png"></a>
			</div>
			<ul>
				<li class="active"><a href="pareventdetails.html">Main Page</a></li>				
				<li><a href="gallery.html">Gallery</a></li>
				<li><a href="contact.html">Contact</a></li>
				<li class="active1">
					<form action="SignOut" method="post">
						<input class="button1" type="submit" value="SignOut">
					</form>
				</li>
			</ul>
		</div>
		
		<div class="title2">
			<h1>Events Participated</h1>
		</div>
		
		<table class="view-table">
			<tr>
				<th>Event No.</th>
				<th>Event Name</th>
				<th>Coordinator Name</th>
				<th>Coordinate No.</th>
				<th>Event Venue</th>
				<th>Event Date</th>
			</tr>
												
			<%
					rs = Event_ManagementDao.viewAddedEvents(user);
					while(rs.next())
					{%><tr>
						<td><%=rs.getInt(1) %></td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3) %></td>
						<td><%=rs.getInt(4) %></td>						
						<td><%=rs.getString(6) %></td>
						<td><%=rs.getString(7) %></td>
					   </tr>
					<%}
				%>				
	</table>					
	</header>
</body>
</html>