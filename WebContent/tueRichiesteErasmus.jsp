<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%  Collection <?> moduliColl = null;
	Iterator <?> moduliIt = null;
	ArrayList <ModuloBean> moduli = null;
	Boolean inviato = false;
	Boolean contaModuli = false;
	if (request.getAttribute("moduli")!=null){ 
		moduliColl = (Collection <?>) request.getAttribute("moduli");
		moduliIt = moduliColl.iterator();
		while(moduliIt.hasNext()){
			if(moduli==null)
				moduli = new ArrayList <ModuloBean>();
			moduli.add((ModuloBean)moduliIt.next());
		}	
  	} 
  	if(request.getAttribute("inviato")!=null){
  		inviato = (Boolean)request.getAttribute("inviato");
  	} 
  	if(request.getAttribute("contaModuli")!=null){
  		contaModuli = (Boolean)request.getAttribute("inviato");
  	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<link rel="icon" href="immagini/favicon.png" type="image/png"/>
		<link rel="stylesheet" type="text/css" href="css/graphic.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>Erasmus+</title>	
	</head>
	<body>	
		<%@ include file="fragments/sidebarStudente.jsp" %>	
		<div id="corpo">		
			<div id="titolo">			
				Le tue richieste Erasmus	
			</div>	
			<div id="contenuto">
			<% if(moduli==null){ %>
				<i id="iconaTriste" class="fa fa-frown-o"> </i>
				<div id="testoTriste"> 
					Non hai ancora compilato nessuna richiesta Erasmus.
					<br> <br>
					Desideri compilarne una? 
					<a id="linkTriste" href="control?action=compilaDomandaErasmus">
						Clicca QUI
					</a>
					. 
				</div>
				<% } else { %>
				<div id="testoRichiesteErasmus">
					Qui sono presenti le richieste Erasmus da te compilate e salvate, puoi modificarle e inviarle come preferisci.
					<br> <br>
					Desideri compilarne una nuova? 
					<a id="linkTriste" href="control?action=compilaDomandaErasmus">
						Clicca QUI
					</a>
					. 
				</div>
				<% if(inviato){ %>
				<div id="testoRichiesteErasmus">
					<font color="#46C646">
						&Egrave; stata gia inviata una domanda Erasmus, potrai solo modificare, creare o cancellare le prossime 
						richieste. 
					</font>
				</div>
				<% } %>
				<% int i;
				   for(i=0;i<moduli.size();i++){ %>		
				<div id="boxDomanda">			
					Compilata il: <%= moduli.get(i).getData() %> 
					<br> <br>			
					Destinazioni: <%= moduli.get(i).getDestinazione1() %>,  <%= moduli.get(i).getDestinazione2() %>,  
					<%= moduli.get(i).getDestinazione3() %>	
					<% if(!moduli.get(i).getInviaModulo()) { %>
					<button id="tastoDomandeErasmus1" onclick="location.href='control?action=caricaModulo&idModulo=<%= moduli.get(i).getID() %>&page=/compilaDomandaErasmus.jsp'"> 
						<i class="fa fa-repeat" style="font-size:24.5px; color:#FF6633; margin-right:3px; margin-left:4px; 
						   margin-bottom:3px; vertical-align: middle;" aria-hidden="true"> </i> Modifica      	
   	  				</button>  		
   	  				<button id="tastoDomandeErasmus3" onclick="location.href='control?action=cancellaModulo&idModulo=<%= moduli.get(i).getID() %>'"> 
   	  					<i class="fa fa-times" style="font-size:28px; color:red; margin-right:2px; margin-left:4px; margin-bottom:5px; 
   	  					   vertical-align:middle;" aria-hidden="true"> </i> Cancella     	
   	  				</button>  
   	  				<% } 
   	  				   if(!inviato) { %>   									
   	  				<button id="tastoDomandeErasmus2" onclick="location.href='control?action=InviaModulo&idModulo=<%= moduli.get(i).getID() %>'" <% if(inviato) { %> disabled=”disabled” <% } %> > 
   	  					<i class="fa fa-paper-plane" style="font-size:23px; color:#2ecc71; margin-right:3px; margin-left:4px; 
   	  					   margin-bottom:1px; vertical-align:middle;" aria-hidden="true"> </i> Invia     	
   	  				</button>   
   	  				<% } %>
   	  				<% if(inviato) { %> 
   	  				<button id="tastoDomandeErasmus4"> 
   	  					<i class="fa fa-paper-plane" style="font-size:23px; color:white; margin-right:3px; margin-left:4px; 
   	  					   margin-bottom:1px; vertical-align:middle;" aria-hidden="true"> </i> Inviato 
   	  				</button> 
   	  				<% } %>  		
   		  		</div>    
   		  		<% } %> 	
			</div>
			<% } %>
		</div>
	</body>
</html>