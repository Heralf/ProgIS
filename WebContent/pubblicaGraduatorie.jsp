<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%	Boolean caricato = false;
	if(request.getAttribute("caricato")!=null)
		caricato = (Boolean)request.getAttribute("caricato");
%>
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
					 <%	if(caricato){ %><label style="font-size:bold;color:red;">La graduatoria &egrave; gia stata caricata, il ricaricamento la sostituir&agrave;</label> <%	} %>	
		<form method="post" action="control" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td> <label  id ="pulsanteCarica"> <i class="fa fa-cloud-upload" style="font-size:26px; color:#2ecc71; margin-top:-5px; margin-right:2px; 
				   vertical-align:middle;" aria-hidden="true"></i>
                    Carica file <input type="file" name="data" required /></label>
                    </td>
                </tr>
                <br>
                <tr>
                    <td colspan="2">
                        <button  id ="pulsantePubblica" type="submit" name="action" value="caricaGraduatoria"> <i class="fa fa-share-alt" style="font-size:26px; color:#3399FF; margin-top:-5px; margin-right:4px; 
				   vertical-align:middle;" aria-hidden="true"> </i> Pubblica </button>
                    </td>
                </tr>
            </table>
        </form>				
     			</div>	
			</div>
	</body>
</html>