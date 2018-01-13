<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%  Collection <?> moduliColl = null;
	Iterator <?> moduliIt = null;
	ArrayList <ModuloBean> moduli = null;
	if (request.getAttribute("moduli")!=null){ 
		moduliColl = (Collection <?>) request.getAttribute("moduli");
		moduliIt = moduliColl.iterator();
		while(moduliIt.hasNext()){
			if(moduli==null)
				moduli = new ArrayList <ModuloBean>();
			moduli.add((ModuloBean)moduliIt.next());
		}
			
  	} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
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
		<%	if(moduli==null){ %>
			<i id ="iconaTriste" class="fa fa-frown-o"></i>
			<div id="testoTriste"> 
			Non hai ancora compilato nessuna richiesta Erasmus.<br><br>
			
			Desideri compilarne una? <a id="linkTriste" href="compilaDomandaErasmus.jsp">Clicca QUI</a>. 
			</div>
		<%	} else { %>
		<div id="testoRichiesteErasmus">
			Qui sono presenti le richieste Erasmus da te compilate e salvate, puoi modificarle e inviarle come preferisci.
			<br> <br>
			Desideri compilarne una nuova? <a id="linkTriste" href="compilaDomandaErasmus.jsp">Clicca QUI</a>. 
		</div>
		<%	int i;
			for(i=0;i<moduli.size();i++){%>		
			<div id="boxDomanda">			
				Compilata il: <%= moduli.get(i).getData() %> <br><br>			
				Destinazione: <%= moduli.get(i).getDestinazione1() %> <br> <%= moduli.get(i).getDestinazione2() %> <br> <%= moduli.get(i).getDestinazione3() %>			
				<button 				
					id="tastoDomandeErasmus1"> <i class="fa fa-repeat" style="font-size:24.5px;color:#FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> <a href> Modifica </a>     	
   	  			</button>  		
   	  			<button 				
					id="tastoDomandeErasmus3"> <i class="fa fa-times" style="font-size:28px;color: red; margin-right:2px;margin-left:4px; margin-bottom: 5px; vertical-align: middle;" aria-hidden="true"> </i> <a href> Cancella </a>    	
   	  			</button>     									
   	  			<button 				
					id="tastoDomandeErasmus2"> <i class="fa fa-paper-plane" style="font-size:23px;color: #2ecc71; margin-right:3px;margin-left:4px; margin-bottom: 1px;vertical-align: middle;" aria-hidden="true"> </i> <a href> Invia </a>     	
   	  			</button>     	
   		  	</div>    
   		  	<%	} %> 	
		</div>
		<%	} %>
	</div>
</body>

</html>