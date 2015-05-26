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
	<script src="${pageContext.request.contextPath}/static/js/documentSearch.js"></script>
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
						<td bgcolor='#cccccc' colspan="2" style="padding:2px;" nowrap>DOKUMENDI OTSING</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Id:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input id="id" path="document"/></font></b><form:errors path="document" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimi:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input id="name" path="name"/></font></b><form:errors path="name" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kirjeldus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input id="description" path="description"/></font></b><form:errors path="description" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Viimane muutja:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input id="last_name" path="updatedBy"/></font></b><form:errors path="updatedBy" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kataloogi nimi:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input id="doc_catalog_name" path=""/></font></b><form:errors path="" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Subjekt:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi staatus:</td>
						<td style="padding:2px;">
							&nbsp;<select id="doc_status">
							<option selected></option>
							<c:forEach var="option" items="${docStatusTypes}">
								<option>${option.typeName}</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Atribuudi väärtus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi tüüp:</td>
						<td style="padding:2px;">
							&nbsp;<select id="doc_type">
							<option selected></option>
							<c:forEach var="option" items="${docTypes}">
								<option>${option.typeName}</option>
							</c:forEach>
						</select>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="button" value="Otsi" onclick="get_documents(this)">
</form:form>
<div ID="ajax_response" hidden="true"></div>
<div ID="documents_list" style="visibility: hidden;">
	<table style="border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table id="documentsTable" style="border:0;border-collapse:separate;border-spacing:1px;"></table>
			</td>
		</tr>
	</table>
	<input type="button" value="Sulge" onClick="hide_documents_list()">
</div>
</body>
</html>