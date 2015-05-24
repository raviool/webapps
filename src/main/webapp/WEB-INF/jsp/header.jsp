<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<span style="display: block">
	<a href='${pageContext.request.contextPath}/'>Kataloog</a> |
	<a href='${pageContext.request.contextPath}/subjectSearch'>Subjekti otsing</a> |
	<a href='${pageContext.request.contextPath}/documentSearch'>Dokumendi otsing</a> |
	<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>Log.txt</a>
	<div style="float:right">Puhver: <sec:authentication property="principal.buffer"/> | Kasutaja: <sec:authentication property="principal.username"/> | <a href="/logout">Logi välja</a></div>
</span>