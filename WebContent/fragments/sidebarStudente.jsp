<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
<%	Collection <?> messaggiColl = null;
	Iterator <?> messaggiIt = null;
	ArrayList <MessaggioBean> messaggi = null;
	int j=0;
	if (request.getAttribute("messaggi")!=null){ 
		messaggiColl = (Collection <?>) request.getAttribute("messaggi");
		messaggiIt = messaggiColl.iterator();
		while(messaggiIt.hasNext()){
			if(messaggi==null)
				messaggi = new ArrayList <MessaggioBean>();
			messaggi.add((MessaggioBean)messaggiIt.next());
		}	
	}  %>
	<div id="ColonnaSx">
		<a href="homeStudenti.jsp"> <img id="logo" src="immagini/logo.png"  height="100"> </a>
		<div id="benvenuto"> Benvenuto <br> <%= (String)request.getSession().getAttribute("nome") %>
			<button id="tastoMessaggi" onclick="myFunction()"> <i class="fa fa-envelope" style="font-size: 34px;color: #BA68C8; margin-top: -6px; vertical-align: middle;"> </i> </button>  
		</div>
		<div id="boxMessaggi" style= "display: none">
			<div id= "intestazione">Le tue notifiche</div>
		<%	for(j=0;messaggi!=null&&j<messaggi.size();j++){%>
			<div id="messaggio"> <%= messaggi.get(j).getTitolo()%> : <%= messaggi.get(j).getMessaggio() %></div>
		<%	} %>
		</div>
		<a href="product?action=logout"><button 	
			id="tastoAccediLaterale"> <i class="fa fa-sign-in" style="font-size:28px;color:#FF6633; margin-right:3px;margin-left:5px;vertical-align: middle;" aria-hidden="true"> </i> Esci
     	</button></a>
            <ul>
    			<li id="LeftText"> <i class="fa fa-home" style="font-size:26.5px;color: red; margin-top: -5px; margin-right:3px; margin-left:4.5px; vertical-align: middle;" aria-hidden="true"> </i> <a href="product?action=redirect&page=/homeStudenti.jsp"> Home</a> </li>
				<li id="LeftText"> <i class="fa fa-puzzle-piece" style="font-size:26.5px;color:#FF6633; margin-top: -5px; margin-right:2.5px; margin-left:5px; vertical-align: middle;" aria-hidden="true"></i> <a href="product?action=caricaListaModuliUtente">Le tue richieste Erasmus</a> </li>
				<li id="LeftText"> <i class="fa fa-file-text" style="font-size:23.5px;color:#00BCD4; margin-top: -5px; margin-right:7.5px; margin-left:5px; vertical-align: middle;" aria-hidden="true"></i> <a href="product?action=caricaListaAccettazioneUtente">I tuoi moduli</a> </li>
				<li id="LeftText"> <i class="fa fa-star-o" style="font-size:27px;color:#3399FF; margin-top: -5px; margin-right:3px; margin-left:4px; vertical-align: middle;" aria-hidden="true"></i> <a href="product?action=redirect&page=/graduatorie.jsp" >Controlla graduatorie</a> </li>  
			</ul> 			
 	</div>
	<div id="rigaCentrale">	
		<a href=""homeStudenti.jsp""><img id="logoPortrait" src="immagini/logo.png" alt="Mia Immagine" height="130" width="350"></a>
		<div id="benvenuto"> Benvenuto <br> <%= (String)request.getSession().getAttribute("nome") %>
				<button id="tastoMessaggi" onclick="myFunction()"> <i class="fa fa-envelope" style="font-size: 34px;color: #BA68C8; margin-top: -6px; vertical-align: middle;"> </i> </button>  
		</div>
		<div id="boxMessaggi1" style= "display: none">
			<div id= "intestazione">Le tue notifiche</div>
			<%	for(j=0;messaggi!=null&&j<messaggi.size();j++){%>
			<div id="messaggio"> <%= messaggi.get(j).getTitolo()%> : <%= messaggi.get(j).getMessaggio() %></div>
		<%	} %>
		</div>
		<a href="product?action=logout"><button 
				id="tastoAccediPortrait"> <i class="fa fa-sign-in" style="font-size:29px;color:#FF6633; margin-right:3px;margin-left:5px;vertical-align: middle;" aria-hidden="true"> </i> Esci
    	</button></a>
				<li id="OrizText"> <i class="fa fa-home" style="font-size:26.5px;color: red ;margin-top: -3px; margin-right:3px;margin-left:4.5px;vertical-align: middle;" aria-hidden="true"> </i> <a href="product?action=redirect&page=/homeStudenti.jsp"> Home</a> </li>
				<li id="OrizText"> <i class="fa fa-puzzle-piece" style="font-size:26.5px;color:#FF6633; margin-top: -3px;margin-right:3px;margin-left:5px;vertical-align: middle;" aria-hidden="true"></i> <a href="product?action=caricaListaModuliUtente">Le tue richieste Erasmus</a> </li>
				<li id="OrizText"> <i class="fa fa-file-text" style="font-size:24px;color:#00BCD4; margin-top: -3px;margin-right:7px;margin-left:5px;vertical-align: middle;" aria-hidden="true"></i> <a href="product?action=caricaListaAccettazioneUtente">I tuoi moduli</a> </li>
				<li id="OrizText"> <i class="fa fa-star-o" style="font-size:27px;color:#3399FF; margin-top: -3px;margin-right:3px;margin-left:4px;vertical-align: middle;" aria-hidden="true"></i> <a href="product?action=redirect&page=/graduatorie.jsp" >Controlla graduatorie</a> </li>   
	</div>
	<script type="text/javascript">
		function myFunction() {
   		 var x = document.getElementById("boxMessaggi");
   		 var y = document.getElementById("boxMessaggi1");
    		if (x.style.display === "none") {
        		x.style.display = "block";
        		y.style.display = "block";
    		} else {
        		x.style.display = "none";
        		y.style.display = "none";
    		}
		} 
	</script>
