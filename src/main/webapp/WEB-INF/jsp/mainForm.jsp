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
	<li><a style="cursor: pointer" onclick="get_documents(0, this)">DOKUMENDID</a></li>
	<ul>
		<c:forEach var="catalog" items="${docRootCatalogs}">
			<li><a style="cursor: pointer" onclick="get_documents(${catalog.docCatalog}, this)">${catalog.name}</a></li>
			<input type="hidden" id="path_${catalog.docCatalog}" value="/${catalog.name}"/>
			<ul>
				<c:forEach var="childCatalog" items="${docSecondLevelCatalogs}">
					<c:if test="${childCatalog.upperCatalogFk == catalog.docCatalog}">
						<li><a style="cursor: pointer" onclick="get_documents(${childCatalog.docCatalog}, this)">${childCatalog.name}</a></li>
						<input type="hidden" id="path_${childCatalog.docCatalog}" value="/${catalog.name}/${childCatalog.name}"/>
					</c:if>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>
</ul>
<div ID="ajax_response" hidden="true"></div>
<div ID="documents_list" style="visibility: hidden;">
	<table style="border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<form method='POST' action='/?addtobuffer'><table id="documentsTable" style="border:0;border-collapse:separate;border-spacing:1px;"></table></form>
				<c:if test="${true}"><form id="movebuffer" name='movebuffer' action='/buffer' method='POST'><input id="movecatalog" type="hidden" name="movecatalog" value=""/><input type='submit' value='Liiguta puhver siia'/></form></c:if>
			</td>
		</tr>
	</table>
	<input type="button" value="Sulge" onClick="hide_documents_list()">
</div>
</body>
</html>
