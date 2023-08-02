<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>

<%
HttpSession payVal = request.getSession(false);
double fees = (double)payVal.getAttribute("tfee");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<header>
	<div style="padding-top: 150px; padding-left: 250px">
	<div class="container" style="text-align: center;">
		<h1>Payment Details</h1>
		
		<h2 style="text-align: center;">Total Fee : </h2>
			<h2 style="text-align: center; font-style: italic;"><%=fees %></h2>
		<div class="button-container"><a href="afterpayment" style="text-decoration: none"><button>Pay</button></a></div>
		<div class="button-container"><a href="cancel" style="text-decoration: none"><button>Cancel</button></a></div>								
	</div>
	</div>	
	</header>
</body>
</html>