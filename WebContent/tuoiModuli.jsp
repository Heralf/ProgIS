<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/graphic.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Erasmus+</title>
	
</head>

<% if(request.getSession().getAttribute("admin")!=null){ %>
<body onload="window.location.href = 'product?action=redirect&page=/homeStudenti.jsp';">
<% } %>

<body>
	
	<%@ include file="fragments/sidebarStudente.jsp" %>
	
	<div id= "corpo">
		
		<div id="titolo">
			
			Le tue richieste Erasmus+
	
		</div>
	
		<div id="contenuto">

<!--
   
		<i id ="iconaTriste" class="fa fa-frown-o"></i>
		
		<div id="testoTriste"> 
		
			Non hai ancora nessun modulo di accettazione da compilare.<br><br>
			Stiamo lavorando il più in fretta possibile per controllare tutte 
			le domande Erasmus, ed anche le tue, nel caso tu ne abbia inviate.<br><br>
			Non hai ancora compilato nessuna domanda Erasmus? <a id="linkTriste" href="compilaDomandaErasmus.jsp">Clicca QUI</a>. 
	
		</div>
		
	
	-->
	
	
	<div id="testoRichiesteErasmus">
		Qui puoi confermare di voler partecipare ad un Erasmus secondo le tue preferenze, compilando il 
		modulo di accettazione dell'Erasmus che più ti interessa.
		<br> <br>
		Compilando e inviando un modulo di accettazione, entrerai in graduatoria. 
		(Ricorda: puoi inviare un solo modulo di accettazione, ovvero, puoi far parte della graduatoria per un solo Erasmus.)
	</div>
		
		<div id="boxDomanda">
			
			Domanda compilata il: 15/07/2017 <br><br>
			
			Destinazione: Università di Oxford <br><br>
			
			Scegli questo Erasmus? <br><br>
			
			Clicca su "compila" e compila il modulo. 
			
			<a href="compilaModulo.jsp"><button 
				
				id="tastoModuli1"> <i class="fa fa-pencil" style="font-size:24.5px;color:#FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Compila
     	
     		</button></a>
     									
     		<button 
				
				id="tastoModuli2"> <i class="fa fa-paper-plane" style="font-size:23px;color: #2ecc71; margin-right:3px;margin-left:4px; margin-bottom: 1px;vertical-align: middle;" aria-hidden="true"> </i> Invia
     	
     		</button>
     	
     	</div>
     	
     	<div id="boxDomanda">
			
			Domanda compilata il: 15/07/2017 <br><br>
			
			Destinazione: Università di Oxford <br><br>
			
			Scegli questo Erasmus? <br><br>
			
			Clicca su "compila" e compila il modulo. 
			
			<a href="compilaModulo.jsp"><button 
				
				id="tastoModuli1"> <i class="fa fa-pencil" style="font-size:24.5px;color:#FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Compila
     	
     		</button></a>
     									
     		<button 
				
				id="tastoModuli2"> <i class="fa fa-paper-plane" style="font-size:23px;color: #2ecc71; margin-right:3px;margin-left:4px; margin-bottom: 1px;vertical-align: middle;" aria-hidden="true"> </i> Invia
     	
     		</button>
     	
     	</div>
     	
     	<div id="boxDomanda">
			
			Domanda compilata il: 15/07/2017 <br><br>
			
			Destinazione: Università di Oxford <br><br>
			
			Scegli questo Erasmus? <br><br>
			
			Clicca su "compila" e compila il modulo. 
			
			<a href="compilaModulo.jsp"><button 
				
				id="tastoModuli1"> <i class="fa fa-pencil" style="font-size:24.5px;color:#FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Compila
     	
     		</button></a>
     									
     		<button 
				
				id="tastoModuli2"> <i class="fa fa-paper-plane" style="font-size:23px;color: #2ecc71; margin-right:3px;margin-left:4px; margin-bottom: 1px;vertical-align: middle;" aria-hidden="true"> </i> Invia
     	
     		</button>
     	
     	</div>	
		
		</div>

</body>

</html>