<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body bgcolor="white">
<jsp:include page="header.jsp" />

<br>
<form:form modelAttribute="person">
	<table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table style="border:0;border-collapse:separate;border-spacing:1px;">
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' colspan="2" style="padding:2px;" nowrap>SUBJEKTI OTSING</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimi:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path="lastName"/></font></b><form:errors path="lastName" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Seose tüüp:</td>
						<td style="padding:2px;">
							&nbsp;<select>
							<c:forEach var="option" items="${docSubjectRelationTypes}">
								<option>${option.typeName}</option>
							</c:forEach>
						</select>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="submit" value="Otsi">
</form:form>
</body>
</html>
