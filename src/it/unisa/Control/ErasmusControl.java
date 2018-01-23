package it.unisa.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.Model.*;

public class ErasmusControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static Account modelAcc = new Account();
	static Modulo modelMod = new Modulo();
	static Messaggio modelMes = new Messaggio();
	static Graduatoria modelGra = new Graduatoria();
	
	public ErasmusControl() {
		super();	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");;
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("redirect")) {
						dispatcher = getServletContext().getRequestDispatcher(request.getParameter("page"));
/*AccouComand*/ }else if (action.equalsIgnoreCase("login")){
					String n = request.getParameter("email");
					modelAcc.openConnection();
					AccountBean account = modelAcc.doSearchByEmail(n);
					if(account.getPostaElettronica().equals(n))
					{
						n = request.getParameter("password");
						if(n.equals(account.getPassword())){
							modelMod.openConnection();
							modelMes.openConnection();
							modelGra.openConnection();
							request.getSession().setAttribute("nome", account.getNome()+" "+account.getCognome());
							request.getSession().setAttribute("admin", account.getAdmin());
							request.getSession().setAttribute("email", account.getPostaElettronica());
							request.getSession().setAttribute("id", account.getID());
							if(account.getAdmin())
								dispatcher = getServletContext().getRequestDispatcher("/homeImpiegati.jsp");
							else
								dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");
						}else{
							modelAcc.closeConnection();
							request.setAttribute("errore",false);
							dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
						}
					}else{
						modelAcc.closeConnection();
						request.setAttribute("errore",true);
						dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
					}
				}else if (action.equalsIgnoreCase("logout")){
					request.getSession().removeAttribute("nome");
					request.getSession().removeAttribute("admin");
					request.getSession().removeAttribute("email");
					request.getSession().removeAttribute("id");
					try{
						modelAcc.closeConnection();
						modelMod.closeConnection();
						modelMes.closeConnection();
						modelGra.closeConnection();
					}catch(NullPointerException e){
						
					}
					dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");
/*ModulComand*/ }else if (action.equalsIgnoreCase("creaModulo")){
					ModuloBean modulo = new ModuloBean();
					String email = (String)(request.getSession().getAttribute("email"));
					GregorianCalendar gc = new GregorianCalendar();
					modulo.setData(gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.MONTH)+"/"+gc.get(Calendar.YEAR));
					modulo.setDestinazione1(request.getParameter("destinazione1"));
					modulo.setDestinazione2(request.getParameter("destinazione2"));
					modulo.setDestinazione3(request.getParameter("destinazione3"));
					modulo.setAccount(modelAcc.doSearchByEmail(email));
					modelMod.creaModulo(modulo, true, false);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("compilaDomandaErasmus")){
					int ID = (int)request.getSession().getAttribute("id");
					request.setAttribute("account",modelAcc.doSearchByID(ID));
					dispatcher = getServletContext().getRequestDispatcher("/compilaDomandaErasmus.jsp");
				}else if (action.equalsIgnoreCase("caricaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					ModuloBean modulo = modelMod.caricaModulo(idModulo);
					String link = request.getParameter("page");
					request.setAttribute("account",modelAcc.doSearchByID((int)request.getSession().getAttribute("id")));
					request.setAttribute("modulo", modulo);
					request.setAttribute("inviato", inviato(request));
					dispatcher = getServletContext().getRequestDispatcher(link);
				}else if(action.equalsIgnoreCase("caricaListaModuliUtente")){
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equals("aggiornaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					ModuloBean modulo = new ModuloBean();
					modulo.setDestinazione1(request.getParameter("destinazione1"));
					modulo.setDestinazione2(request.getParameter("destinazione2"));
					modulo.setDestinazione3(request.getParameter("destinazione3"));
					modelMod.aggiornaModulo(idModulo, modulo, true, false);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equals("AggiornaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					ModuloBean modulo = new ModuloBean();
					modulo.setDestinazione1(request.getParameter("destinazione1"));
					modulo.setDestinazione2(request.getParameter("destinazione2"));
					modulo.setDestinazione3(request.getParameter("destinazione3"));
					modelMod.aggiornaModulo(idModulo, modulo, true, true);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equals("inviaModulo")){
					ModuloBean modulo = new ModuloBean();
					String email = (String)(request.getSession().getAttribute("email"));
					GregorianCalendar gc = new GregorianCalendar();
					modulo.setData(gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.MONTH)+1+"/"+gc.get(Calendar.YEAR));
					modulo.setDestinazione1(request.getParameter("destinazione1"));
					modulo.setDestinazione2(request.getParameter("destinazione2"));
					modulo.setDestinazione3(request.getParameter("destinazione3"));
					modulo.setAccount(modelAcc.doSearchByEmail(email));
					modelMod.creaModulo(modulo, true, true);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equals("InviaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.inviaModulo(idModulo);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("cancellaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.eliminaModulo(idModulo);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("caricaListaAccettazioneUtente")){
					dispatcher = caricaModuliAccettazioneUtente(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("caricaListaModuliAdmin")){
					dispatcher = caricaModuliDomandaAdmin(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("confermaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.confermaModulo(idModulo);
					ModuloBean modulo = modelMod.caricaModulo(idModulo);
					MessaggioBean messaggio = new MessaggioBean();
					String destinazione="";
					if(modulo.getDomanda()){
						String data = request.getParameter("dataColloquio");
						data = invertiData(data);
						destinazione = creaDomandeAccettazione(modulo,data);
					}
					messaggio.setIDProprietario(modulo.getidProprietario());
					if(modulo.getDomanda()){
						messaggio.setTitolo("Domanda Accettata");
						String data = request.getParameter("dataColloquio");
						data = invertiData(data);
						messaggio.setMessaggio("La domanda da te inviata per "+ destinazione +" &egrave stata accettata. "
								+ "<br>Data Colloquio: "+ data);
					}else{
						messaggio.setTitolo("Modulo Accettato");
						messaggio.setMessaggio("Il modulo da te inviato per partecipare all'erasmus per "+ modulo.getDestinazione1() 
								+" &egrave stato accettato");
					}
					modelMes.creaMessaggio(messaggio);
					if(modulo.getDomanda())
						dispatcher = caricaModuliDomandaAdmin(request,response,dispatcher);
					else
						dispatcher = caricaModuliAccettazioneAdmin(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("rifiutoModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.rifiutoModulo(idModulo);
					ModuloBean modulo = modelMod.caricaModulo(idModulo);
					MessaggioBean messaggio = new MessaggioBean();
					messaggio.setIDProprietario(modulo.getidProprietario());
					if(modulo.getDomanda()){
						messaggio.setTitolo("Errore Domanda");
						messaggio.setMessaggio("La domanda di partecipazione Erasmus da te inviata non &egrave stata accettata");
					}else{
						messaggio.setTitolo("Errore Modulo");
						messaggio.setMessaggio("Il modulo da te inviato per "+ modulo.getDestinazione1() +" non &egrave stato accettato");
					}
					modelMes.creaMessaggio(messaggio);
					if(modulo.getDomanda())
						dispatcher = caricaModuliDomandaAdmin(request,response,dispatcher);
					else
						dispatcher = caricaModuliAccettazioneAdmin(request,response,dispatcher);
				}else if (action.equalsIgnoreCase("inviaAccettazione")){
					GregorianCalendar gc = new GregorianCalendar();
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					String data = gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.MONTH)+1+"/"+gc.get(Calendar.YEAR);
					modelMod.aggiungiCarta(idModulo,data, request.getParameter("CartaIdentita"));
					dispatcher = caricaModuliAccettazioneUtente(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("caricaListaAccettazioneAdmin")){
					dispatcher = caricaModuliAccettazioneAdmin(request,response,dispatcher);
/*GradComand*/  }else if (action.equalsIgnoreCase("caricaGraduatoria")){
					GraduatoriaBean graduatoria = new GraduatoriaBean();
					graduatoria.setGraduatoria(Long.parseLong(request.getParameter("graduatoria")));
					graduatoria.setGraduatoriaPubblica(Boolean.parseBoolean(request.getParameter("pubblica")));
					modelGra.caricaGraduatoria(graduatoria);
					//reindirizzamento pagina
				}else if (action.equalsIgnoreCase("scaricaGraduatoria")){
					GraduatoriaBean graduatoria = modelGra.scaricaGraduatoria();
					request.setAttribute("graduatoria", graduatoria);
					//reindirizzamento pagina
				}else if (action.equalsIgnoreCase("controlloGraduatoria")){
					GraduatoriaBean graduatoria = modelGra.controlloGraduatoria();
					request.setAttribute("graduatoria", graduatoria);
					//reindirizzamento pagina
				}else if (action.equalsIgnoreCase("cancellaGraduatoria")){
					modelGra.cancellaGraduatoria();
					//reindirizzamento pagina
				}
			}
			try{
				if(request.getSession().getAttribute("id")!=null){
					int IDProprietario = (int) request.getSession().getAttribute("id");
					Collection<MessaggioBean> messaggi = modelMes.prendiMessaggi(IDProprietario);
					request.setAttribute("messaggi", messaggi);
				}
				dispatcher.forward(request, response);
			} catch (IllegalStateException e){
				String link = request.getParameter("page");
				if(link!=null)
					dispatcher = getServletContext().getRequestDispatcher(link);
				else if((Boolean)(request.getSession().getAttribute("admin")))
						dispatcher = getServletContext().getRequestDispatcher("/homeImpiegato.jsp");
					else
						dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		return;
	}

	private RequestDispatcher caricaModuliDomandaUtente(HttpServletRequest request, HttpServletResponse response,
			RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), true, 
				(Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		Iterator <?> moduliIt = null;
		int i;
		ArrayList <ModuloBean> moduli = null;
		if (request.getAttribute("moduli")!=null){ 
			moduliIt = moduliColl.iterator();
			while(moduliIt.hasNext()){
				if(moduli==null)
					moduli = new ArrayList <ModuloBean>();
				moduli.add((ModuloBean)moduliIt.next());
			}		
		}
		for(i=0;i<moduli.size();i++){
			if(moduli.get(i).getInviaModulo())
				request.setAttribute("inviato", true);
		}
		dispatcher = getServletContext().getRequestDispatcher("/tueRichiesteErasmus.jsp");
		return dispatcher;
	}
	
	private RequestDispatcher caricaModuliAccettazioneUtente(HttpServletRequest request, HttpServletResponse response, 
			RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), false, 
				(Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		dispatcher = getServletContext().getRequestDispatcher("/tuoiModuli.jsp");
		return dispatcher;
	}
	
	private RequestDispatcher caricaModuliDomandaAdmin(HttpServletRequest request, HttpServletResponse response, 
			RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli(0, true, (Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		dispatcher = getServletContext().getRequestDispatcher("/valutaRichiesteErasmus.jsp");
		return dispatcher;
	}
	
	private RequestDispatcher caricaModuliAccettazioneAdmin(HttpServletRequest request, HttpServletResponse response,RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli(0, false, (Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		dispatcher = getServletContext().getRequestDispatcher("/valutaModuliAccettazione.jsp");
		return dispatcher;
	}
	
	private boolean inviato(HttpServletRequest request) throws SQLException, ServletException, IOException {
		Boolean inviato = false;
		if(!(Boolean)request.getSession().getAttribute("admin")){
			Collection <ModuloBean> moduliColl = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), true, 
					(Boolean)request.getSession().getAttribute("admin"));
			Iterator <?> moduliIt = null;
			int i;
			ArrayList <ModuloBean> moduli = null;
			moduliIt = moduliColl.iterator();
			while(moduliIt.hasNext()){
				if(moduli==null)
					moduli = new ArrayList <ModuloBean>();
				moduli.add((ModuloBean)moduliIt.next());
			}		
			for(i=0;i<moduli.size();i++){
				if(moduli.get(i).getInviaModulo())
					inviato = true;
			}
		}
		return inviato;
	}
	
	private String creaDomandeAccettazione (ModuloBean modulo,String data) throws SQLException, ServletException, IOException{
		String destinazione;
		modulo.setData(data);
		if(modulo.getDomanda()){
			modelMod.creaModulo(modulo, false, false);
		}else{
			modelMod.confermaModulo(modulo.getID());
		}
		destinazione = modulo.getDestinazione1(); 
		if(modulo.getDestinazione2()!=null){
			if(!(modulo.getDestinazione2().equalsIgnoreCase("")||modulo.getDestinazione2().equalsIgnoreCase(" "))){
				modulo.setDestinazione1(modulo.getDestinazione2());
				modelMod.creaModulo(modulo, false, false);
				destinazione.concat(", "+ modulo.getDestinazione1());
			}
		}
		if(modulo.getDestinazione3()!=null){
			if(!(modulo.getDestinazione3().equalsIgnoreCase("")||modulo.getDestinazione3().equalsIgnoreCase(" "))){
				modulo.setDestinazione1(modulo.getDestinazione3());
				modelMod.creaModulo(modulo, false, false);
				destinazione.concat(", "+ modulo.getDestinazione1());
			}
		}
		return destinazione;
	}
	
	private String invertiData(String data){
		String data1 = "";
		data1 = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4);
		return data1;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
