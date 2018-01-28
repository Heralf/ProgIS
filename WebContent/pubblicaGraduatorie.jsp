<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
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
		<%@ include file="fragments/sidebarImpiegato.jsp" %>
		<div id="corpo">
			<div id="titolo">
				Pubblica le graduatorie Erasmus 
			</div>
			<div id="contenuto">
				<div id="boxGraduatorie">
					Per caricare il file della graduatoria clicca sul tasto &quot;Carica file&quot;; verr&agrave; aperta una finestra 
					dove sar&agrave; possibile scegliere il file da caricare, scegli il file corretto e clicca sul tasto 
					&quot;Pubblica&quot; per pubblicare la graduatoria e renderla visibile a tutti. 
					<br> <br> 
					<div id="nomeFile"> 
						GraduatorieErasmus2017/2018.pdf 
					</div> 
				<!--	<form action="control" method="post" enctype="multipart/form-data">
						<input id="tastoCarica" type="file" name="graduatoria">
 					 	<i class="fa fa-cloud-upload" style="font-size:24px; color:#FF6633; margin-right:3px; margin-left:4px; 
							margin-bottom:3px; vertical-align:middle;" aria-hidden="true"> </i> Carica file
 						<input id="tastoPubblica" type="submit" name="action" value="caricaGraduatoria"> 
							<i class="fa fa-share-alt" style="font-size:24px; color:#3399FF; margin-right:3px; margin-left:4px; 
							   margin-bottom:3px; vertical-align:middle;" aria-hidden="true"> </i> Pubblica
					</form>-->		
					
		<form method="post" action="control" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" size="50"/></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" size="50"/></td>
                </tr>
                <tr>
                    <td>Portrait Photo: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="caricaGraduatoria">
                    </td>
                </tr>
            </table>
        </form>				
     			</div>	
			</div>
	</body>
</html>