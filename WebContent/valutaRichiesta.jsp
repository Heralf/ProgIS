<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%	ModuloBean modulo = null;
	if(request.getAttribute("modulo")!=null)
		modulo = (ModuloBean)request.getAttribute("modulo"); %>
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
				Valuta la richiesta Erasmus
			</div>
			<div id="contenuto">
				<div id="testoCompilaDomanda"> 
					Le domande Erasmus necessitano di essere compilate in modo preciso e senza errori di battitura, 
					pertanto, prima di accettare o rifiutare, &egrave; necessario verificare la correttezza di ogni dato inserito
					dallo studente che l&rsquo;ha compilata; nel caso in cui non rispecchiasse gli standard baster&agrave; rifiutare
					la domanda Erasmus (lo studente verr&agrave; notificato e invitato a ricompilare tale domanda).
					<br> <br>
					<p id="inputEtichetta"> Nome: 	<%= modulo.getAccount().getNome() %>	
					<br>
					<p id="inputEtichetta"> Cognome:	<%= modulo.getAccount().getCognome() %>	
					<br>
  					<p id="inputEtichetta"> Sesso:  	<%= modulo.getAccount().getSesso() %>	
  					<br>
  					<p id="inputEtichetta"> Data di nascita: 	<%= modulo.getAccount().getData() %>	
  					<br>			 
					<p id="inputEtichetta"> Matricola:	<%= modulo.getAccount().getMatricola() %>	
					<br>
  					<p id="inputEtichetta"> Posta Elettronica:	<%= modulo.getAccount().getPostaElettronica() %>	
  					<br>
  					<p id="inputEtichetta"> Luogo di nascita:	<%= modulo.getAccount().getCittaNascita() %>	
  					<br>		
  					<p id="inputEtichetta"> Luogo di residenza:	<%= modulo.getAccount().getCittaResidenza() %>	
  					<br>
  					<p id="inputEtichetta"> Indirizzo:	<%= modulo.getAccount().getIndirizzo() %>	
  					<br>
  					<p id="inputEtichetta"> Numero Civico:	<%= modulo.getAccount().getNumeroCivico() %>	
  					<br>
  					<p id="inputEtichetta"> CAP:	<%= modulo.getAccount().getCAP() %>	
  					<br>
  					<p id="inputEtichetta"> Numero Telefonico:	<%= modulo.getAccount().getNumeroTelefonico() %>	
  					<br>
  					<p id="inputEtichetta"> Destinazione 1:	<%= modulo.getDestinazione1() %>	
  					<br>
  					<p id="inputEtichetta"> Destinazione 2:	<%= modulo.getDestinazione2() %>	
  					<br>
  					<p id="inputEtichetta"> Destinazione 3:	<%= modulo.getDestinazione3() %>	
  					<br>
  					<form action="control" method="post">
  						<p id="inputEtichetta"> Data Colloquio:	
  						<input id="inserisciTesto" type="date" name="dataColloquio" required>
  						<input type="text" name="idModulo" value="<%= modulo.getID() %>" style="visibility:hidden;">
  						<button id="tastoRespingi1" type="submit" name="action" value="confermaModulo"> 
     						<i class="fa fa-thumbs-up" style="font-size:25.5px; color:#2ecc71; margin-right:1px; margin-left:4px; 
     						   margin-bottom:2.5px; vertical-align:middle;" aria-hidden="true"> </i> Accetta
     					</button>
     				</form>	
     				<form action="control" method="post">				
     					<input type="text" name="idModulo" value="<%= modulo.getID() %>" style="visibility:hidden;">
     					<button id="tastoRespingi" type="submit" name="action" value="rifiutoModulo"> 
  							<i class="fa fa-thumbs-down" style="font-size:25.5px; color:red; margin-right:1px; margin-left:4px; 
  							   margin-bottom:2.5px; vertical-align:middle;" aria-hidden="true"> </i> Respingi
     					</button>
     				</form>
				</div>
			</div>
		</div>
	</body>
</html>