<!--
Sidebar utilizzata quando il login non è stato ancora effettuato
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

	<div id="ColonnaSx">
		<a href="homeStudenti.jsp">
			<img id="logo" src="immagini/logo.png" alt="Mia Immagine" height="100" >
		</a>
		<a href="login.jsp">
			<button id="tastoAccediLaterale"> 
				<i class="fa fa-sign-in" style="font-size:28px; color:#FF6633; margin-right:3px; margin-left:5px; vertical-align: middle;" 
				   aria-hidden="true"> </i> Accedi
     		</button>
     	</a>
        <ul>
        	<li id="LeftText"> 
        		<i class="fa fa-home" style="font-size:26.5px; color:red; margin-top:-5px; margin-right:3px; margin-left:4.5px; 
        		   vertical-align:middle;" aria-hidden="true"> </i> 
        		   <a href="control?action=redirect&page=/homeStudenti.jsp"> Home </a> 
        	</li>
			<li id="LeftText"> 
				<i class="fa fa-star-o" style="font-size:27px; color:#3399FF; margin-top:-5px; margin-right:3px; margin-left:4px; 
				   vertical-align:middle;" aria-hidden="true"> </i> 
				<a href="control?action=redirect&page=/graduatorie.jsp"> Controlla graduatorie </a> 
			</li>  	
		</ul> 			
		<p id="suggerimento"> Gestisci Grandezza Caratteri
 		<button id="tastoModificaFont" onclick="modificaTestoLittle()"> 
 			<i class="fa fa-font" style="font-size:20px; color:black; vertical-align:middle;"> </i> 
 		</button>
 		<button id="tastoModificaFont" onclick="modificaTestoMiddle()"> 
 			<i class="fa fa-font" style="font-size:25px; color:black; margin-top:-5px; vertical-align:middle;"> </i> 
 		</button>
 		<button id="tastoModificaFont" onclick="modificaTestoBig()"> 
 			<i class="fa fa-font" style="font-size:30px; color:black; margin-top:-10px; vertical-align:middle;"> </i> 
 		</button>
 	</div>
 	</div>
		
	<div id="rigaCentrale">
		<a href="homeStudenti.jsp">
			<img id="logoPortrait" src="immagini/logo.png" alt="Mia Immagine" height="130" width="350">
		</a>
    	<a href="login.jsp">
    		<button id="tastoAccediPortrait"> 
    			<i class="fa fa-sign-in" style="font-size:29px; color:#FF6633; margin-right:3px; margin-left:5px; vertical-align:middle;"
    			   aria-hidden="true"> </i> Accedi  	
    		</button>
    	</a>
		<li id="OrizText"> 
			<i class="fa fa-home" style="font-size:26.5px; color:red ;margin-top:-3px; margin-right:3px; margin-left:4.5px; 
			   vertical-align: middle;" aria-hidden="true"> </i> 
			   <a href="homeStudenti.jsp"> Home </a> 
		</li>
		<li id="OrizText"> 
			<i class="fa fa-star-o" style="font-size:27px; color:#3399FF; margin-top:-3px; margin-right:3px; margin-left:4px;
			   vertical-align: middle;" aria-hidden="true"></i> 
			   <a href="graduatorie.jsp" > Controlla graduatorie </a> 
		</li>    
		<p id="suggerimento1"> Gestisci Grandezza Caratteri
		<br>
 		<button id="tastoModificaFont1" onclick="modificaTestoLittle()"> 
 			<i class="fa fa-font" style="font-size:20px; color:black; vertical-align:middle;"> </i> 
 		</button>
 		<button id="tastoModificaFont1" onclick="modificaTestoMiddle()"> 
 			<i class="fa fa-font" style="font-size: 25px; color:black; margin-top:-5px; vertical-align:middle;"> </i> 
 		</button>
 		<button id="tastoModificaFont1" onclick="modificaTestoBig()"> 
 			<i class="fa fa-font" style="font-size:30px; color:black; margin-top:-10px; vertical-align:middle;"> </i> 
 		</button>
	</div>
	
	<script type="text/javascript">
<!--
Gestisce il Sistema Notifiche	
-->

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
		
		function modificaTestoBig(){
			var h = document.getElementById("corpo");
			h.style.fontSize = "14pt";
		}
		
		function modificaTestoMiddle(){
			var h = document.getElementById("corpo");
			h.style.fontSize = "12pt";
		}
		
		function modificaTestoLittle(){
			var h = document.getElementById("corpo");
			h.style.fontSize = "10pt";
		}
	</script>
