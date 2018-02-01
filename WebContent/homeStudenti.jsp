<!--
Pagina per lo studente; Home page per reindirizzarsi nelle varie sezioni per compilare moduli o controllare le notifiche.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" %>
<%	int id=0;
	Boolean admin=false;
	if(request.getSession().getAttribute("id")!=null){
		id=(int)request.getSession().getAttribute("id");
		admin=(boolean)request.getSession().getAttribute("admin");
}	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<link rel="icon" href="immagini/favicon.png" type="image/png"/>
		<link rel="stylesheet" type="text/css" href="css/graphic.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<title> Erasmus+ </title>	
	</head>
	<body>	
		<% if(id==0){ %>
		<%@ include file="fragments/sidebar.jsp" %>	
		<% }else{ %>
		<%@ include file="fragments/sidebarStudente.jsp" %>
		<% } %>
		<div id= "corpo">		
			<div id="titolo">
				Benvenuto su Erasmus+	
			</div>	
			<div id="contenuto">	
				<div id="sezioniInfo">
					Informazioni generali
				</div>		
				
				<div id="domanda">
					Chi pu&ograve; partecipare
				</div>	
					Tutti gli studenti regolarmente iscritti all&rsquo;Universit&agrave;, dottorandi compresi, 
					in possesso dei requisiti linguistici richiesti dall' Istituzione ospitante.
				
				<div id="domanda">
					Come
				</div>
				Attraverso un bando pubblicato annualmente dall&rsquo; Universit&agrave; consultabile sul sito di ateneo.
				
				<div id="domanda">
					Per quali Istituzioni
				</div>
				Le destinazioni variano a seconda degli Accordi stipulati e dell&rsquo;ambito disciplinare di appartenenza dello 
				studente. <br>
				Informazioni dettagliate sono contenute all&rsquo;interno del bando. <br>
				In esso sono riportate tutte le opportunit&agrave; di studio all&rsquo;estero (Accordi Erasmus+, Programmi di 
				Mobilit&agrave; internazionale verso i Paesi terzi e Accordi finalizzati al rilascio del doppio titolo).
				
				<div id="domanda">
					Quando si parte
				</div>
				La partenza dipende dall&rsquo;organizzazione didattica presso l&rsquo;Istituzione ospitante. <br>
				In linea generale si pu&ograve; partire all'inizio del I o del II semestre per corsi semestrali o all&rsquo;inizio 
				dell&rsquo;anno accademico per corsi annuali. <br>
				&Egrave; importante informarsi per tempo ed essere presenti all&rsquo;inizio dei corsi e/o alle eventuali giornate di 
				orientamento programmate dall&rsquo;Istituzione ospitante.
				
				<div id="domanda">
					Opportunit&agrave; Erasmus+
				</div>
				Lo studente ha a disposizione 12 mesi di mobilit&agrave; (studio e/o traineeship) per ogni ciclo di studio. <br>
				Per i corsi di laurea magistrale a ciclo unico i mesi di mobilit&agrave; sono 24, da ripartire in pi&ugrave; periodi. 
				<br>
				Pianificare l&rsquo;acquisizione di competenze internazionali diventa assolutamente fondamentale.
				
				<div id="domanda">
					Requisiti linguistici
				</div>
				Possedere i requisiti linguistici richiesti dall&rsquo;Istituzione ospitante &egrave; condizione indispensabile per 
				essere accettati. <br>
				Se si ha intenzione di partecipare al bando nei prossimi anni &egrave; possibile programmare la partecipazione ai corsi 
				di lingua organizzati dal Centro Linguistico di Ateneo ed acquisire eventuali certificazioni internazionali.
				
				<div id="domanda">
					Come partecipare
				</div>
				La domanda di partecipazione deve essere compilata online attraverso il sito web Erasmus+, 
				eseguendo l&rsquo;accesso con le proprie credenziali di Ateneo e cliccando su &quot;Le tue Richieste Erasmus+&quot;.<br>
				In esso sono elencate tutte le Istituzioni che hanno accordi di mobilit&agrave; per studio con l&rsquo;Ateneo.
				Nella candidatura &egrave; possibile indicare un massimo di tre Istituzioni, in ordine di preferenza, tra quelle elencate 
				all&rsquo;interno dell&rsquo;ambito disciplinare di appartenenza.	
				
				<div id="domanda">
					Valutazione del merito accademico
				</div>
				Ai fini della valutazione del merito accademico saranno presi in considerazione tutti gli esami superati con voto, 
				sostenuti entro la data di scadenza del bando.
				Le selezioni sono effettuate dalle Commissioni Mobilit&agrave; Internazionale dei Consigli didattici di appartenenza, 
				secondo i criteri riportati nel bando
				<br> <br>
				&gt; merito accademico: media ponderata e valutazione del voto di laurea per gli iscritti a corsi di laurea magistrale e 
				di dottorato di ricerca;
    			<br>
				&gt; colloquio obbligatorio diretto ad accertare le motivazioni e le competenze linguistiche dei candidati. 
    			Il punteggio minimo per essere collocati in graduatoria &egrave; 10, il punteggio massimo &egrave; 40.
				<br> <br>
				N.B: Non essere presenti al colloquio comporta l&rsquo;esclusione dalla procedura concorsuale.
				
				<div id="domanda"> 
					Scelta dell&rsquo;Istituzione ospitante
				</div>
				Per la scelta dell&rsquo;Istituzione ospitante si consiglia di: 
				<br> <br>
				&gt; consultare i siti web delle Istituzioni alle quali si &egrave; potenzialmente interessati e reperire tutte le 
				informazioni utili (requisiti linguistici, offerta formativa, compatibilit&agrave; didattica e scadenze da rispettare);
				<br>
				&gt; contattare gli studenti che sono gi&agrave; stati in mobilit&agrave; presso quelle determinate sedi o gli studenti 
				ospiti dell&rsquo;Ateneo;
				<br>
				&gt; incontrare il docente tutor per eventuali suggerimenti di carattere didattico;
				<br>
				&gt; procedere all&rsquo;individuazione definitiva della o delle Istituzioni da inserire nella propria candidatura. 
				
				<div id="domanda">
					Borsa di studio Erasmus+
				</div>
				La borsa di studio Erasmus per l&rsquo;anno accademico 2017-2018 &agrave; di 500,00 euro mensili. 
				Si compone di fondi UE (230/280 euro mensili a seconda del Paese) e di contributo integrativo (220/270). <br>
				Nell&rsquo;anno accademico 2018&ndash;2019 il contributo integrativo varia a seconda della durata della mobilit&agrave; 
				e dei crediti riportati. N.B.: Il contributo integrativo &egrave; corrisposto allo studente al rientro della 
				mobilit&agrave;, previa:
				<br> <br>
				&gt; acquisizione di almeno 15 crediti per un semestre e 30 crediti per periodi superiori;
				<br>
				&gt; consegna dei documenti previsti dal Programma;
				<br>
				&gt; completamento dell&rsquo;Online Linguistic Support (OLS);
				<br>
				&gt; compilazione del questionario (EU Survey)			
				
				<div id="domanda">
					Borsa di studio di Ateneo verso i Paesi Terzi
				</div>
				Le mobilit&agrave; per studio verso i Paesi terzi, incluso le mobilit&agrave; finalizzate al rilascio del doppio titolo
				sono finanziate con Fondi di Ateneo/MIUR.
				La borsa di studio &egrave; di 500,00 euro mensili per l&rsquo;anno accademico 2017&ndash;2018. Nell&rsquo;anno 
				accademico 2018&ndash;2019 sar&agrave; di 600,00 euro mensili. <br>
				Il 75% della borsa sar&agrave; erogata durante il soggiorno, il 25% al rientro della mobilit&agrave;, previa acquisizione
				del numero minimo dei crediti e consegna dei documenti previsti dal Programma.
				
				<div id="domanda">
					Partire per ricerca tesi
				</div>
				Non sempre le Istituzioni ospitanti accettano studenti per attivit&agrave; di ricerca tesi. Molto dipende 
				dall&rsquo;ambito disciplinare di appartenenza dello studente. 
				Onde evitare spiacevoli inconvenienti &egrave; sempre preferibile informarsi per tempo.
		
				<div id="sezioniInfo">
					Prima di partire
				</div>
		
				<div id="domanda">
					Modulistica da trasmettere all&rsquo;Istituzione ospitante
				</div>
		 		&Egrave; necessario visitare il sito internet dell&rsquo;Istituzione ospitante per verificare i requisiti linguistici 
		 		da possedere e la modulistica da  trasmettere prima della scadenza prevista: 
		 		<br> <br>
				&gt; Application Form (modulo con il quale registrarsi presso l&rsquo;Istituzione ospitante entro le scadenze stabilite)
				<br>
				&gt; Accommodation Form (modulo con il quale &egrave; possibile richiedere l&rsquo;alloggio presso l&rsquo;Istituzione 
				ospitante, se disponibile)
				<br>
				&gt; Learning Agreement for study (modulo nel quale si indica il programma di studio da svolgere all&rsquo;estero. 
				<br> <br>		
				Consente il riconoscimento degli esami superati se certificati nel Transcript of Records a fine soggiorno. 
				&Egrave; obbligatorio per tutti gli studenti, dottorandi compresi). 
		
				<div id="domanda">
					Learning Agreement
				</div>	
				Compilare il Learning Agreement rigorosamente tramite PC; inserire il proprio nome e cognome in alto, accanto alla voce 
				&quot;student&rsquo;s name&quot;. 
				<br>
				Ricordarsi di inserire almeno 20 crediti per mobilit&agrave; di durata semestrale e almeno 40 crediti per durate 
				superiori. 
				Tale regola non si applica alla Ricerca Tesi per i corsi di laurea magistrale. 
				<br>
				Il modulo consta di due tabelle &quot;Table A&quot; e &quot;Table B&quot;.
				<br> <br>
 				&quot;Table A&quot; &ndash; bisogna elencare i corsi da seguire all&rsquo;estero;
 				<br>
				&quot;Table B&quot; &ndash; bisogna elencare i corsi corrispondenti da riconoscere al rientro dalla mobilit&agrave;, se 
				certificati nel Transcript of Records (Certificato di esami rilasciato dall&rsquo;Istituzione ospitante alla fine della 
				mobilit&agrave;).
				<br> <br>
				Le righe in &quot;Table A&quot; e &quot;Table B&quot; possono essere aggiunte, se necessario.
				<br>
				Il Learning deve essere concordato e approvato prima della partenza dall&rsquo;Universit&agrave; di appartenenza 
				(docente tutor e delegato alla mobilit&agrave; internazionale del Consiglio didattico) e dall&rsquo;Istituzione 
				ospitante.
		
				<div id="domanda">
					Stabilire la data di partenza
				</div>
				La data della partenza &egrave; decisa dallo studente sulla base delle informazioni ricevute o tenendo conto 
				dell&rsquo;inizio dei corsi presso l&rsquo;Istituzione ospitante.
		
				<div id="domanda">
					Prenotazione e stipula contratto finanziario
				</div>
				Contratto di mobilit&agrave;: documento che sancisce l&rsquo;impegno dello studente a raggiungere i risultati accademici
				concordati e l&rsquo;obbligo dell&rsquo;Ateneo a riconoscere quanto realizzato. Consente, inoltre, di corrispondere allo
				studente l&rsquo;importo relativo alla borsa di studio.
				<br>
				Per la stipula del contratto &egrave; necessario prenotarsi online a partire dal 1 giugno per le partenze del primo 
				semestre o dell&rsquo;intero anno accademico www.unisa.it/modules/prenotazioni. 
				<br>
				Per tale prenotazione &egrave; assolutamente fondamentale aver rispettato 
				indicazioni e scadenze delle Universit&agrave; partner e aver stabilito la data della partenza.
				<br> <br>
				Gli studenti che partono nel II semestre devono prenotarsi a partire dal 1 dicembre.
				<br> <br>
				Sono necessari:
				<br> <br>
    			&gt; documento di riconoscimento;
    			<br>
    			&gt; fotocopia del codice fiscale;
    			<br>
   				&gt; 2 foto formato tessera;
   				<br>
    			&gt; Codice IBAN relativo al conto corrente postale/bancario o alla carta prepagata di cui lo studente &egrave; 
    			intestatario o cointestatario;
    			<br>
    			&gt; Copia del Learning Agreement se &egrave; stato gi&agrave; firmato dall&rsquo;Istituzione ospitante. In caso 
    			contrario sar&agrave; trasmesso successivamente.
    			<br> <br>
				N.B. Dopo la stipula del contratto &egrave; necessario inserire il codice IBAN nella &quot;Area utente&quot;.
		
				<div id="domanda">
					Documenti da portare con s&eacute;
				</div>
				Prima della partenza &egrave; utile avere con s&eacute;:
				<br> <br>
    			&gt; Guida &quot;Avviso ai Naviganti&quot;;
    			<br>
    			&gt; Attestato di partecipazione al programma Erasmus;
    			<br>
    			&gt; Certificato di permanenza &ndash; Allegato C (Modulo che certificher&agrave; la durata del soggiorno presso 
    			l&rsquo;Istituzione ospitante)
    			<br>
    			> documento di identit&agrave;;
    			<br>
    			> alcune fotografie formato tessera;
    			<br>
    			> la tessera sanitaria (tessera europea di assicurazione malattie);
    			<br>
    			> il Learning Agreement.
    			<br>
		
				<div id="domanda">
					Tasse universitarie
				</div>
				Le tasse di iscrizione devono essere pagate all&rsquo;Universit&agrave; degli studi a cui si &egrave; iscritti secondo 
				le  regole vigenti, mentre &egrave; prevista l&rsquo;esenzione dal pagamento delle tasse presso l&rsquo;Istituzione 
				ospitante.
		
				<div id="domanda">
					Test iniziale online linguistic support
				</div>
		
				All&rsquo;atto della stipula del Contratto gli studenti in mobilit&agrave; Erasmus riceveranno la licenza per seguire 
				il corso di lingua online. 
				<br>
				L&rsquo;attribuzione della licenza prevede un test iniziale e un test finale. 
				<br>
				Il test finale consente allo studente di ricevere il saldo della borsa.
			</div>	
		</div>
	</body>
</html>