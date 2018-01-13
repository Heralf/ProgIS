

	
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
			
			Compila modulo di accettazione
	
		</div>
	
		<div id="contenuto">
	
		<div id="testoCompilaDomanda"> 
		
		Compila tutti i campi e clicca su ''Invia'' per inoltrare il modulo appena compilato, oppure
		clicca su ''Procedi'' per salvare il modulo così compilato (potrai modificarla ed 
		inviarla in seguito nella sezione ''I tuoi moduli'').  <br> <br>
		
		
		<p id="inputEtichetta"> Nome: <br>
		<input id="inserisciTesto" type="text" name="email"> <br>
			 
		<p id="inputEtichetta"> Cognome:<br>
  		<input id="inserisciTesto" type="text" name="password"><br>
  		
  		<p id="inputEtichetta"> Data di nascita: <br>
		<input id="inserisciTesto" type="text" name="dataNascita"> <br>
			 
		<p id="inputEtichetta"> Luogo di nascita:<br>
  		<input id="inserisciTesto" type="text" name="password"><br>
  		
  		<p id="inputEtichetta"> Accettazione: <br>
  		<input id="inserisciTesto" type="text" name="destinazione"><br>
  		
  		
  		<button 
				
			id="tastoCompilaDomanda1"> <i class="fa fa-check-circle" style="font-size:26px;color:#FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Salva
     	
     	</button>
     									
     	<button 
				
			id="tastoCompilaDomanda2"> <i class="fa fa-paper-plane" style="font-size:23px;color: #2ecc71; margin-right:3px;margin-left:4px; margin-bottom: 1px;vertical-align: middle;" aria-hidden="true"> </i> Invia
     	
     	</button>
     	
		
		</div>
		
		</div>

</body>

</html>