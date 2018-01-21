<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%	ModuloBean modulo = null;
	if(request.getAttribute("modulo")!=null)
		modulo = (ModuloBean)request.getAttribute("modulo");
	AccountBean account = (AccountBean)request.getAttribute("account");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
	<link rel="icon" href="immagini/favicon.png" type="image/png" />
	<link rel="stylesheet" type="text/css" href="css/graphic.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Erasmus+</title>
	
</head>

<body>
	
	<%@ include file="fragments/sidebarStudente.jsp" %>
	
	<div id= "corpo">		
		<div id="titolo">
			Compila modulo di accettazione
		</div>	
		<div id="contenuto">	
			<div id="testoCompilaDomanda"> 		
			Compila tutti i campi e clicca su ''Invia'' per inoltrare il modulo appena compilato, oppure
			clicca su ''Procedi'' per salvare il modulo così compilato (potrai modificarla ed 
			inviarla in seguito nella sezione ''I tuoi moduli'').  <br> <br>		
			<p id="inputEtichetta"> Nome: <br>
			<input id="inserisciTesto" type="text" name="nome" disabled="disabled" value="<%= account.getNome() %>"> <br>
			 
			<p id="inputEtichetta"> Cognome:<br>
  			<input id="inserisciTesto" type="text" name="cognome" disabled="disabled" value="<%= account.getCognome() %>"><br>
  			
  			<p id="inputEtichetta"> Sesso:<br>
 	 		<input id="inserisciTesto" type="text" name="sesso" disabled="disabled" value="<%= account.getSesso() %>"><br>
  		
  			<p id="inputEtichetta"> Data di nascita: <br>
			<input id="inserisciTesto" type="text" name="dataNascita" disabled="disabled" value="<%= account.getData() %>"> <br>
		
			<p id="inputEtichetta"> Matricola: <br>
			<input id="inserisciTesto" type="text" name="matricola" disabled="disabled" value="<%= account.getMatricola() %>"> <br>
		
			<p id="inputEtichetta"> Posta Elettronica: <br>
			<input id="inserisciTesto" type="text" name="postaElettronica" disabled="disabled" value="<%= account.getPostaElettronica() %>"> <br>
			 
			<p id="inputEtichetta"> Luogo di nascita:<br>
 	 		<input id="inserisciTesto" type="text" name="luogoNascita" disabled="disabled" value="<%= account.getCittaNascita() %>"><br>
  		
	  		<p id="inputEtichetta"> Luogo di residenza:<br>
 	 		<input id="inserisciTesto" type="text" name="luogoResidenza" disabled="disabled" value="<%= account.getCittaResidenza() %>"><br>
  		
  			<p id="inputEtichetta"> Indirizzo:<br>
  			<input id="inserisciTesto" type="text" name="indirizzo" disabled="disabled" value="<%= account.getIndirizzo() %>"><br>
  		
 	 		<p id="inputEtichetta"> Numero Civico:<br>
  			<input id="inserisciTesto" type="text" name="numeroCivico" disabled="disabled" value="<%= account.getNumeroCivico() %>"><br>
  		
  			<p id="inputEtichetta"> CAP:<br>
  			<input id="inserisciTesto" type="text" name="cap" disabled="disabled" value="<%= account.getCAP() %>"><br>
  		
  			<p id="inputEtichetta"> Numero Telefonico:<br>
  			<input id="inserisciTesto" type="text" name="numeroTelefonico" disabled="disabled" value="<%= account.getNumeroTelefonico() %>"><br>
  			<form>
  				<input name="idModulo" value="<%= modulo.getID() %>" style="visibility:hidden;">
  				<p id="inputEtichetta"> Codice Carta Identita':<br>
  				<input id="inserisciTesto" type="text" name="CartaIdentita" required><br>  									
   			  	<button 				
					id="tastoCompilaDomanda2" type="submit" name="action" value="inviaAccettazione"> <i class="fa fa-paper-plane" style="font-size:23px;color: #2ecc71; margin-right:3px;margin-left:4px; margin-bottom: 1px;vertical-align: middle;" aria-hidden="true"> </i> Invia     	
 	   		 	</button>
 	    	</form>
			</div>
		</div>
	</div>
</body>

</html>