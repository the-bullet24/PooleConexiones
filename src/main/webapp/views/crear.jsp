<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Crear</title>
</head>
<body>
	
	<form action="Producto" method="post">
		
		<input type="hidden" name="opcion"  value="guardar" />
		
		<h1>Formulario</h1>
		
		<table >
			<tr>
				<td><label>Nombre</label></td>			
				<td><input type="text" name="nombre" /> <br></td>					
			</tr>
			
			<tr>
				<td><label>Cantidad</label></td>
				<td><input type="text" name="cantidad" /> <br></td>										
			</tr>
		
			<tr>
				<td><label>Precio</label></td>
				<td><input type="text" name="precio" /> <br></td>
			</tr>
						
		</table>

		<input type="submit" value="Guardar" />					
	
	</form>
	
</body>
</html>