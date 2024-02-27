package com.crud.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class conexion {

	private static BasicDataSource basicDataSource = null;
	
	private static DataSource getConexion() {

		
		if (basicDataSource == null) {
			
			basicDataSource = new BasicDataSource();
			basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			basicDataSource.setUsername("root");
			basicDataSource.setPassword("root");
			basicDataSource.setUrl("jdbc:mysql://localhost:3306/crud");	
			
			basicDataSource.setInitialSize(20);//Conexiones iniciales para el poole conexiones
			basicDataSource.setMaxTotal(15);//Maximas conexiones activas
			basicDataSource.setMaxTotal(20);// Total de conexiones
			basicDataSource.setMaxWaitMillis(5000);//Tiempo de espera para la conexion inactiva
		}
		
		return basicDataSource ;
						
	}
	
	
	public static Connection getConnect() throws SQLException {
	
		return getConexion().getConnection();
		
	}
	
}
