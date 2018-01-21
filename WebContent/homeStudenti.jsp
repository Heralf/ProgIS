<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*" %>
<%	int id=0;
	Boolean admin=false;
	if(request.getSession().getAttribute("id")!=null){
		id=(int)request.getSession().getAttribute("id");
		admin=(boolean)request.getSession().getAttribute("admin");
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
		<div id="sezioniInfo">Informazioni generali</div>		
		<div id="domanda">Chi puo' partecipare</div>	

			Tutti gli studenti regolarmente iscritti all&rsquo;Universita', dottorandi compresi, 
			in possesso dei requisiti linguistici richiesti dall' Istituzione ospitante.
		
		<div id="domanda">Come</div>

			Attraverso un bando pubblicato annualmente dall&rsquo; Universita' consultabile sul sito di ateneo.
	
		<div id="domanda">Per quali Istituzioni</div>

			Le destinazioni variano a seconda degli Accordi stipulati e dell'&rsquo;ambito disciplinare di appartenenza dello studente.<br>
			Informazioni dettagliate sono contenute all'interno del bando. <br>
			In esso sono riportate tutte le opportunita' di studio all'estero 
			(Accordi Erasmus+, Programmi di Mobilita' internazionale verso i Paesi terzi e Accordi finalizzati al rilascio del doppio titolo).

		<div id="domanda">Quando si parte</div>

			La partenza dipende dall' organizzazione didattica presso l' Istituzione ospitante.<br>
			In linea generale si puo' partire all'inizio del I o del II semestre per corsi semestrali o all' inizio dell' anno accademico per corsi annuali.<br>
			E' importante informarsi per tempo ed essere presenti all' inizio dei corsi e/o alle eventuali giornate di orientamento programmate dall' Istituzione ospitante.
		
		<div id="domanda">Opportunita' Erasmus+</div>

			Lo studente ha a disposizione 12 mesi di mobilita' (studio e/o traineeship) per ogni ciclo di studio.<br>
			Per i corsi di laurea magistrale a ciclo unico i mesi di mobilita' sono 24, da ripartire in piu' periodi.<br>
			Pianificare l'acquisizione di competenze internazionali diventa assolutamente fondamentale.
			
		<div id="domanda">Requisiti linguistici</div>
		
			Possedere i requisiti linguistici richiesti dall'Istituzione ospitante e' condizione indispensabile per essere accettati. <br>
			Se si ha intenzione di partecipare al bando nei prossimi anni e' possibile programmare la partecipazione ai corsi di lingua 
			organizzati dal Centro Linguistico di Ateneo ed acquisire eventuali certificazioni internazionali.
		
		<div id="domanda">Come partecipare</div>
			
			La domanda di partecipazione deve essere compilata online attraverso il sito web Erasmus+.it, 
			eseguendo l accesso con le proprie credenziali di Ateneo e cliccando su "Le tue Richieste Erasmus+".<br>

			In esso sono elencate tutte le Istituzioni che hanno accordi di mobilita' per studio con l' Ateneo.

			Nella candidatura e' possibile indicare un massimo di tre Istituzioni, in ordine di preferenza, tra quelle elencate all' interno dell'ambito disciplinare di appartenenza.
			
		<div id="domanda">Valutazione del merito accademico</div>
		
			Ai fini della valutazione del merito accademico saranno presi in considerazione tutti gli esami superati con voto, sostenuti entro la data di scadenza del bando.

			Le selezioni sono effettuate dalle Commissioni Mobilita' Internazionale dei Consigli didattici di appartenenza, secondo i criteri riportati nel bando
			<br><br>
			
    		> merito accademico: media ponderata e valutazione del voto di laurea per gli iscritti a corsi di laurea magistrale e di dottorato di ricerca;
    		<br>
			
    		> colloquio obbligatorio diretto ad accertare le motivazioni e le competenze linguistiche dei candidati. 
    		Il punteggio minimo per essere collocati in graduatoria e' 10, il punteggio massimo e' 40.
			<br><br>
			N.B: Non essere presenti al colloquio comporta l'esclusione dalla procedura concorsuale.
			
		<div id="domanda">Scelta dell'Istituzione ospitante</div>
		
			Per la scelta dell'Istituzione ospitante si consiglia di: <br>
				<br>
			> consultare i siti web delle Istituzioni alle quali si e' potenzialmente interessati e reperire tutte le informazioni utili 
			(requisiti linguistici, offerta formativa, compatibilita' didattica e scadenze da rispettare);
				<br>
			> contattare gli studenti che sono gia' stati in mobilita' presso quelle determinate sedi o gli studenti ospiti dell'Ateneo;
				<br>
			> incontrare il docente tutor per eventuali suggerimenti di carattere didattico;
				<br>
			> procedere all'individuazione definitiva della o delle Istituzioni da inserire nella propria candidatura. 
			
		<div id="domanda">Borsa di studio Erasmus+</div>
			
			La borsa di studio Erasmus  per l'anno accademico 2017-2018 e' di 500,00 euro mensili. Si compone di fondi UE (230/280 euro mensili a seconda del Paese) 
			e di contributo integrativo (220/270). <br>
			
			Nell'anno accademico 2018-2019 il contributo integrativo varia a seconda della durata della mobilita'e dei crediti riportati.

			N.B.: Il contributo integrativo e' corrisposto allo studente al rientro della mobilita', previa:
			
				<br><br>
			> acquisizione di almeno 15 crediti per un semestre e 30 crediti per periodi superiori;
				<br>
			> consegna dei documenti previsti dal Programma;
				<br>
			> completamento dell'Online Linguistic Support (OLS);
				<br>
			> compilazione del questionario (EU Survey)
			
		<div id="domanda">Borsa di studio di Ateneo verso i Paesi Terzi</div>
			
			Le mobilita' per studio verso i Paesi terzi, incluso le mobilita' finalizzate al rilascio del doppio titolo sono finanziate con Fondi di Ateneo/MIUR.

			La borsa di studio e' di 500,00 euro mensili per l'anno accademico 2017-2018. Nell'anno accademico 2018-2019 sara' di 600,00 euro mensili. <br>
			Il 75% della borsa sara' erogata durante il soggiorno, il 25% al rientro della mobilita', previa acquisizione del numero minimo dei crediti 
			e consegna dei documenti previsti dal Programma.
		
		<div id="domanda">Partire per ricerca tesi</div>
			
			Non sempre le Istituzioni ospitanti accettano studenti per attivita' di ricerca tesi. Molto dipende dall'ambito disciplinare di appartenenza dello studente. 
			Onde evitare spiacevoli inconvenienti e' sempre preferibile informarsi per tempo.
		
		
		<div id="sezioniInfo">Prima di partire</div>
		
		<div id="domanda">Modulistica da trasmettere all'Istituzione ospitante</div>
		
		 	E' necessario visitare il sito internet dell'Istituzione ospitante per  verificare i requisiti linguistici da possedere 
		 	e  la modulistica da  trasmettere prima della scadenza prevista:<br><br>

			> Application Form (modulo con il quale registrarsi presso l'Istituzione ospitante entro le scadenze stabilite)<br>
			> Accommodation Form (modulo con il quale e' possibile richiedere l'alloggio presso l'Istituzione ospitante, se disponibile)<br>
			> Learning Agreement for study (modulo nel quale si indica il programma di studio da svolgere all'estero. <br><br>
			
			Consente il riconoscimento degli esami superati se certificati nel Transcript of Records a fine soggiorno. 
			E' obbligatorio per tutti gli studenti, dottorandi compresi). 
		
		<div id="domanda">Learning Agreement</div>
		
		Compilare il Learning Agreement rigorosamente tramite PC; inserire il proprio nome e cognome in alto, accanto alla voce 
		''student's name''. <br>

		Ricordarsi di inserire almeno 20 crediti per mobilita' di durata semestrale e almeno 40 crediti per durate superiori. 
		Tale regola non si applica alla Ricerca Tesi per i corsi di laurea magistrale. <br>

		Il modulo consta di due tabelle ''Table A'' e ''Table B'' .<br><br>

 		''Table A'' - bisogna elencare i corsi da seguire all'estero;<br>

		''Table B'' - bisogna elencare i corsi corrispondenti da riconoscere al rientro dalla mobilita', se certificati nel Transcript of Records 
		(Certificato di esami rilasciato dall'Istituzione ospitante alla fine della mobilita').<br><br>

		Le righe in ''Table A'' e ''Table B'' possono essere aggiunte, se necessario.<br>

		Il Learning deve essere concordato e approvato prima della partenza dallâUniversitÃ  di appartenenza (docente tutor e 
		delegato alla mobilita' internazionale del Consiglio didattico) e dall'Istituzione ospitante.
		
		<div id="domanda">Stabilire la data di partenza</div>
		
		La data della partenza e' decisa dallo studente sulla base delle informazioni ricevute o tenendo conto 
		dell'inizio dei corsi presso l'Istituzione ospitante.
		
		<div id="domanda">Prenotazione e stupula contratto finanziario</div>
		
		Contratto di mobilita': documento che sancisce l'impegno dello studente a raggiungere i risultati accademici concordati e 
		l'obbligo dell'Ateneo a riconoscere quanto realizzato. Consente, inoltre, di corrispondere allo studente l'importo relativo alla borsa di studio.<br>
		Per la stipula del contratto e' necessario prenotarsi online a partire dal 1 giugno per le partenze del primo semestre o dell'
		intero anno accademico www.unisa.it/modules/prenotazioni. <br>
		Per tale prenotazione e' assolutamente fondamentale aver rispettato 
		indicazioni e scadenze delle Universita' partner e aver stabilito la data della partenza.<br><br>

		Gli studenti che partono nel II semestre devono prenotarsi a partire dal 1 dicembre.<br><br>

		Sono necessari:<br><br>

    	> documento di riconoscimento;<br>
    	> fotocopia del codice fiscale;<br>
   		> 2 foto formato tessera;<br>
    	> Codice IBAN relativo al conto corrente postale/bancario o alla carta prepagata di cui lo studente e' intestatario o cointestatario;<br>
    	> Copia del Learning Agreement se e' stato gia' firmato dall'Istituzione ospitante. In caso contrario sara' trasmesso successivamente.<br><br>

		N.B. Dopo la stipula del contratto e' necessario inserire il codice IBAN nella''Area utente'' .
		
		<div id="domanda">Documenti da portare con se'</div>
		
		Prima della partenza e' utile avere con se':<br><br>

    		> Guida ''Avviso ai Naviganti'';<br>
    		> Attestato di partecipazione al programma Erasmus;<br>
    		> Certificato di permanenza - Allegato C (Modulo che certifichera' la durata del soggiorno presso l'Istituzione ospitante)<br>
    		> documento di identita';<br>
    		> alcune fotografie formato tessera;<br>
    		> la tessera sanitaria (tessera europea di assicurazione malattie);<br>
    		> il Learning Agreement.<br>
		
		<div id="domanda">Tasse universitarie</div>
		
		Le tasse di iscrizione devono essere pagate all'Universita' degli studi a cui si e' iscritti secondo le  regole vigenti, 
		mentre e' prevista l'esenzione dal pagamento delle tasse presso l'Istituzione ospitante.
		
		<div id="domanda">Test iniziale online linguistic support</div>
		
		All'atto della stipula del Contratto gli studenti in mobilita' Erasmus riceveranno la licenza per seguire il corso di lingua online. <br>
		L'attribuzione della licenza prevede un test iniziale e un test finale. <br>
		Il test finale consente allo studente di ricevere il saldo della borsa.
		</div>	
	</div>
</body>

</html>