<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%  Collection <?> moduliColl = null;
	Iterator <?> moduliIt = null;
	ArrayList <ModuloBean> moduli = null;
	Boolean inviato = false;
	int i;
	if (request.getAttribute("moduli")!=null){ 
		moduliColl = (Collection <?>) request.getAttribute("moduli");
		moduliIt = moduliColl.iterator();
		while(moduliIt.hasNext()){
			if(moduli==null)
				moduli = new ArrayList <ModuloBean>();
			moduli.add((ModuloBean)moduliIt.next());
		}	
  	}%>
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
	
	<%@ include file="fragments/sidebarImpiegato.jsp" %>
	<div id= "corpo">
		<div id="titolo">
			Valuta le richieste Erasmus+
		</div>
		<div id="contenuto">
<%	if(moduli==null){%>
		<i id ="iconaTriste" class="fa fa-frown-o"></i>
		<div id="testoTriste"> 
		
			Non ci sono richieste Erasmus+ da valutare.<br><br> 
	
		</div>
<%	}else{ %>
		<div id="testoRichiesteErasmus">
			Qui sono presenti le richieste Erasmus+ compilate dagli studenti ed in attesa di essere valutate.
			<br> <br>
			Clicca sul pulsante "Valuta" per visualizzare in dettaglio la richiesta di tuo interesse. 
		</div>
	<%	for(i=0;i<moduli.size();i++){ %>
		<div id="boxDomanda">
			Mittente: <%=moduli.get(i).getAccount().getNome()%> <%=moduli.get(i).getAccount().getCognome()%><br><br>
			Compilata il: <%=moduli.get(i).getData()%> <br><br>
			Destinazione: <%=moduli.get(i).getDestinazione1()%>
			<%=moduli.get(i).getDestinazione2()%>
			<%=moduli.get(i).getDestinazione3()%>
			<a href="product?action=caricaModulo&idModulo=<%=moduli.get(i).getID()%>&page=/valutaRichiesta.jsp"><button 
				id="tastoDomandeErasmus1"> <i class="fa fa-gavel" style="font-size:25.5px;color:#FF6633; margin-right:2.5px; margin-left:3px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Valuta
     			</button>
     		</a>
    	</div>
    <%	}
	}%>
	</div>

</body>

</html>