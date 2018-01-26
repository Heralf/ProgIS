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
	private static DataSource ds;
	
	//inizializzo una stringa con il nome della tabella del database
	private static final String TABLE_NAME = "Graduatoria";
	
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
	
	public synchronized void caricaGraduatoria (GraduatoriaBean graduatoria) throws SQLException{
		PreparedStatement preparedStatement = null;
		String inserisciSQL = "INSERT INTO " + Graduatoria.TABLE_NAME + " (Graduatoria,GraduatoriaPubblica) VALUES (?,?)";
		try{
			preparedStatement=connection.prepareStatement(inserisciSQL);
			preparedStatement.setLong(1, graduatoria.getGraduatoria());
			preparedStatement.setBoolean(2, graduatoria.getGraduatoriaPubblica());
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	public synchronized GraduatoriaBean scaricaGraduatoria () throws SQLException{
		PreparedStatement preparedStatement = null;
		String selezioneSQL = "SELECT GRADUATORIA FROM " + Graduatoria.TABLE_NAME;
		GraduatoriaBean graduatoria = new GraduatoriaBean();
		try{
			preparedStatement=connection.prepareStatement(selezioneSQL);
			ResultSet rs = preparedStatement.executeQuery();
			graduatoria.setGraduatoria(rs.getLong("GRADUATORIA"));
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return graduatoria;
	}
	
	public synchronized void cancellaGraduatoria () throws SQLException{
		PreparedStatement preparedStatement = null;
		String selezioneSQL = "DELETTE FROM " + Graduatoria.TABLE_NAME + " WHERE ID = 1";
		try{
			preparedStatement=connection.prepareStatement(selezioneSQL);
			preparedStatement.executeUpdate();
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}
	
	public synchronized GraduatoriaBean controlloGraduatoria () throws SQLException{
		PreparedStatement preparedStatement = null;
		GraduatoriaBean graduatoria = new GraduatoriaBean();
		String selezioneSQL = "SELECT * FROM " + Graduatoria.TABLE_NAME + " WHERE ID = 1";
		try{
			preparedStatement=connection.prepareStatement(selezioneSQL);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				graduatoria.setGraduatoriaPubblica(rs.getBoolean("GRADUATORIAPUBBLICA"));
				graduatoria.setID(rs.getInt("id"));
			}
		}finally{
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return graduatoria;
	}
	
	Connection connection = null;
}
