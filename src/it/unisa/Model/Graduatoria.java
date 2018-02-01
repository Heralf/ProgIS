package it.unisa.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.unisa.DriverManagerConnectionPool;

public class Graduatoria {
	
	//inizializzo una stringa con il nome della tabella del database
	private static final String TABLE_NAME = "Graduatoria";
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
	 * @param graduatoria
	 * @throws SQLException
	 */
	//funzione utilizzata per caricare la graduatoria
	public synchronized void caricaGraduatoria (GraduatoriaBean graduatoria) throws SQLException{
		PreparedStatement preparedStatement = null;
		String inserisciSQL = "INSERT INTO graduatoria (nomegrad, tipograd, pesograd, graduatoria) values (?,?,?,?)";
		try{
			preparedStatement=connection.prepareStatement(inserisciSQL);
			preparedStatement.setString(1, graduatoria.getNomeGrad());
			preparedStatement.setString(2, graduatoria.getTipoGrad());
			preparedStatement.setLong(3, graduatoria.getPesoGrad());
			preparedStatement.setBlob(4, graduatoria.getGraduatoria());
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	/**
	 * 
	 * @return boolean
	 * @throws SQLException
	 */
	//fuinzione utilizzata per controllare se e' gia caricata la graduatoria
	public synchronized boolean controlloGraduatoria () throws SQLException{
		PreparedStatement preparedStatement = null;
		Boolean graduatoria=false;
		String selezioneSQL = "SELECT * FROM " + Graduatoria.TABLE_NAME + " WHERE ID = 1";
		try{
			preparedStatement=connection.prepareStatement(selezioneSQL);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				graduatoria=true;
			}
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return graduatoria;
	}
	/**
	 * 
	 * @throws SQLException
	 */
	//funzione per eliminare la graduatoria
	public synchronized void eliminaGraduatoria () throws SQLException{
		PreparedStatement preparedStatement = null;
		String aggiornaSQL = "DELETE FROM "+ Graduatoria.TABLE_NAME + " WHERE ID = 1";
		try{
			preparedStatement = connection.prepareStatement(aggiornaSQL);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	Connection connection = null;
}
