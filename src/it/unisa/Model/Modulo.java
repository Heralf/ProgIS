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

import it.unisa.DriverManagerConnectionPool;
import it.unisa.Model.AccountBean;

public class Modulo{
	//inizializzo una stringa con il nome della tabella del database
	private static final String TABLE_NAME = "Modulo";
	/**
	 * 
	 * @throws SQLException
	 */
	//prepara la connessione, se riesce ad accedere allora rimara aperta
	public synchronized void openConnection () throws SQLException{
		try {
			connection = DriverManagerConnectionPool.getConnection();
		} catch (SQLException e){
			System.out.println("Error:" + e.getMessage());
		}
	}
	/**
	 * 
	 * @throws SQLException
	 */
	//chiudera la connessione con la disconnessione dell'account
	public synchronized void closeConnection () throws SQLException{
		DriverManagerConnectionPool.releaseConnection(connection);
	}
	/**
	 * 
	 * @param modulo
	 * @param domanda
	 * @param inviato
	 * @throws SQLException
	 */
	//funzione che cera un modulo di domada/accettazione
	public synchronized void creaModulo (ModuloBean modulo, Boolean domanda, Boolean inviato) throws SQLException{
		PreparedStatement preparedStatement = null;
		String inserisciSQL ;
		if(domanda)
			inserisciSQL = "INSERT INTO "+ Modulo.TABLE_NAME + " (IDPROPRIETARIO, NOME, COGNOME, SESSO, DATANASCITA, DATA, "
					+ "POSTAELETTRONICA, MATRICOLA, CITTANASCITA, CITTARESIDENZA, INDIRIZZO, NUMEROCIVICO, CAP, NUMEROTELEFONICO, "
					+ "DESTINAZIONE1, DESTINAZIONE2, DESTINAZIONE3, DOMANDA, INVIAMODULO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		else
			inserisciSQL = "INSERT INTO "+ Modulo.TABLE_NAME + " (IDPROPRIETARIO, NOME, COGNOME, SESSO, DATANASCITA, DATA, "
					+ "POSTAELETTRONICA, MATRICOLA, CITTANASCITA, CITTARESIDENZA, INDIRIZZO, NUMEROCIVICO, CAP, NUMEROTELEFONICO, "
					+ "DESTINAZIONE1, CARTAIDENTITA , DOMANDA, INVIAMODULO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(inserisciSQL);
			preparedStatement.setInt(1,modulo.getAccount().getID());
			preparedStatement.setString(2,modulo.getAccount().getNome());
			preparedStatement.setString(3,modulo.getAccount().getCognome());
			preparedStatement.setString(4,modulo.getAccount().getSesso());
			preparedStatement.setString(5,modulo.getAccount().getData());
			preparedStatement.setString(6,modulo.getData());
			preparedStatement.setString(7,modulo.getAccount().getPostaElettronica());
			preparedStatement.setString(8,modulo.getAccount().getMatricola());
			preparedStatement.setString(9,modulo.getAccount().getCittaNascita());
			preparedStatement.setString(10,modulo.getAccount().getCittaResidenza());
			preparedStatement.setString(11,modulo.getAccount().getIndirizzo());
			preparedStatement.setInt(12,modulo.getAccount().getNumeroCivico());
			preparedStatement.setInt(13,modulo.getAccount().getCAP());
			preparedStatement.setString(14,modulo.getAccount().getNumeroTelefonico());
			preparedStatement.setString(15,modulo.getDestinazione1());
			if(domanda){
				preparedStatement.setString(16,modulo.getDestinazione2());
				preparedStatement.setString(17,modulo.getDestinazione3());
				preparedStatement.setBoolean(18,domanda);
				preparedStatement.setBoolean(19,inviato);
			}else{
				preparedStatement.setString(16,modulo.getCartaIdentita());
				preparedStatement.setBoolean(17,domanda);
				preparedStatement.setBoolean(18,inviato);
			}
			preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	/**
	 * 
	 * @param idProprietario
	 * @param domanda
	 * @param admin
	 * @return Collection<ModuloBean>
	 * @throws SQLException
	 */
	//funzione che carica tutti i moduli
	public synchronized Collection<ModuloBean> caricaModuli (int idProprietario, Boolean domanda, Boolean admin) throws SQLException{
		Collection<ModuloBean> moduli = null;
		PreparedStatement preparedStatement = null;
		String cercaSQL;
		if(!admin)
			cercaSQL = "SELECT * FROM "+ Modulo.TABLE_NAME + " WHERE DOMANDA = ? AND IDPROPRIETARIO = ?";
		else
			cercaSQL = "SELECT * FROM "+ Modulo.TABLE_NAME + " WHERE DOMANDA = ? AND INVIAMODULO = ? AND CONFERMAMODULO = ?";
		try{
			preparedStatement = connection.prepareStatement(cercaSQL);
			preparedStatement.setBoolean(1, domanda);
			if(!admin)
				preparedStatement.setInt(2, idProprietario);
			else{
				preparedStatement.setBoolean(2, true);
				preparedStatement.setBoolean(3, false);
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				if(moduli==null)
					moduli = new LinkedList<ModuloBean>();
				ModuloBean modulo = new ModuloBean();
				AccountBean account = new AccountBean();
				account.setNome(rs.getString("Nome"));
				account.setCognome(rs.getString("Cognome"));
				account.setSesso(rs.getString("Sesso"));
				account.setData(rs.getString("DataNascita"));
				account.setPostaElettronica(rs.getString("PostaElettronica"));
				account.setMatricola(rs.getString("Matricola"));
				account.setCittaNascita(rs.getString("CittaNascita"));
				account.setCittaResidenza(rs.getString("CittaResidenza"));
				account.setIndirizzo(rs.getString("Indirizzo"));
				account.setNumeroCivico(rs.getInt("NumeroCivico"));
				account.setCAP(rs.getInt("CAP"));
				account.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
				modulo.setID(rs.getInt("ID"));
				modulo.setidProprietario(rs.getInt("idProprietario"));
				modulo.setData(rs.getString("Data"));
				modulo.setCartaIdentita(rs.getString("CartaIdentita"));
				modulo.setDestinazione1(rs.getString("Destinazione1"));
				modulo.setDestinazione2(rs.getString("Destinazione2"));
				modulo.setDestinazione3(rs.getString("Destinazione3"));
				modulo.setDomanda(rs.getBoolean("Domanda"));
				modulo.setInviaModulo(rs.getBoolean("InviaModulo"));
				modulo.setConfermaModulo(rs.getBoolean("ConfermaModulo"));
				modulo.setAccount(account);
				moduli.add(modulo);
			}
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		
		return moduli;
	}
	/**
	 * 
	 * @param idModulo
	 * @return ModuloBean
	 * @throws SQLException
	 */
	//funzione che carica un modulo inserendo il suo id
	public synchronized ModuloBean caricaModulo (int idModulo) throws SQLException{
		ModuloBean modulo = new ModuloBean();
		AccountBean account = new AccountBean();
		PreparedStatement preparedStatement = null;
		String cercaSQL = "SELECT * FROM "+ Modulo.TABLE_NAME + " WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(cercaSQL);
			preparedStatement.setInt(1, idModulo);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				account.setNome(rs.getString("Nome"));
				account.setCognome(rs.getString("Cognome"));
				account.setSesso(rs.getString("Sesso"));
				account.setData(rs.getString("DataNascita"));
				account.setPostaElettronica(rs.getString("PostaElettronica"));
				account.setMatricola(rs.getString("Matricola"));
				account.setCittaNascita(rs.getString("CittaNascita"));
				account.setCittaResidenza(rs.getString("CittaResidenza"));
				account.setIndirizzo(rs.getString("Indirizzo"));
				account.setNumeroCivico(rs.getInt("NumeroCivico"));
				account.setCAP(rs.getInt("CAP"));
				account.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
				modulo.setID(rs.getInt("ID"));
				modulo.setidProprietario(rs.getInt("idProprietario"));
				modulo.setCartaIdentita(rs.getString("CartaIdentita"));
				modulo.setDestinazione1(rs.getString("Destinazione1"));
				modulo.setDestinazione2(rs.getString("Destinazione2"));
				modulo.setDestinazione3(rs.getString("Destinazione3"));
				modulo.setData(rs.getString("Data"));
				modulo.setDomanda(rs.getBoolean("Domanda"));
				modulo.setInviaModulo(rs.getBoolean("InviaModulo"));
				modulo.setConfermaModulo(rs.getBoolean("ConfermaModulo"));
				modulo.setAccount(account);
			}
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		
		return modulo;
	}
	/**
	 * 
	 * @param idModulo
	 * @param modulo
	 * @param domanda
	 * @param inviato
	 * @throws SQLException
	 */
	public synchronized void aggiornaModulo (int idModulo, ModuloBean modulo, Boolean domanda, Boolean inviato) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL;
		if(domanda)
			aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET DESTINAZIONE1 = ?, DESTINAZIONE2 = ?, DESTINAZIONE3 = ?, INVIAMODULO = ?"
					+ " WHERE ID = ?";
		else
			aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET CARTAIDENTITA = ?, INVIAMODULLO = ? WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			if(domanda){
				preparedStatement.setString(1, modulo.getDestinazione1());
				preparedStatement.setString(2, modulo.getDestinazione2());
				preparedStatement.setString(3, modulo.getDestinazione3());
				preparedStatement.setBoolean(4, inviato);
				preparedStatement.setInt(5, idModulo);
			}else{
				preparedStatement.setString(1, modulo.getCartaIdentita());
				preparedStatement.setBoolean(2, inviato);
				preparedStatement.setInt(3, idModulo);
			}
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	/**
	 * 
	 * @param idModulo
	 * @throws SQLException
	 */
	public synchronized void inviaModulo (int idModulo) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET INVIAMODULO = ? WHERE ID = ?";
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
	/**
	 * 
	 * @param idModulo
	 * @throws SQLException
	 */
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
	/**
	 * 
	 * @param idModulo
	 * @throws SQLException
	 */
	public synchronized void rifiutoModulo (int idModulo) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET INVIAMODULO = ? WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			preparedStatement.setBoolean(1, false);
			preparedStatement.setInt(2, idModulo);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	/**
	 * 
	 * @param idModulo
	 * @throws SQLException
	 */
	public synchronized void eliminaModulo (int idModulo) throws SQLException{
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
	/**
	 * 
	 * @param idModulo
	 * @param data
	 * @param CartaIdentita
	 * @throws SQLException
	 */
	public synchronized void aggiungiCarta (int idModulo, String data, String CartaIdentita) throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "UPDATE "+ Modulo.TABLE_NAME + " SET INVIAMODULO = ?, DATA = ?, CARTAIDENTITA = ? WHERE ID = ?";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setString(2, data);
			preparedStatement.setString(3, CartaIdentita);	
			preparedStatement.setInt(4, idModulo);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	Connection connection = null;
}
