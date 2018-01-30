package it.unisa.Control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.DriverManagerConnectionPool;
import it.unisa.Model.*;

@MultipartConfig
public class ErasmusControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static Account modelAcc = new Account();
	static Modulo modelMod = new Modulo();
	static Messaggio modelMes = new Messaggio();
	static Graduatoria modelGra = new Graduatoria();
	
	public ErasmusControl() {
		super();	
	}
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");
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
					modulo.setData(gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.MONTH)+1+"/"+gc.get(Calendar.YEAR));
					modulo.setDestinazione1(request.getParameter("destinazione1"));
					modulo.setDestinazione2(request.getParameter("destinazione2"));
					modulo.setDestinazione3(request.getParameter("destinazione3"));
					modulo.setAccount(modelAcc.doSearchByEmail(email));
					if(contaModuli(request))
						modelMod.creaModulo(modulo, true, false);
					dispatcher = caricaModuliDomandaUtente(request,response,dispatcher);
				}else if(action.equalsIgnoreCase("compilaDomandaErasmus")){
					int ID = (int)request.getSession().getAttribute("id");
					request.setAttribute("account",modelAcc.doSearchByID(ID));
					request.setAttribute("inviato",inviato(request));
					request.setAttribute("contaModuli",contaModuli(request));
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
					if(!inviato(request)&&contaModuli(request))
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
						messaggio.setMessaggio("La domanda da te inviata per &quot;"+ destinazione +"&quot; &egrave stata accettata. "
								+ "<br>Data Colloquio: "+ data);
					}else{
						messaggio.setTitolo("Modulo Accettato");
						messaggio.setMessaggio("Il modulo da te inviato per partecipare all'erasmus per &quot;"+ modulo.getDestinazione1() 
								+"&quot; &egrave stato accettato");
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
						messaggio.setMessaggio("Il modulo da te inviato per &quot"+ modulo.getDestinazione1() +"&quot non &egrave stato accettato");
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
					Boolean caricato = modelGra.controlloGraduatoria();
					if(caricato)
						modelGra.eliminaGraduatoria();
					caricamentoFile(request,response);
					request.setAttribute("caricato", caricato);
					dispatcher = getServletContext().getRequestDispatcher("/pubblicaGraduatorie.jsp");
				}else if(action.equalsIgnoreCase("pubblicaGraduatoria")){
					request.setAttribute("caricato", modelGra.controlloGraduatoria());
					dispatcher = getServletContext().getRequestDispatcher("/pubblicaGraduatorie.jsp");
				}
			}
			if(request.getSession().getAttribute("id")!=null){
				int IDProprietario = (int) request.getSession().getAttribute("id");
				Collection<MessaggioBean> messaggi = modelMes.prendiMessaggi(IDProprietario);
				request.setAttribute("messaggi", messaggi);
			}
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		return;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param dispatcher
	 * @return dispatcher(carica i moduli di domanda da parte dell'utente)
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
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
		for(i=0;moduli!=null&&i<moduli.size();i++){
			if(moduli.get(i).getInviaModulo())
				request.setAttribute("inviato", true);
		}
		request.setAttribute("contaModuli",contaModuli(request));
		dispatcher = getServletContext().getRequestDispatcher("/tueRichiesteErasmus.jsp");
		return dispatcher;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param dispatcher
	 * @return dispatcher(carica moduli di accettazione da parte dell'utente)
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private RequestDispatcher caricaModuliAccettazioneUtente(HttpServletRequest request, HttpServletResponse response, 
			RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), false, 
				(Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		dispatcher = getServletContext().getRequestDispatcher("/tuoiModuli.jsp");
		return dispatcher;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param dispatcher
	 * @return dispatcher(carica i moduli da parte degli admin)
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private RequestDispatcher caricaModuliDomandaAdmin(HttpServletRequest request, HttpServletResponse response, 
			RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli(0, true, (Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		dispatcher = getServletContext().getRequestDispatcher("/valutaRichiesteErasmus.jsp");
		return dispatcher;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param dispatcher
	 * @return dispatcher(carica i moduli di accettazioni da parte degli admin)
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private RequestDispatcher caricaModuliAccettazioneAdmin(HttpServletRequest request, HttpServletResponse response,RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		Collection <ModuloBean> moduliColl = modelMod.caricaModuli(0, false, (Boolean)request.getSession().getAttribute("admin"));
		request.setAttribute("moduli",moduliColl);
		dispatcher = getServletContext().getRequestDispatcher("/valutaModuliAccettazione.jsp");
		return dispatcher;
	}
	/**
	 * 
	 * @param request
	 * @return Boolean(controlla se un modulo e' stato gia inviato)
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean inviato(HttpServletRequest request) throws SQLException, ServletException, IOException {
		Boolean inviato = false;
		if(!(Boolean)request.getSession().getAttribute("admin")){
			Collection <ModuloBean> moduliColl = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), true, 
					(Boolean)request.getSession().getAttribute("admin"));
			Iterator <?> moduliIt = null;
			int i;
			ArrayList <ModuloBean> moduli = null;
			if(moduliColl==null)
				return false;
			moduliIt = moduliColl.iterator();
			while(moduliIt.hasNext()){
				if(moduli==null)
					moduli = new ArrayList <ModuloBean>();
				moduli.add((ModuloBean)moduliIt.next());
			}		
			for(i=0;moduli!=null&&i<moduli.size();i++){
				if(moduli.get(i).getInviaModulo())
					inviato = true;
			}
		}
		return inviato;
	}
	/**
	 * 
	 * @param modulo
	 * @param data
	 * @return String(insieme di destinazioni)
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private String creaDomandeAccettazione (ModuloBean modulo,String data) throws SQLException, ServletException, IOException{
		String destinazione;
		modulo.setData(data);
		modulo.getAccount().setID(modulo.getidProprietario());
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
				destinazione = destinazione.concat(", "+modulo.getDestinazione1());
			}
		}
		if(modulo.getDestinazione3()!=null){
			if(!(modulo.getDestinazione3().equalsIgnoreCase("")||modulo.getDestinazione3().equalsIgnoreCase(" "))){
				modulo.setDestinazione1(modulo.getDestinazione3());
				modelMod.creaModulo(modulo, false, false);
				destinazione= destinazione.concat(", "+modulo.getDestinazione1());
			}
		}
		return destinazione;
	}
	/**
	 * 
	 * @param data
	 * @return data(invertita)
	 */
	private String invertiData(String data){
		String data1 = "";
		data1 = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4);
		return data1;
	}
	/**
	 * 
	 * @param request
	 * @return Boolean(quantitativo di moduli = 10)
	 * @throws SQLException
	 */
	private boolean contaModuli(HttpServletRequest request) throws SQLException{
		boolean contaModuli = true;
		if(!(Boolean)request.getSession().getAttribute("admin")){
			Collection <ModuloBean> moduliColl = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), true, 
					(Boolean)request.getSession().getAttribute("admin"));
			Iterator <?> moduliIt = null;
			ArrayList <ModuloBean> moduli = null;
			if(moduliColl==null)
				return true;
			moduliIt = moduliColl.iterator();
			while(moduliIt.hasNext()){
				if(moduli==null)
					moduli = new ArrayList <ModuloBean>();
				moduli.add((ModuloBean)moduliIt.next());
			}		
			if(moduli.size()==10)
				contaModuli = false;
		}
		return contaModuli;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 */
	private void caricamentoFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("data");
        if (filePart != null) {      
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        GraduatoriaBean grad = new GraduatoriaBean();
        grad.setNomeGrad(filePart.getSubmittedFileName());
        grad.setTipoGrad(filePart.getContentType());
        grad.setPesoGrad(filePart.getSize());
        grad.setGraduatoria(inputStream);
        modelGra.caricaGraduatoria(grad);
	}
	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
