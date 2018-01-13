<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" %>
<% if(request.getParameter("admin")!=null&&Boolean.parseBoolean(request.getParameter("admin"))){ %>
<body onload="window.location.href = 'product?action=redirect&page=/homeStudenti.jsp';">
<% } %>
<div id="ColonnaSx">
	<a href="homeStudenti.jsp"><img id="logo" src="immagini/logo.png" alt="Mia Immagine" height="100"></a>
	<div id="benvenuto"> Benvenuto <%= (String)request.getSession().getAttribute("nome") %> </div>
		<a href="product?action=logout"><button id="tastoAccediLaterale" type="submit" name="action" value="logout"> <i class="fa fa-sign-in" style="font-size:28px;color:#FF6633; margin-right:3px;margin-left:5px;vertical-align: middle;" aria-hidden="true"> </i> Esci
    	</button>
    	</a>
        <ul>
   			<li id="LeftText"> <i class="fa fa-home" style="font-size:26px;color:#FF6633; margin-top: -5px;margin-right:3px;vertical-align: middle;" aria-hidden="true"> </i> <a href="homeStudenti.jsp"> Home</a> </li>
			<li id="LeftText"> <i class="fa fa-gavel" style="font-size:26px;color:#FF6633; margin-top: -5px;margin-right:3px;vertical-align: middle;" aria-hidden="true"></i> <a href="">Valuta richieste Erasmus</a> </li>
			<li id="LeftText"> <i class="fa fa-star-half-o" style="font-size:26px;color:#FF6633;margin-top: -5px; margin-right:3px;vertical-align: middle;" aria-hidden="true"></i> <a href="">Valuta moduli accettazione</a> </li>
			<li id="LeftText"> <i class="fa fa-share-alt" style="font-size:26px;color:#FF6633; margin-top: -5px;margin-right:4px;vertical-align: middle;" aria-hidden="true"></i> <a href="" >Pubblica graduatorie</a> </li>  
		</ul> 			 	
</div>					
<div id="rigaCentrale">	
<a href=""homeStudenti.jsp""><img id="logoPortrait" src="immagini/logo.png" alt="Mia Immagine" height="130" width="350"></a>    
<div id="benvenuto"> Benvenuto <%= (String)request.getSession().getAttribute("nome") %> </div> 	
			<a href="product?action=logout">
				<button id="tastoAccediPortrait" type="submit" name="action" value="logout"> <i class="fa fa-sign-in" style="font-size:29px;color:#FF6633; margin-right:3px;margin-left:5px;vertical-align: middle;" aria-hidden="true"> </i> Esci     	
				</button>				
			</a>
			<li id="OrizText"> <i class="fa fa-home" style="font-size:26px;color:#FF6633; margin-top: -3px;margin-right:3px;vertical-align: middle;" aria-hidden="true"> </i> <a href="homeStudenti.jsp"> Home</a> </li>
			<li id="OrizText"> <i class="fa fa-gavel" style="font-size:26px;color:#FF6633;margin-top: -3px; margin-right:3px;vertical-align: middle;" aria-hidden="true"></i> <a href="">Valuta richieste Erasmus</a> </li>
			<li id="OrizText"> <i class="fa fa-star-half-o" style="font-size:25px;color:#FF6633;margin-top: -3px; margin-right:3px;vertical-align: middle;" aria-hidden="true"></i> <a href="">Valuta moduli accettazione</a> </li>
			<li id="OrizText"> <i class="fa fa-share-alt" style="font-size:25px;color:#FF6633; margin-top: -3px;margin-right:4px;vertical-align: middle;" aria-hidden="true"></i> <a href="" >Pubblica graduatorie</a> </li>  				  
</div>
