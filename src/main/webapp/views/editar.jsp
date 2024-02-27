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

	<form action="Producto" method="post">
		
	<c:set var="producto" value="${producto}" > </c:set>	
		
		<input type="hidden" name="opcion"  value="editar" />
		<input type="hidden" name="id" value="${producto.id}" />
		
		<h1>Formulario</h1>
		
		<table >
			<tr>
				<td><label>Nombre</label></td>			
				<td><input type="text" name="nombre" value="${producto.nombre}"/> <br></td>					
			</tr>
			
			<tr>
				<td><label>Cantidad</label></td>
				<td><input type="text" name="cantidad" value="${producto.cantidad}" /> <br></td>										
			</tr>
		
			<tr>
				<td><label>Precio</label></td>
				<td><input type="text" name="precio" value="${producto.precio}"  /> <br></td>
			</tr>
						
		</table>

		<input type="submit" value="Guardar" />					
	
	</form>

</body>
</html>