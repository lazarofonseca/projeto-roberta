<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recibo de Entrada</title>
</head>
<body>

	<form action="teste" method="post">
		<table width="300" cellpadding="10" align="center">
			<tr>
				<td>Id:</td>
				<td><input type="text" name="id_veiculo" disabled="disabled" value="${id_veiculo}"/></td>
			</tr>
			
			<tr>
				<td>Placa:</td>
				<td><input type="text" name="placa" disabled="disabled" value="${placa}"/></td>
			</tr>
			<tr>
				<td>Data de Entrada:</td>
				<td><input type="text" name="dataSaida" value="${dataSaida}"/></td>
			</tr>
			<tr>
				<td>Hora da Entrada:</td>
				<td><input type="text" name="horaSaida"  value="${horaSaida}"/></td>
			</tr>
			<tr>
				<td>Tempo Total:</td>
				<td><input type="text" name="Tempo"  value="${tempo}"/></td>
			</tr>
			<tr>
				<td>Valor a Pagar:</td>
				<td><input type="text" name="valorPagar"  value="${valor}"/></td>
			</tr>
			<tr>
				<td>Valor Pago:</td>
				<td><input type="text" name="valorPago"  /></td>
			</tr>
			<tr>
				<td>Troco:</td>
				<td><input type="text" name="troco" value="${troco}"/></td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="Efetuar Download">
				</td>
			</tr>
			
		</table>
			
	</form>
		

</body>
</html>