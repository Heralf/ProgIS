<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%	Collection <?> moduliColl = null;
	Iterator <?> moduliIt = null;
	ArrayList <ModuloBean> moduli = null;
	int i=0;
	if (request.getAttribute("moduli")!=null){ 
		moduliColl = (Collection <?>) request.getAttribute("moduli");
		moduliIt = moduliColl.iterator();
		while(moduliIt.hasNext()){
			if(moduli==null)
				moduli = new ArrayList <ModuloBean>();
			moduli.add((ModuloBean)moduliIt.next());
		}	
  	} 
  	GregorianCalendar gc = new GregorianCalendar();
  	int day=gc.get(Calendar.DAY_OF_MONTH);
  	int month=gc.get(Calendar.MONTH)+1;
  	int year=gc.get(Calendar.YEAR);
  	int day2;
  	int month2;
  	int year2;
  	%>
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
			Le tue richieste Erasmus+
		</div>
		<div id="contenuto">
	<%	if(moduli==null){%>
		<i id ="iconaTriste" class="fa fa-frown-o"></i>
		
		<div id="testoTriste"> 
		
			Non hai ancora nessun modulo di accettazione da compilare.<br><br>
			Stiamo lavorando il più in fretta possibile per controllare tutte 
			le domande Erasmus, ed anche le tue, nel caso tu ne abbia inviate.<br><br>
	
		</div>
	<%	}else{%>
	<div id="testoRichiesteErasmus">
		Qui puoi confermare di voler partecipare ad un Erasmus secondo le tue preferenze, compilando il 
		modulo di accettazione dell'Erasmus che più ti interessa.
		<br> <br>
		Compilando e inviando un modulo di accettazione, entrerai in graduatoria. 
		(Ricorda: puoi inviare un solo modulo di accettazione, ovvero, puoi far parte della graduatoria per un solo Erasmus.)
	</div>
	<%	for(i=0;i<moduli.size();i++){
			day2=Integer.parseInt(moduli.get(i).getData().substring(0, 2));
			month2=Integer.parseInt(moduli.get(i).getData().substring(3, 5));
			year2=Integer.parseInt(moduli.get(i).getData().substring(6));
			Boolean disabilita=true;
			if(year>year2){
				disabilita=false;
			}else if(year==year2){
				if(month>month2){
					disabilita=false;
				}else if(month==month2){
					if(day>=day2){
						disabilita=false;
					}
				}
			}
				
	  %><div id="boxDomanda">
		<%	if(!moduli.get(i).getInviaModulo()){ %>
			Compilare Modulo dal:<%=moduli.get(i).getData() %> <br><br>
		<%	}else{ %>
			Modulo compilato il: <%=moduli.get(i).getData() %> <br><br>
		<%	} %>
			Destinazione: <%=moduli.get(i).getDestinazione1() %> <br><br>
			Scegli questo Erasmus? <br><br>
			Clicca su "compila" e compila il modulo. 
			<button 
				id="tastoModuli1" onclick="location.href='product?action=caricaModulo&idModulo=<%= moduli.get(i).getID() %>&page=/compilaModulo.jsp'" <% if(moduli.get(i).getInviaModulo()) {%> disabled=”disabled” <% } %> <%	if(disabilita){%> disabled=”disabled” <% } %>> <i class="fa fa-pencil" style="font-size:24.5px;color:#FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Compila
     		</button>
     		
     	</div>
     	<%} %>
	</div>
	<%	}%>
</body>

</html>