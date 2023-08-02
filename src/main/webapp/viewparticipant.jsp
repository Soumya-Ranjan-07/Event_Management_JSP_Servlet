<%@page import="event_Management.dao.Event_ManagementDao"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
	ResultSet rs = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Participants Participated</title>
<link rel="stylesheet" href="style1.css">
</head>
<body>
	
	<header>
		<div class="main">
			<div class="logo">
				<a href="pareventdetails.html"><img src="logo.png"></a></li>
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
				<th>Event Name</th>				
				<th>User</th>
			</tr>
			
				<%
					rs = Event_ManagementDao.viewParticipant();
					while(rs.next())
					{%><tr>						
						<td><%=rs.getString(1) %></td>
						<td><%=rs.getString(2) %></td>						
					   </tr>
					<%}
				%>
						
		</table>							
	</header>




</body>
</html>