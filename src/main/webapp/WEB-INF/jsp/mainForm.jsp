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
</head>
<body bgcolor="white">
<a href='${pageContext.request.contextPath}/'>Kataloog</a> |
<a href='${pageContext.request.contextPath}/subjectSearch'>Subjekti otsing</a> |
<a href='${pageContext.request.contextPath}/documentSearch'>Dokumendi otsing</a> |
<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>Log.txt</a>
<br>
<ul>
	<li><a href="/catalog">DOKUMENDID</a></li>
	<ul>
		<c:forEach var="catalog" items="${docRootCatalogs}">
			<li><a href="/catalog?id=${catalog.docCatalog}">${catalog.name}</a></li>
			<ul>
				<c:forEach var="childCatalog" items="${docSecondLevelCatalogs}">
					<c:if test="${childCatalog.upperCatalogFk == catalog.docCatalog}">
						<li><a href="/catalog?id=${childCatalog.docCatalog}">${childCatalog.name}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>
</ul>
</body>
</html>
