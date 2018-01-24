<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" %>
<%	Boolean errore=null;
	if(request.getAttribute("errore")!=null){
		errore=(boolean)request.getAttribute("errore");
	} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<link rel="icon" href="immagini/favicon.png" type="image/png"/>
		<link rel="stylesheet" type="text/css" href="css/graphic.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<title> Erasmus+ </title>
	</head>	
	<body>	
		<%@ include file="fragments/sidebar.jsp" %>	
		<div id="corpo">		
			<div id="titolo">			
				Accedi ad Erasmus+
			</div>	
			<div id="contenuto">		
				<div id="testoLogin"> 
					<form action="control" method="post">		
						Accedi inserendo le tue credenziali universitarie.
						<br> <br>			
			 			<p id="inputEtichetta"> Email: 
			 			<br>
			 			<input id="inserisciTesto" type="text" name="email" required> <% if(errore!=null&&errore){ %> 
			 				<font color="red"> Email non registrata </font>	<% } %> 
			 			<br>
			 			<p id="inputEtichetta"> Password:
			 			<br>
  			 			<input id="inserisciTesto" type="password" name="password" required><% if(errore!=null&&!errore){ %> 
  			 				<font color="red"> Password Errata </font> <% } %>
  			 			<br>			 
						<button id="tastoLogin" type="submit" name="action" value="login"> 
							<i class="fa fa-sign-in" style="font-size:28px; color:#FF6633; margin-right:3px; margin-left:5px;
							   vertical-align: middle;" aria-hidden="true"> </i> Accedi
     					</button>
     				</form>
				</div>
			</div>
		</div>
	</body>
</html>