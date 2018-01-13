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

public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Account modelAcc = new Account();
	
	static Modulo modelMod = new Modulo();
	
	static Messaggio modelMes = new Messaggio();
	
	static Graduatoria modelGra = new Graduatoria();
	
	public ProductControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String action = request.getParameter("action");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");
		//String i = request.getParameter("Number");
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("redirect")) {
						dispatcher = getServletContext().getRequestDispatcher(request.getParameter("page"));
/*AccouComand*/ }else if (action.equalsIgnoreCase("login")){
					String n = request.getParameter("email");
					modelAcc.openConnection();
					AccountBean account = modelAcc.doSearchByEmail(n);
					n = request.getParameter("password");
					if(n.equals(account.getPassword())){
						modelMod.openConnection();
						modelMes.openConnection();
						modelGra.openConnection();
						request.getSession().setAttribute("nome", account.getNome()+" "+account.getCognome());
						request.getSession().setAttribute("admin", account.getAdmin());
						request.getSession().setAttribute("email", account.getPostaElettronica());
						request.getSession().setAttribute("id", account.getID());
						dispatcher = getServletContext().getRequestDispatcher("/homeStudenti.jsp");
					}else{
						modelAcc.closeConnection();
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
					Boolean domanda = Boolean.parseBoolean(request.getParameter("domanda"));
					GregorianCalendar gc = new GregorianCalendar();
					modulo.setData(gc.get(Calendar.DAY_OF_MONTH)+"/"+gc.get(Calendar.MONTH)+"/"+gc.get(Calendar.YEAR));
					if(domanda){
						modulo.setDestinazione1(request.getParameter("Destinazione1"));
						modulo.setDestinazione2(request.getParameter("Destinazione2"));
						modulo.setDestinazione3(request.getParameter("Destinazione3"));
					}else{
						modulo.setCartaIdentita(request.getParameter("CartaIdentita"));
					}
					modulo.setAccount(modelAcc.doSearchByEmail(email));
					modelMod.creaModulo(modulo, domanda);
					//redirect alla lista dei moduli
				}else if (action.equalsIgnoreCase("caricaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					ModuloBean modulo = modelMod.caricaModulo(idModulo);
					request.setAttribute("modulo", modulo);
					//redirect alla pagina per visualizzre il modulo
				}else if(action.equalsIgnoreCase("caricaListaModuliUtente")){
					Boolean domanda = Boolean.parseBoolean(request.getParameter("domanda"));
					Collection <ModuloBean> moduli = modelMod.caricaModuli((int)request.getSession().getAttribute("id"), domanda);
					request.setAttribute("moduli",moduli);
					if(domanda)
						dispatcher = getServletContext().getRequestDispatcher("/tueRichiesteErasmus.jsp");
					else
						dispatcher = getServletContext().getRequestDispatcher("/tuoiModuli.jsp");
				}else if(action.equalsIgnoreCase("aggiornaModulo")){
					Boolean domanda = Boolean.parseBoolean(request.getParameter("domanda"));
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					ModuloBean modulo = new ModuloBean();
					if(domanda){
						modulo.setDestinazione1(request.getParameter("Destinazione1"));
						modulo.setDestinazione2(request.getParameter("Destinazione2"));
						modulo.setDestinazione3(request.getParameter("Destinazione3"));
						modulo.getAccount().setNumeroTelefonico(request.getParameter("NumeroTelefonico"));
					}else
						modulo.setCartaIdentita(request.getParameter("CartaIdentita"));
					modelMod.aggiornaModulo(idModulo, modulo, domanda);
					//redirect alla pagina per visualizzare i moduli
				}else if(action.equalsIgnoreCase("inviaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.inviaModulo(idModulo);
					//redirect alla pagian dei moduli
				}else if(action.equalsIgnoreCase("confermaModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.confermaModulo(idModulo);
					//invio messaggio all'utente che indichi che e stato accettato il modulo
					//redirect alla pagina dei moduli
				}else if(action.equalsIgnoreCase("rifiutoModulo")){
					int idModulo = Integer.parseInt(request.getParameter("idModulo"));
					modelMod.rifiutoModulo(idModulo);
					//invio messaggio all'utente che indichi che e stato rifiuto il modulo
					//redirect alla pagina dei moduli
/*MessComand*/  } else if (action.equalsIgnoreCase("prendiMessaggi")){
					int IDProprietario = Integer.parseInt((String) request.getSession().getAttribute("id"));
					Collection<MessaggioBean> messaggi = modelMes.prendiMessaggi(IDProprietario);
					request.setAttribute("massaggi", messaggi);
					//reindirizzamento pagina
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
					//redirect pagina
				}
			}
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	/*private void reloadAssembler(HttpServletRequest request, HttpServletResponse response, boolean desk,
			RequestDispatcher dispatcher) throws SQLException, ServletException, IOException {
		String key = request.getParameter("key");
		BuildBean build = null;
		if(key!=null){
			build = modelBuild.doSearchById(Integer.parseInt(key));
		}
		request.setAttribute("build", build);
		request.setAttribute("comp", modelComp.doRetriveAll());
		if(desk)
			request.setAttribute("code", "3");
		else
			request.setAttribute("code", "5");
		Collection<ViewerNewsBean> view = modelView.doRetriveAll();
		request.setAttribute("view", view);
		dispatcher.forward(request, response);
		return;
		
	}

	private RequestDispatcher buildManager (HttpServletRequest request, RequestDispatcher dispatcher) throws SQLException {
		Collection<BuildBean> Build;
		if(((AccountBean)request.getSession().getAttribute("user")).getRules())
			Build = modelBuild.doRetriveAll();
		else
			Build = modelBuild.doRetriveAllTrue();
		Iterator <BuildBean> buildIt;
		BuildBean build;
		Collection<AccountBean> Account= modelAcc.doRetriveAll();
		Iterator <AccountBean> AccIt = Account.iterator();
		AccountBean account = new AccountBean();
		Collection <AccountBean> account2 = new LinkedList <AccountBean>();
		while(AccIt.hasNext()){
			account=(AccountBean)AccIt.next();
			buildIt = Build.iterator();
			build = new BuildBean();
			while(buildIt.hasNext()){
				build=(BuildBean)buildIt.next();
				if(account.getEmail().equalsIgnoreCase(build.getEmail())){
					account2.add(account);
					break;
				}
			}
		}
		request.setAttribute("accounts", account2);
		request.setAttribute("code", "2");
		dispatcher = getServletContext().getRequestDispatcher("/Build.jsp");
		return dispatcher;
	}

	private RequestDispatcher informationManager(HttpServletRequest request, RequestDispatcher dispatcher) throws SQLException {
		request.setAttribute("accounts",modelAcc.doRetriveAll());
		String s = request.getParameter("page");
		dispatcher = getServletContext().getRequestDispatcher(s);
		return dispatcher;
	}
	private RequestDispatcher retriveReviewList(HttpServletRequest request, RequestDispatcher dispatcher) throws SQLException{
		Collection<ViewerNewsBean> View = modelView.doRetriveAll();
		Iterator <ViewerNewsBean> viewIt;
		ViewerNewsBean view;
		Collection<AccountBean> Account= modelAcc.doRetriveAll();
		Iterator <AccountBean> AccIt = Account.iterator();
		AccountBean account = new AccountBean();
		Collection <AccountBean> account2 = new LinkedList <AccountBean>();
		while(AccIt.hasNext()){
			account=(AccountBean)AccIt.next();
			viewIt = View.iterator();
			view = new ViewerNewsBean();
			while(viewIt.hasNext()){
				view=(ViewerNewsBean)viewIt.next();
				if(account.getEmail().equalsIgnoreCase(view.getAccEmail())){
					account2.add(account);
					break;
				}
			}
		}
		request.setAttribute("accounts", account2);
		request.setAttribute("code", "1");
		dispatcher = getServletContext().getRequestDispatcher("/ReviewControl.jsp");
		return dispatcher;
	}
*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
