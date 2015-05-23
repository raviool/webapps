<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
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
<form:form modelAttribute="document">
	<table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table style="border:0;border-collapse:separate;border-spacing:1px;">
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>DOKUMENT:</td>
						<td style="padding:2px;">&nbsp;${document.document}&nbsp;</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi tüüp:</td>
						<td style="padding:2px;">&nbsp;${docType.typeName}</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimetus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input
								path="name" /></font></b> <form:errors path="name" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kirjeldus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input
								path="description" /></font></b> <form:errors path="description" /></td>
					</tr>
					<c:forEach var="attribute" items="${docAttributes}">
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' style="padding:2px;" nowrap>${attribute.typeName}:</td>
							<td style="padding:2px;"><c:if test="${attribute.dataType == 1}">
								&nbsp;<c:out value="${attribute.valueText}" />
							</c:if> <c:if test="${attribute.dataType == 2}">
								&nbsp;<c:out value="${attribute.valueNumber}" />
							</c:if> <c:if test="${attribute.dataType == 3}">
								&nbsp;<c:out value="${attribute.valueDate}" />
							</c:if> <c:if test="${attribute.dataType == 4}">
								&nbsp;<select>
								<c:forEach var="option" items="${attribute.selectionValues}">
									<option value="${option.atrTypeSelectionValue}"
											<c:if test="${option.atrTypeSelectionValue == attribute.atrTypeSelectionValueFk}">selected</c:if>>${option.valueText}</option>
								</c:forEach>
								</select>
							</c:if></td>
						</tr>
					</c:forEach>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi staatus:</td>
						<td style="padding:2px;">&nbsp;${docStatusType.typeName}&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="submit" value="Salvesta">
</form:form>
</body>
</html>