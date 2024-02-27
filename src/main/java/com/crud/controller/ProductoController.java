package com.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.ProductoDAO;
import com.crud.model.Productos;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/Producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		
		if (opcion .equals("crear")){
			System.out.println("Se creo algo");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/crear.jsp");
			requestDispatcher.forward(request, response);
			
			
		} else if (opcion.equals("listar")) {
			
			ProductoDAO dao = new ProductoDAO();
			
			List<Productos> Listar = new ArrayList<>();
				
			
			try {
				Listar = dao.listar();

				for (Productos productos : Listar) {
					System.out.println(productos);
				}
				
				
				System.out.println("Se lista algo");
				request.setAttribute("Listar",Listar);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/listar.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} else if (opcion.equals("editar")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("editar id " +id);
			ProductoDAO productoDAO = new ProductoDAO();
			Productos productos = new Productos();
			
			try {
				productos = productoDAO.obtenerProductId(id);
				System.out.println(productos);
				
				request.setAttribute("producto",productos);
				RequestDispatcher requestDispatcher =  request.getRequestDispatcher("views/editar.jsp");
				requestDispatcher.forward(request, response);
				
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
						
		} else if (opcion.equals("eliminar")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			ProductoDAO dao = new ProductoDAO();
			
			request.getParameter("id");
		}
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date fecha_actual = new Date();
		
		String  opcion = request.getParameter("opcion");
				
		
		
		if (opcion.equals("guardar")) {
			ProductoDAO dao = new ProductoDAO();

			Productos productos = new Productos();				
			productos.setNombre(request.getParameter("nombre"));
			productos.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			productos.setPrecio(Double.parseDouble(request.getParameter("precio")));
			productos.setFechaActualizar(new java.sql.Date(fecha_actual.getTime()));
			
			try {
				dao.guardar(productos);
				System.out.println("Se guardo correctamente");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		} else if (opcion.equals("editar")) {
			
			ProductoDAO dao = new ProductoDAO();				
			Productos productos = new Productos();	
			  
			productos.setId(Integer.parseInt(request.getParameter("id")));
			productos.setNombre(request.getParameter("nombre"));
			productos.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			productos.setPrecio(Double.parseDouble(request.getParameter("precio")));
			productos.setFechaActualizar(new java.sql.Date(fecha_actual.getTime()));
			
		
			
			try {
				dao.editar(productos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); 
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		//		doGet(request, response);
	}

}
