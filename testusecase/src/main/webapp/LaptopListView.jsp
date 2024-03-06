<%@page import="com.rays.laptopdto.LaptopDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
		LaptopDTO dto = new LaptopDTO();
		List list = (List) request.getAttribute("List");
		Iterator it = list.iterator();
	%>
	<form action="LaptopListCtl" method="post">
		<center>
			<h1>Laptop List</h1>
			<table>
				<tr>

					<!-- <td><input type="text" name="model" placeholder="enter Model Name"></td> -->
					<td><select name="name" class="form-select">
							<option>-----select-----</option>
							<option>hp</option>
							<option>dell</option>
							<option>asuse</option>
							<option>mac</option>

					</select></td>
					<td><input type="submit" name="operation" value="search">
				</tr>
				
			</table>
			<table border="2" width="100%"  align="center" cellpadding=5px ali >
				<tr text-align=center>
					<th>SelectAll</th>
					<th>Id</th>
					<th>LaptopName</th>
					<th>Price</th>
					<th>LaptopModel</th>
					<th>ROM</th>
					<th>RAM</th>
					<th>PurchesDate</th>
					<th>Edit</th>

				</tr>


				<%
					while (it.hasNext()) {
						dto = (LaptopDTO) it.next();
				%>


				<tr>
					<td><input type="checkbox" name="ids" value="<%=dto.getId()%>"></td>
					<td><%=dto.getId()%></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getAmount()%></td>
					<td><%=dto.getModel()%></td>
					<td><%=dto.getRom()%></td>
					<td><%=dto.getRam()%></td>
					<td><%=dto.getDate()%></td>
					<td><a href="LaptopCtl?id=<%=dto.getId()%>">edit</a></td>

					<%
						}
					%>
				</tr>

			</table>
			<table>
				<tr>
					<td><input type="submit" name="operation" value="delete">
					</td>

				</tr>
			</table>
		</center>
	</form>
</body>
</html>