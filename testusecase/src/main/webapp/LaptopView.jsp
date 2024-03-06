<%@page import="com.rays.laptopdto.LaptopDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
	<!-- <h2>
		<a href="PaymentListCtl">Back</a>
	</h2> -->
	<%
		LaptopDTO dto = (LaptopDTO) request.getAttribute("dto");
	String msg=(String)request.getAttribute("msg");
	%>
	<form action="LaptopCtl" method="post">
		<center>
			<%
				if (dto != null) {
			%>
			<h1>Edit Order</h1>
			<%
				} else {
			%>
			<h1>Add Order</h1>
			<%
				}
			%>
			<%
			if(msg!=null){%>
        <h3><font color="green"> <%=msg %></font> </h3>
              <%} %>


			<table>
				<input type="hidden" name="id"
					value="<%=(dto != null) ? dto.getId() : ""%>">
				<tr>
					<th>Laptop Name:</th>
					<td><input type="name" name="name"
						value="<%=(dto != null) ? dto.getName() : ""%>"></td>
				</tr>
				
				<tr>
					<th>Price:</th>
					<td><input type="text" name="amount"
						value="<%=(dto != null) ? dto.getAmount() : ""%>"></td>
				</tr>

				<tr>
					<th>model:</th>
					<td><input type="text" name="model"
						value="<%=(dto != null) ? dto.getModel() : ""%>"></td>
				</tr>
				
				<tr>
					<th>Rom:</th>
					<td><input type="text" name="rom"
						value="<%=(dto != null) ? dto.getRom() : ""%>"></td>
				</tr>
				
				<tr>
					<th>Ram:</th>
					<td><input type="text" name="ram"
						value="<%=(dto != null) ? dto.getRam() : ""%>"></td>
				</tr>
				
				<tr>
					<th>purchesDate:</th>
					<%if(dto !=null){ %>
					<td><input type="text" name="dates"
						value="<%=dto.getDate()%>"></td>
					<%} else {%>
						<td><input type="date" name="dates"></td>
					<%} %>
				
				</tr>
				
			</table>
			<table>
				<%
					if (dto != null) {
				%>
				<tr>
					<td><input type="submit" name="operation" value="update"></td>
                    <td><input type="submit" name="operation" value="AddUser"></td>

				</tr>
				<%
					} else {
				%>
				<tr>
					<td><input type="submit" name="operation" value="save"></td>
					 <td><input type="submit" name="operation" value="cancel"></td>	
				</tr>
				<%
					}
				%>
			</table>
		</center>
	</form>
</html>