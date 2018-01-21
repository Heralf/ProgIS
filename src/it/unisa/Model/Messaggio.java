package it.unisa.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Messaggio {
	
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
	private static final String TABLE_NAME = "Messaggio";
	
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
	
	public synchronized void creaMessaggio (MessaggioBean messaggio) throws SQLException{
		PreparedStatement preparedStatement = null;
		String inserisciSQL = "INSERT INTO " + Messaggio.TABLE_NAME + " (IDPROPRIETARIO, TITOLO, MESSAGGIO, VISTO) VALUES (?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(inserisciSQL);
			preparedStatement.setInt(1, messaggio.getIDProprietario());
			preparedStatement.setString(2, messaggio.getTitolo());
			preparedStatement.setString(3, messaggio.getMessaggio());
			preparedStatement.setBoolean(4, false);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	public synchronized Collection<MessaggioBean> prendiMessaggi (int IDProprietario) throws SQLException{
		PreparedStatement preparedStatement = null;
		Collection<MessaggioBean> messaggi = new LinkedList<MessaggioBean>();
		String inserisciSQL = "SELECT * FROM " + Messaggio.TABLE_NAME + " WHERE IDPROPRIETARIO = ? ORDER BY ID DESC";
		try{
			preparedStatement = connection.prepareStatement(inserisciSQL);
			preparedStatement.setInt(1, IDProprietario);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				MessaggioBean messaggio = new MessaggioBean();
				messaggio.setIDProprietario(rs.getInt("IDPROPRIETARIO"));
				messaggio.setTitolo(rs.getString("TITOLO"));
				messaggio.setMessaggio(rs.getString("MESSAGGIO"));
				messaggio.setVisto(rs.getBoolean("VISTO"));
				messaggi.add(messaggio);
			}
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return messaggi;
	}
	
	Connection connection = null;
}
