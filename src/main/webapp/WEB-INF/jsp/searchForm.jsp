<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="white">
	<a href='${pageContext.request.contextPath}'>servlet</a> |
	<a href='${pageContext.request.contextPath}/search'>search</a> |
	<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>log.txt</a>
	<br>
	<form:form modelAttribute="document">
		<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td>
					<table width=100% border=0 cellpadding=2 cellspacing=1>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' colspan="2" nowrap>DOKUMENDI OTSING</td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Id:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path="document"/></font></b><form:errors path="document" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Nimi:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path="name"/></font></b><form:errors path="name" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Kirjeldus:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path="description"/></font></b><form:errors path="description" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Viimane muutja:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path="updatedBy"/></font></b><form:errors path="updatedBy" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Kataloogi nimi:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Subjekt:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Dokumendi staatus:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:select path=""/></font></b><form:errors path="" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Atribuudi väärtus:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Dokumendi tüüp:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:select path=""/></font></b><form:errors path="" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="submit" value="Otsi">
	</form:form>
</body>
</html>
