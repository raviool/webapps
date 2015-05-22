<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body bgcolor="white">
		<a href='${pageContext.request.contextPath}'>Kataloog</a> |
		<a href='${pageContext.request.contextPath}/subjectSearch'>Subjekti otsing</a> |
		<a href='${pageContext.request.contextPath}/documentSearch'>Dokumendi otsing</a> |
		<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>Log.txt</a>
		<br>
	</body>
</html>
