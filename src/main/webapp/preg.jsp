<%@page import="event_Management.dao.Event_ManagementDao"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
	ResultSet rs = null;
	static int count=0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Registration</title>
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
						
		<section>						
				<div class="container">
				
					<form action="paymentValidate" method="post">
						<h2>!!Welcome for Participation!!</h2>
						<div class="content">

							
							<div>
								<label style="color: #f3ecfd;font-weight: bold;">Event Name : <br></label>
								<%
									rs = Event_ManagementDao.viewEvent();
									while(rs.next())
									{
										if(count%4==0){%>
										<br><%} %>
										<input type="checkbox" style="margin-top: 15px;" value="<%=rs.getString(2)%>" name="ename">
										<%=rs.getString(2)%>
															  
									<%count++;
									}
								%>
														 
							</div>
							
							<div class="inputbox-1">
								<label>Card No. : </label>
								<input name="ccn" type="tel" inputmode="numeric"
								   pattern="[0-9\s]{13,19}" autocomplete="cc-number"
								   maxlength="19" placeholder="xxxx xxxx xxxx xxxx" required="required"
								   required title="Min 13 digits and max 19 digits" >							 
							</div>		
							
							<div class="inputbox-1">
								<label>Enter Expired Date : </label>
								<select name='expireMM' required="required">
								    <option value=''>Month</option>
								    <option value='01'>January</option>
								    <option value='02'>February</option>
								    <option value='03'>March</option>
								    <option value='04'>April</option>
								    <option value='05'>May</option>
								    <option value='06'>June</option>
								    <option value='07'>July</option>
								    <option value='08'>August</option>
								    <option value='09'>September</option>
								    <option value='10'>October</option>
								    <option value='11'>November</option>
								    <option value='12'>December</option>
								</select>
								<select name='expireYY' id='expireYY' required="required">
								    <option value=''>Year</option>
								    <option value='2023'>2023</option>
								    <option value='2024'>2024</option>
								    <option value='2025'>2025</option>
								    <option value='2026'>2026</option>
								    <option value='2027'>2027</option>
								</select>							 
							</div>
							
							<div class="inputbox-1">
								<label>Enter your CVV : </label>
								<input type="password" name="cvv" pattern="[0-9\s]{3,4}" placeholder="Enter your CVV"
								 required="required" required title="It must have 3 digits or 4 digits"><br>
								 <p>**CVV won't get stored</p>							 
							</div>
								
							<div class="inputbox-1">
								<label>Enter CardHolder's Name : </label>
								 <input type="text" name="chname" placeholder="Enter Cardholder's Name"
								  required="required">							 
							</div>
							
						</div>												
						
						<div class="alert">
							<p>
								By clicking <a>Proceed</a> you are willing to pay.
							</p>
						</div>
																		
						<div class="button-container">
							<button type="submit">Proceed for payment</button>
						</div>
												
						<div class="register">
							<p>If you don't want to buy. <a href="pareventdetails.html">Main Page</a></p>
						</div>
					</form>	
				</div>									
		</section>													
	</header>
		
</body>
</html>