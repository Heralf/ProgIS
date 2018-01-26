package it.unisa.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import it.unisa.Model.AccountBean;
import it.unisa.DriverManagerConnectionPool;

public class Account{

	private static DataSource ds;
	//inizializzo una stringa con il nome della tabella del database
	private static final String TABLE_NAME = "Account";
	
	//prepara la connessione, se riesce ad accedere allora rimara aperta
	public synchronized void openConnection () throws SQLException{
		try {
			connection = DriverManagerConnectionPool.getConnection();
		} catch (SQLException e){
			System.out.println("Error:" + e.getMessage());
		}
	}
	//chiudera la connessione con la disconnessione dell'account
	public synchronized void closeConnection () throws SQLException{
		DriverManagerConnectionPool.releaseConnection(connection);
	}
	
	//funzione che cerca l'account tramnite email, utilizzata per entrare sul sito web
	public synchronized AccountBean doSearchByEmail(String Email) throws SQLException{
		PreparedStatement preparedStatement = null;
		AccountBean account = new AccountBean();
		String selectSQL = "SELECT * FROM " + Account.TABLE_NAME + " WHERE PostaElettronica = ? ";
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, Email);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				account.setID(rs.getInt("ID"));
				account.setNome(rs.getString("Nome"));
				account.setCognome(rs.getString("Cognome"));
				account.setSesso(rs.getString("Sesso"));
				account.setData(rs.getString("Data"));
				account.setMatricola(rs.getString("Matricola"));
				account.setPostaElettronica(rs.getString("PostaElettronica"));
				account.setPassword(rs.getString("Password"));
				account.setCittaNascita(rs.getString("CittaNascita"));
				account.setCittaResidenza(rs.getString("CittaResidenza"));
				account.setIndirizzo(rs.getString("Indirizzo"));
				account.setNumeroCivico(rs.getInt("NumeroCivico"));
				account.setCAP(rs.getInt("CAP"));
				account.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
				account.setAdmin(rs.getBoolean("Admin"));
			}
		} finally {
				if (preparedStatement != null)
					preparedStatement.close();
		}
		return account;
	}
	
	public synchronized AccountBean doSearchByID(int ID) throws SQLException{
		PreparedStatement preparedStatement = null;
		AccountBean account = new AccountBean();
		String selectSQL = "SELECT * FROM " + Account.TABLE_NAME + " WHERE ID = ? ";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ID);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				account.setID(rs.getInt("ID"));
				account.setNome(rs.getString("Nome"));
				account.setCognome(rs.getString("Cognome"));
				account.setSesso(rs.getString("Sesso"));
				account.setData(rs.getString("Data"));
				account.setMatricola(rs.getString("Matricola"));
				account.setPostaElettronica(rs.getString("PostaElettronica"));
				account.setPassword(rs.getString("Password"));
				account.setCittaNascita(rs.getString("CittaNascita"));
				account.setCittaResidenza(rs.getString("CittaResidenza"));
				account.setIndirizzo(rs.getString("Indirizzo"));
				account.setNumeroCivico(rs.getInt("NumeroCivico"));
				account.setCAP(rs.getInt("CAP"));
				account.setNumeroTelefonico(rs.getString("NumeroTelefonico"));
				account.setAdmin(rs.getBoolean("Admin"));
			}
		} finally {
				if (preparedStatement != null)
					preparedStatement.close();
		}
		return account;
	}
	
	Connection connection = null;
}
