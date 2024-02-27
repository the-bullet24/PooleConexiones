<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listar</h1>
	
	
	
	<table  border="1" >
		<tr>
			<td>id</td>
			<td>nombre</td>
			<td>cantidad</td>
			<td>precio</td>
			<td>fecha_crear</td>
			<td>fecha_actualizar</td>
			<td>Eliminar</td>
		</tr>
	
	<c:forEach var="producto" items="${Listar}">
		<tr>
			
			<td>
			
			<a href="Producto?opcion=editar&id=<c:out value="${producto.id}"></c:out>"><c:out value="${producto.id}"></c:out></a>
									
			</td>
		
			<td> <c:out value="${producto.nombre}"></c:out></td>
			<td> <c:out value="${producto.cantidad}"></c:out></td>
			<td> <c:out value="${producto.precio}"></c:out></td>
			<td> <c:out value="${producto.fechaCrear}"></c:out></td>
			<td> <c:out value="${producto.fechaActualizar}"></c:out></td>		
			<td> 
			<a href="Producto?opcion=eliminar&id=<c:out value="${producto.id}"></c:out>">Eliminar </a>
			</td>
		</tr>	
	</c:forEach>
	
				
	
	</table>
	
</body>
</html>