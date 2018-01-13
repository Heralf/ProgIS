package it.unisa.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import it.unisa.Model.AccountBean;

public class Modulo{

	private static DataSource ds;

	static {
		//utilizzo questa funzione per testarte se la connessione al server avviene con successo
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			//qui metto Erasmus perche e il database dove si deve collegare
			ds = (DataSource) envCtx.lookup("jdbc/Erasmus");

		} catch (NamingException e) {
			//se trova un errore me lo stampa nella console
			System.out.println("Error:" + e.getMessage());
		}
	}
	//inizializzo una stringa con il nome della tabella del database
	private static final String TABLE_NAME = "Modulo";
	
	//prepara la connessione, se riesce ad accedere allora rimara aperta
	public synchronized void openConnection () throws SQLException{
		try {
			connection = ds.getConnection();
		} catch (SQLException e){
			System.out.println("Error:" + e.getMessage());
		}
	}
	//chiudera la connessione con la disconnessione dell'account
	public synchronized void closeConnection () throws SQLException{
		connection.close();
	}
	
	//funzione che cera un modulo di domada/accettazione
	public synchronized void creaModulo (ModuloBean modulo, Boolean domanda) throws SQLException{
		PreparedStatement preparedStatement = null;
		String inserisciSQL ;
		if(domanda)
			inserisciSQL = "INSERT INTO "+ Modulo.TABLE_NAME + " (NOME, COGNOME, SESSO, DATA, POSTAELETTRONICA, MATRICOLA, CITTANASCITA, CITTARESIDENZA, INDIRIZZO, NUMEROCIVICO, CAP, NUEROTELEFONICO, DESTINAZIONE1, DESTINAZIONE2, DESTINAZIONE3, DOMANDA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,)";
		else
			inserisciSQL = "INSERT INTO "+ Modulo.TABLE_NAME + " (NOME, COGNOME, SESSO, DATA, POSTAELETTRONICA, MATRICOLA, CITTANASCITA, CITTARESIDENZA, INDIRIZZO, NUMEROCIVICO, CAP, NUEROTELEFONICO, CARTAIDENTITA , DOMANDA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(inserisciSQL);
			preparedStatement.setString(1,modulo.getAccount().getNome());
			preparedStatement.setString(2,modulo.getAccount().getCognome());
			preparedStatement.setString(3,modulo.getAccount().getSesso());
			preparedStatement.setString(4,modulo.getAccount().getData());
			preparedStatement.setString(5,modulo.getAccount().getPostaElettronica());
			preparedStatement.setString(6,modulo.getAccount().getMatricola());
			preparedStatement.setString(7,modulo.getAccount().getCittaNascita());
			preparedStatement.setString(8,modulo.getAccount().getCittaResidenza());
			preparedStatement.setString(9,modulo.getAccount().getIndirizzo());
			preparedStatement.setInt(10,modulo.getAccount().getNumeroCivico());
			preparedStatement.setInt(11,modulo.getAccount().getCAP());
			preparedStatement.setString(12,modulo.getAccount().getNumeroTelefonico());
			if(domanda){
				preparedStatement.setString(13,modulo.getDestinazione1());
				preparedStatement.setString(14,modulo.getDestinazione2());
				preparedStatement.setString(15,modulo.getDestinazione3());
				preparedStatement.setBoolean(16,domanda);
			}else{
				preparedStatement.setString(13,modulo.getCartaIdentita());
				preparedStatement.setBoolean(14,domanda);
			}
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	//funzione che carica tutti i moduli
	public synchronized Collection<ModuloBean> caricaModuli (int idProprietario, Boolean domanda) throws SQLException{
		Collection<ModuloBean> moduli = null;
		PreparedStatement preparedStatement = null;
		String cercaSQL;
		if(idProprietario==0)
			cercaSQL = "SELECT * FROM "+ Modulo.TABLE_NAME + " WHERE DOMANDA = ? AND INVIAMODULO = ?";
		else
			cercaSQL = "SELECT * FROM "+ Modulo.TABLE_NAME + " WHERE DOMANDA = ? AND IDPROPRIETARIO = ?";
		try{
			preparedStatement = connection.prepareStatement(cercaSQL);
			preparedStatement.setBoolean(1, domanda);
			if(idProprietario!=0)
				preparedStatement.setInt(2, idProprietario);
			else
				preparedStatement.setBoolean(2, true);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				if(moduli==null)
					moduli = new LinkedList<ModuloBean>();
				ModuloBean modulo = new ModuloBean();
				AccountBean account = new AccountBean();
				account.setNome(rs.getString("Nome"));
				account.setCognome(rs.getString("Cognome"));
				account.setSesso(rs.getString("Sesso"));
				account.setData(rs.getString("Data"));
				account.setPostaElettronica(rs.getString("PostaElettronica"));
				account.setMatricola(rs.getString("Matricola"));
				account.setCittaNascita(rs.getString("CittaNascita"));
				account.setCittaResidenza(rs.getString("CittaResidenza"));
				account.setIndirizzo(rs.getString("Indirizzo"));
				account.setNumeroCivico(rs.getInt("NumeroCivico"));
				account.setCAP(rs.getInt("CAP"));
				account.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
				modulo.setData(rs.getString("Data"));
				modulo.setCartaIdentita(rs.getString("CartaIdentita"));
				modulo.setDestinazione1(rs.getString("Destinazione1"));
				modulo.setDestinazione2(rs.getString("Destinazione2"));
				modulo.setDestinazione3(rs.getString("Destinazione3"));
				modulo.setAccount(account);
				moduli.add(modulo);
			}
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		
		return moduli;
	}
	
	//funzione che carica un modulo inserendo il suo id
	public synchronized ModuloBean caricaModulo (int idModulo) throws SQLException{
		ModuloBean modulo = new ModuloBean();
		AccountBean account = new AccountBean();
		PreparedStatement preparedStatement = null;
		String cercaSQL = "SELECT * FROM "+ Modulo.TABLE_NAME + " WHERE ID = "+idModulo;
		try{
			preparedStatement = connection.prepareStatement(cercaSQL);
			ResultSet rs = preparedStatement.executeQuery();
			account.setNome(rs.getString("Nome"));
			account.setCognome(rs.getString("Cognome"));
			account.setSesso(rs.getString("Sesso"));
			account.setData(rs.getString("Data"));
			account.setPostaElettronica(rs.getString("PostaElettronica"));
			account.setMatricola(rs.getString("Matricola"));
			account.setCittaNascita(rs.getString("CittaNascita"));
			account.setCittaResidenza(rs.getString("CittaResidenza"));
			account.setIndirizzo(rs.getString("Indirizzo"));
			account.setNumeroCivico(rs.getInt("NumeroCivico"));
			account.setCAP(rs.getInt("CAP"));
			account.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
			modulo.setCartaIdentita(rs.getString("CartaIdentita"));
			modulo.setDestinazione1(rs.getString("Destinazione1"));
			modulo.setDestinazione2(rs.getString("Destinazione2"));
			modulo.setDestinazione3(rs.getString("Destinazione3"));
			modulo.setAccount(account);
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		
		return modulo;
	}
	
	public synchronized void aggiornaModulo (int idModulo, ModuloBean modulo, Boolean domanda) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL;
		if(domanda)
			aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET NUMEROTELEFONICO = ?, DESTINAZIONE1 = ?, DESTINAZIONE2 = ?, DESTINAZIONE3 = ? WHERE ID = ?";
		else
			aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET CARTAIDENTITA = ? WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			if(domanda){
				preparedStatement.setString(1, modulo.getAccount().getNumeroTelefonico());
				preparedStatement.setString(2, modulo.getDestinazione1());
				preparedStatement.setString(3, modulo.getDestinazione2());
				preparedStatement.setString(4, modulo.getDestinazione3());
				preparedStatement.setInt(5, idModulo);
			}else{
				preparedStatement.setString(1, modulo.getCartaIdentita());
				preparedStatement.setInt(2, idModulo);
			}
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	public synchronized void inviaModulo (int idModulo) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET INVIATOMODULO = ? WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, idModulo);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	public synchronized void confermaModulo (int idModulo) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET CONFERMAMODULO = ? WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, idModulo);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	public synchronized void rifiutoModulo (int idModulo) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "DELETE FROM "+ Modulo.TABLE_NAME + " WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			preparedStatement.setInt(1, idModulo);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	Connection connection = null;
}
