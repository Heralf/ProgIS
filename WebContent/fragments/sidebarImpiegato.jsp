<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, it.unisa.Model.*" %>
	
	<div id="ColonnaSx">
		<a href="homeImpiegati.jsp"> <img id="logo" src="immagini/logo.png" alt="Mia Immagine" height="100"> </a>
		<div id="benvenuto"> Benvenuto <br> <%= (String)request.getSession().getAttribute("nome") %> 
			<button id="tastoMessaggi"  onclick="myFunction()" style ="margin-left:0px;"> 
				<i class="fa fa-envelope" style="font-size:34px; color:#BA68C8; margin-top:-6px; vertical-align:middle;"> </i> 
			</button>  			
		</div>
		<div id="boxMessaggi" style="display:none">
			<div id="intestazione"> Le tue notifiche </div>
		</div>
		<a href="control?action=logout">
			<button id="tastoAccediLaterale" > 
				<i class="fa fa-sign-in" style="font-size:28px; color:#FF6633; margin-right:3px; margin-left:5px; vertical-align:middle;"
				   aria-hidden="true"> </i> Esci
     		</button>
     	</a>
        <ul>
            <li id="LeftText"> 
            	<i class="fa fa-home" style="font-size:26.5px; color:red; margin-top:-5px; margin-right:3px; vertical-align:middle;" 
            	   aria-hidden="true"> </i> 
            	   <a href="control?action=redirect&page=/homeImpiegati.jsp"> Home</a> 
           	</li>
			<li id="LeftText"> 
				<i class="fa fa-gavel" style="font-size:26px; color:#FF6633; margin-top:-5px; margin-right:3px; vertical-align:middle;"
				   aria-hidden="true"> </i> 
				<a href="control?action=caricaListaModuliAdmin"> Valuta richieste Erasmus </a> 
			</li>
			<li id="LeftText"> 
				<i class="fa fa-star-half-o" style="font-size:26.5px; color:#00BCD4; margin-top:-5px; margin-right:3px; 
				   vertical-align:middle;" aria-hidden="true"> </i> 
				<a href="control?action=caricaListaAccettazioneAdmin"> Valuta moduli accettazione </a> 
			</li>
			<li id="LeftText"> 
				<i class="fa fa-share-alt" style="font-size:26px; color:#3399FF; margin-top:-5px; margin-right:4px; 
				   vertical-align:middle;" aria-hidden="true"> </i> 
				<a href="control?action=redirect&page=/pubblicaGraduatorie.jsp"> Pubblica graduatorie </a> 
			</li>  	
		</ul> 			
 		<p id="suggerimento"> Gestisci Grandezza Caratteri
 		<button id="tastoModificaFont" onclick="modificaTestoLittle()"> 
 			<i class="fa fa-font" style="font-size:20px; color:black; vertical-align: middle;"> </i> 
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
		<a href=""homeStudenti.jsp"">
			<img id="logoPortrait" src="immagini/logo.png" alt="Mia Immagine" height="130" width="350">
		</a>  
 	<div id="benvenuto"> Benvenuto <br> <%= (String)request.getSession().getAttribute("nome") %> 
		<button id="tastoMessaggi" onclick="myFunction()"> 
			<i class="fa fa-envelope" style="font-size:34px; color:#BA68C8; margin-top:-6px; vertical-align:middle;"> </i> 
		</button>  
	</div>
	<div id="boxMessaggi1" style="display:none">
		<div id= "intestazione"> Le tue notifiche </div>
	</div>
 	<a href="control?action=logout">
 		<button id="tastoAccediPortrait"> 
 			<i class="fa fa-sign-in" style="font-size:29px; color:#FF6633; margin-right:3px; margin-left:5px; vertical-align:middle;" 
 			   aria-hidden="true"> </i> Esci 	
    	</button>
    </a>	
		<li id="OrizText"> 
			<i class="fa fa-home" style="font-size:27px; color:red; margin-top:-4px; margin-right:3.5px; vertical-align:middle;" 
			   aria-hidden="true"> </i> 
			<a href="control?action=redirect&page=/homeImpiegati.jsp"> Home </a> 
		</li>
		<li id="OrizText"> 
			<i class="fa fa-gavel" style="font-size:27px; color:#FF6633; margin-top:-4px; margin-right:3.5px; vertical-align:middle;" 
			   aria-hidden="true"> </i> 
			<a href="control?action=caricaListaModuliAdmin"> Valuta richieste Erasmus </a> 
		</li>
		<li id="OrizText"> 
			<i class="fa fa-star-half-o" style="font-size:27px; color:#00BCD4; margin-top:-4px; margin-right:3.5px; 
			   vertical-align:middle;" aria-hidden="true"> </i> 
			<a href="control?action=caricaListaAccettazioneAdmin"> Valuta moduli accettazione </a> 
		</li>
		<li id="OrizText"> 
			<i class="fa fa-share-alt" style="font-size:27px; color:#3399FF; margin-top:-4px; margin-right:3.5px; 
		       vertical-align:middle;" aria-hidden="true"> </i> 
		    <a href="control?action=redirect&page=/pubblicaGraduatorie.jsp" > Pubblica graduatorie </a> 
		</li>  
		<p id="suggerimento1"> Gestisci Grandezza Caratteri
 		<button id="tastoModificaFont1" onclick="modificaTestoLittle()"> 
 			<i class="fa fa-font" style="font-size:20px; color:black; vertical-align:middle;"> </i> 
 		</button>
 		<button id="tastoModificaFont1" onclick="modificaTestoMiddle()"> 
 			<i class="fa fa-font" style="font-size:25px; color:black; margin-top:-5px; vertical-align:middle;"> </i> 
 		</button>
 		<button id="tastoModificaFont1" onclick="modificaTestoBig()"> 
 			<i class="fa fa-font" style="font-size:30px; color:black; margin-top:-10px; vertical-align:middle;"> </i> 
 		</button> 
	</div>
	<script type="text/javascript">
<!--
		
//-->
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
			h.style.fontSize = "16pt";
		}
		
		function modificaTestoMiddle(){
			var h = document.getElementById("corpo");
			h.style.fontSize = "13pt";
		}
		
		function modificaTestoLittle(){
			var h = document.getElementById("corpo");
			h.style.fontSize = "10pt";
		}
	</script>