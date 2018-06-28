package com.wlopera.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionDataSource {
	private BasicDataSource basicDataSource;
	public DataSource dataSource;
	
	public ConnectionDataSource() {
		init();
	}
	
	public void init() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("admin");
		basicDataSource.setUrl("jdbc:mysql://localhost/robotic");
	
		// Opcional. Sentencia SQL que le puede servir a BasicDataSource para comprobar que la conexion es correcta.
		basicDataSource.setValidationQuery("select 1");
		
		dataSource = basicDataSource;
	}
	
	// BasicDataSource nos reserva una conexion y nos la devuelve.
	public Connection getConnection() {
	
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Error de conexion a base de datos: "+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
