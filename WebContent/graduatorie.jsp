<!--
Pagina per lo stuidente, serve a scaricare la graduatoria dal database;
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" %>
<%  int id=0;
	Boolean admin=false;
	if(request.getSession().getAttribute("id")!=null){
		id=(int)request.getSession().getAttribute("id");
		admin=(boolean)request.getSession().getAttribute("admin");
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
		<% if(id==0){ %>
		<%@ include file="fragments/sidebar.jsp" %>	
		<% }else{ %>
		<%@ include file="fragments/sidebarStudente.jsp" %>
		<% } %>
		<div id= "corpo">
			<div id="titolo">
				Controlla le graduatorie Erasmus+
			</div>
			<div id="contenuto">

<!--
   
		<div id="boxGraduatorie">
			
			La graduatoria è stata pubblicata, clicca sul pulsante "Scarica" per scaricare il file pdf della graduatoria. <br> <br> 
			
			<div id = "nomeFile"> GraduatorieErasmus2017/2018.pdf </div> 
			
			<a href=""><button 
				
				id="tastoGraduatorie"> <i class="fa fa-download" style="font-size:24px;color:#3399FF; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Scarica
     	
     		</button></a>
     									
     	</div>
	
	-->
	
			<div id="boxGraduatorie">
				La graduatoria non &egrave; stata ancora pubblicata, la invitiamo a riprovare pi&ugrave; tardi. <br> <br> 
				<a href="">
					<button id="tastoGraduatorie" > <i class="fa fa-download" style="font-size:24px; color:#3399FF; margin-right:3px; 
						    margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Scarica
     				</button>
     			</a>								
     		</div>
		</div>
	</body>
</html>