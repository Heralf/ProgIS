<!-- 
Pagina per lo studente;Server per compilare la domanda Erasmus; si inseriscono massimo 3 destinazioni per partecipare all'erasmus
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%	
	ModuloBean modulo = null;
	if(request.getAttribute("modulo")!=null){
		modulo = (ModuloBean)request.getAttribute("modulo");
	}
	AccountBean account = (AccountBean)request.getAttribute("account");
	Boolean inviato = false;
	if(request.getAttribute("inviato")!=null){
		inviato = (Boolean)request.getAttribute("inviato");
	}
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
		<%@ include file="fragments/sidebarStudente.jsp" %>
		<div id="corpo">
			<div id="titolo">
				Compila una nuova richiesta Erasmus+
			</div>
			<div id="contenuto">
				<div id="testoCompilaDomanda"> 
					Compila tutti i campi e clicca su &quot;Invia&quot;, per inoltrare una nuova richiesta Erasmus, oppure
					su &quot;Salva&quot;, per salvare la richiesta Erasmus così compilata (potrai modificarla ed 
					inviarla in seguito nella sezione &quot;Le tue richieste Erasmus&quot;).  <br> <br>
					<form>
						<% if(modulo==null){ %>
						<p id="inputEtichetta"> Nome: <br>
						<input id="inserisciTesto" type="text" name="nome" disabled="disabled" value="<%= account.getNome() %>"> <br> 
				
						<p id="inputEtichetta"> Cognome: <br>
  						<input id="inserisciTesto" type="text" name="cognome" disabled="disabled" value="<%= account.getCognome() %>"><br>
 
  						<p id="inputEtichetta"> Sesso: <br>
	 	 				<input id="inserisciTesto" type="text" name="sesso" disabled="disabled" value="<%= account.getSesso() %>"> <br>
  		
  						<p id="inputEtichetta"> Data di nascita: <br>
						<input id="inserisciTesto" type="text" name="dataNascita" disabled="disabled" value="<%= account.getData() %>"> <br>
			
						<p id="inputEtichetta"> Matricola: <br>
						<input id="inserisciTesto" type="text" name="matricola" disabled="disabled" value="<%= account.getMatricola() %>"> 
						<br>
		
						<p id="inputEtichetta"> Posta Elettronica: <br>
						<input id="inserisciTesto" type="text" name="postaElettronica" disabled="disabled" 
						    	value="<%= account.getPostaElettronica() %>"> <br>
			 
						<p id="inputEtichetta"> Luogo di nascita: <br>
 		 				<input id="inserisciTesto" type="text" name="luogoNascita" disabled="disabled" 
 	 					   		value="<%= account.getCittaNascita() %>"> <br>
  		
	 	 				<p id="inputEtichetta"> Luogo di residenza: <br>
 	 					<input id="inserisciTesto" type="text" name="luogoResidenza" disabled="disabled" 
 	 					    	value="<%= account.getCittaResidenza() %>"> <br>
  		
  						<p id="inputEtichetta"> Indirizzo: <br>
  						<input id="inserisciTesto" type="text" name="indirizzo" disabled="disabled" value="<%= account.getIndirizzo() %>"> 
  						<br>
	  		
	 		 			<p id="inputEtichetta"> Numero Civico: <br>
  						<input id="inserisciTesto" type="text" name="numeroCivico" disabled="disabled" 
  						    	value="<%= account.getNumeroCivico() %>"> <br>
  		
  						<p id="inputEtichetta"> CAP: <br>
  						<input id="inserisciTesto" type="text" name="cap" disabled="disabled" value="<%= account.getCAP() %>"> <br>
  		
  						<p id="inputEtichetta"> Numero Telefonico: <br>
  						<input id="inserisciTesto" type="text" name="numeroTelefonico" disabled="disabled" 
  						   		value="<%= account.getNumeroTelefonico() %>"> <br>
  		
  						<p id="inputEtichetta"> Destinazione 1: <br>
  						<input id="inserisciTesto" type="text" name="destinazione1" required> <br>
  		
  						<p id="inputEtichetta"> Destinazione 2: <br>
  						<input id="inserisciTesto" type="text" name="destinazione2"> <br>
  		
  						<p id="inputEtichetta"> Destinazione 3: <br>
  						<input id="inserisciTesto" type="text" name="destinazione3"> <br>
  		
  						<button id="tastoCompilaDomanda1" type="submit" name="action" value="creaModulo"> 
  							<i class="fa fa-check-circle" style="font-size:26px; color:#FF6633; margin-right:3px; margin-left:4px; 
  							   margin-bottom:3px; vertical-align:middle;" aria-hidden="true"> </i> Salva
     					</button>	
     						<% if(inviato) { %> 
   		  				<button id="tastoCompilaDomanda3" disabled=”disabled”> 
   	  						<i class="fa fa-paper-plane" style="font-size:23px; color:white; margin-right:3px; margin-left:4px; 
   	  						   margin-bottom:1px; vertical-align:middle;" aria-hidden="true"> </i> Inviato 
   	  					</button> 
   	  						<% }else{ %>				
     					<button id="tastoCompilaDomanda2" type="submit" name="action" value="inviaModulo">
     						<i class="fa fa-paper-plane" style="font-size:23px; color:#2ecc71; margin-right:3px; margin-left:4px; 
     				   	    	margin-bottom:1px;vertical-align: middle;" aria-hidden="true"> </i> Invia
     					</button> 
     						<% } %>	
    	 				<% }else{ %>
     					<input name="idModulo" value="<%= modulo.getID() %>" style="visibility:hidden;">
     		 
	    				<p id="inputEtichetta"> Nome: <br>
						<input id="inserisciTesto" type="text" name="nome" disabled="disabled" value="<%= account.getNome() %>"> <br>
			 
						<p id="inputEtichetta"> Cognome: <br>
  						<input id="inserisciTesto" type="text" name="cognome" disabled="disabled" value="<%= account.getCognome() %>"> <br>
  			
  						<p id="inputEtichetta"> Sesso: <br>
 	 					<input id="inserisciTesto" type="text" name="sesso" disabled="disabled" value="<%= account.getSesso() %>"> <br>
  		
  						<p id="inputEtichetta"> Data di nascita: <br>
						<input id="inserisciTesto" type="text" name="dataNascita" disabled="disabled" value="<%= account.getData() %>"> <br>
		
						<p id="inputEtichetta"> Matricola: <br>
						<input id="inserisciTesto" type="text" name="matricola" disabled="disabled" value="<%= account.getMatricola() %>"> 
						<br>
		
						<p id="inputEtichetta"> Posta Elettronica: <br>
						<input id="inserisciTesto" type="text" name="postaElettronica" disabled="disabled" 
								value="<%= account.getPostaElettronica() %>"> <br>
			 
						<p id="inputEtichetta"> Luogo di nascita: <br>
 	 					<input id="inserisciTesto" type="text" name="luogoNascita" disabled="disabled" 
 	 					    	value="<%= account.getCittaNascita() %>"> <br>
  		
	 	 				<p id="inputEtichetta"> Luogo di residenza: <br>
 	 					<input id="inserisciTesto" type="text" name="luogoResidenza" disabled="disabled" 
 	 					    	value="<%= account.getCittaResidenza() %>"> <br>
  		
  						<p id="inputEtichetta"> Indirizzo: <br>
  						<input id="inserisciTesto" type="text" name="indirizzo" disabled="disabled" value="<%= account.getIndirizzo() %>"> 
  						<br>
  		
 	 					<p id="inputEtichetta"> Numero Civico: <br>
  						<input id="inserisciTesto" type="text" name="numeroCivico" disabled="disabled" 
  						    	value="<%= account.getNumeroCivico() %>"> <br>
  		
 	 					<p id="inputEtichetta"> CAP: <br>
  						<input id="inserisciTesto" type="text" name="cap" disabled="disabled" value="<%= account.getCAP() %>"> <br>
  		
  						<p id="inputEtichetta"> Numero Telefonico: <br>
  						<input id="inserisciTesto" type="text" name="numeroTelefonico" disabled="disabled" 
  						    	value="<%= account.getNumeroTelefonico() %>"> <br>
  		
  						<p id="inputEtichetta"> Destinazione 1: <br>
  						<input id="inserisciTesto" type="text" name="destinazione1" value="<%= modulo.getDestinazione1() %>" required> <br>
  		
  						<p id="inputEtichetta"> Destinazione 2: <br>
  						<input id="inserisciTesto" type="text" name="destinazione2" value="<%= modulo.getDestinazione2() %>"> <br>
  		
  						<p id="inputEtichetta"> Destinazione 3: <br>
  						<input id="inserisciTesto" type="text" name="destinazione3" value="<%= modulo.getDestinazione3() %>"> <br>
  		
  						<button id="tastoCompilaDomanda1" type="submit" name="action" value="aggiornaModulo"> 
  							<i class="fa fa-check-circle" style="font-size:26px; color:#FF6633; margin-right:3px; margin-left:4px; 
  							   margin-bottom:3px; vertical-align:middle;" aria-hidden="true"> </i> Salva
     					</button>						
    	 					<% if(inviato) { %> 
   	  					<button id="tastoCompilaDomanda3" disabled=”disabled”> 
   	  						<i class="fa fa-paper-plane" style="font-size:23px; color:white; margin-right:3px; margin-left:4px; 
   	  						   margin-bottom:1px; vertical-align:middle;" aria-hidden="true"> </i> Inviato 
   	  					</button> 
   	  						<% }else{ %>				
    	 				<button id="tastoCompilaDomanda2" type="submit" name="action" value="inviaModulo">
     						<i class="fa fa-paper-plane" style="font-size:23px; color:#2ecc71; margin-right:3px; margin-left:4px; 
     					   	    margin-bottom:1px;vertical-align: middle;" aria-hidden="true"> </i> Invia
     					</button> 
     						<% } %>	
    	 				<% } %>
     				</form>
				</div>
			</div>
		</div>
	</body>
</html>