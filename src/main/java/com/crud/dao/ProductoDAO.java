package com.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.crud.conexion.conexion;
import com.crud.model.Productos;

public class ProductoDAO {

	private Connection connection;
	
	private PreparedStatement ps;
	
	private boolean estado;
	
	public boolean guardar (Productos productos) throws SQLException {
		
		String sql = null;
		
		estado = false;
		connection = obtenerConexion();
	
		try {
			connection.setAutoCommit(false);

			sql = "INSERT INTO productos (id,nombre,cantidad,precio,fecha_crear,fecha_actualizar) VALUES (?,?,?,?,?,?)";
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, null);
			ps.setString(2, productos.getNombre());
			ps.setDouble(3, productos.getCantidad());
			ps.setDouble(4, productos.getPrecio());
			ps.setDate(5, productos.getFechaCrear());
			ps.setDate(6, productos.getFechaActualizar());
			
			estado = ps.executeUpdate()>0;
			
			connection.commit();		
			ps.close();
			connection.close();
		} catch (SQLException e) {
			
			connection.rollback();
			
			e.printStackTrace();
		}
			
		
		return estado;
	}
	
	public boolean editar(Productos productos) throws SQLException {
		
		String sql = null;
		
		estado = false;
		connection = obtenerConexion();
		
		try {
			
			connection.setAutoCommit(false);
			
			sql = "UPDATE productos SET nombre=?,cantidad=?,precio=?,fecha_actualizar=? WHERE id=?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, productos.getNombre());
			ps.setDouble(2, productos.getCantidad());
			ps.setDouble(3, productos.getPrecio());
			ps.setDate(4, productos.getFechaActualizar());
			ps.setInt(5, productos.getId());
			
			estado= ps.executeUpdate()>0;
			
			connection.commit();
			
			ps.close();
			connection.close();
											
		} catch (SQLException e) {
			
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estado;
	}
	
	public boolean eliminar(int id) throws SQLException {
		String sql = null;		
		estado = false;
		connection = obtenerConexion();
		
		try {
			
			connection.setAutoCommit(false);
			
			sql = "DELETE FROM productos WHERE id=?";
			
			ps = connection.prepareStatement(sql);
						
			ps.setInt(1, id);
			
			estado= ps.executeUpdate(sql)>0;
			
			connection.commit();
			
			ps.close();
			connection.close();
											
		} catch (SQLException e) {
			
			connection.rollback();
			e.printStackTrace();
		}
				
		return estado;	
	}
	
	public List<Productos> listar () throws SQLException {
		
		ResultSet rs = null;
		List<Productos> listaProductos =  new ArrayList<>();
		
		String sql = null;		
		estado = false;
		connection = obtenerConexion();
		
		try {
			
			sql = "SELECT * FROM productos";
		    ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				
				Productos product = new Productos();
				
				product.setId(rs.getInt(1));
				product.setNombre(rs.getString(2));
				product.setCantidad(rs.getDouble(3));
				product.setPrecio(rs.getDouble(4));
				product.setFechaCrear(rs.getDate(5));
				product.setFechaActualizar(rs.getDate(6));
				
				listaProductos.add(product);
			}
									
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return listaProductos;
	}
	
	public Productos obtenerProductId(int id) throws SQLException {
	
		
		ResultSet rs = null;
		Productos p = new Productos();
				
		String sql = null;		
		estado = false;
		connection = obtenerConexion();
		
		
		try {
			sql = "SELECT * FROM productos WHERE id=?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
									
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setCantidad(rs.getDouble(3));
				p.setPrecio(rs.getDouble(4));
				p.setFechaCrear(rs.getDate(5));
				p.setFechaActualizar(rs.getDate(6));
							
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	private Connection obtenerConexion() throws SQLException {
		return conexion.getConnect();	
	}
	
	
}
