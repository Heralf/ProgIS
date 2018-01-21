

	
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
			
			Pubblica le graduatorie Erasmus+ 
	
		</div>
	
		<div id="contenuto">
		
		<div id="boxGraduatorie">
			
			Per caricare il file della graduatoria clicca sul tasto "Carica file"; verrà aperta una finestra 
			dove sarà possibile scegliere il file da caricare, scegli il file corretto e clicca sul tasto "Pubblica"
			per pubblicare la graduatoria e renderla visibile a tutti. <br> <br> 
			
			
			<div id = "nomeFile"> GraduatorieErasmus2017/2018.pdf </div> 
			<a href=""><button
				
				id="tastoCarica" > <i class="fa fa-cloud-upload" style="font-size:24px;color: #FF6633; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Carica file
     	
     		</button></a>
     		
			<a href=""><button
				
				id="tastoPubblica" > <i class="fa fa-share-alt" style="font-size:24px;color: #3399FF; margin-right:3px;margin-left:4px; margin-bottom: 3px; vertical-align: middle;" aria-hidden="true"> </i> Pubblica
     	
     		</button></a>
     									
     	</div>
     	
		</div>

</body>

</html>