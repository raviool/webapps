<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="${pageContext.request.contextPath}/static/js/document.js"></script>
</head>
<body bgcolor="white">

<jsp:include page="header.jsp" />

<br>
<ul>
	<li><a href="javascript:get_documents(0)">DOKUMENDID</a></li>
	<ul>
		<c:forEach var="catalog" items="${docRootCatalogs}">
			<li><a href="javascript:get_documents(${catalog.docCatalog})">${catalog.name}</a></li>
			<ul>
				<c:forEach var="childCatalog" items="${docSecondLevelCatalogs}">
					<c:if test="${childCatalog.upperCatalogFk == catalog.docCatalog}">
						<li><a href="javascript:get_documents(${childCatalog.docCatalog})">${childCatalog.name}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>
</ul>
<div ID="ajax_response" hidden="true"></div>
<div ID="documents_list" style="visibility: hidden;">
	<table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
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
