<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<span style="display: block">
	<a href='${pageContext.request.contextPath}/'>Kataloog</a> |
	<a href='${pageContext.request.contextPath}/documentSearch'>Dokumendi otsing</a> |
	<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>Log.txt</a>
	<div style="float:right">Puhver: <sec:authentication property="principal.buffer"/> <input type="button" value="Tühjenda" onclick="clearBuffer()"/> | Kasutaja: <sec:authentication property="principal.username"/> | <a href="/logout">Logi välja</a></div>
</span>
<script>

	function clearBuffer()
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		{// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}
		else
		{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				console.log("done");
			}
		};
		xmlhttp.open("GET","/clearbuffer",true);
		xmlhttp.send();
	}

</script>