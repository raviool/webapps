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
		<a href='${pageContext.request.contextPath}/'>Kataloog</a> |
		<a href='${pageContext.request.contextPath}/subjectSearch'>Subjekti otsing</a> |
		<a href='${pageContext.request.contextPath}/documentSearch'>Dokumendi otsing</a> |
		<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>Log.txt</a>
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
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path="document"/></font></b><form:errors path="document" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimi:</td>
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path="name"/></font></b><form:errors path="name" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kirjeldus:</td>
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path="description"/></font></b><form:errors path="description" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Viimane muutja:</td>
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path="updatedBy"/></font></b><form:errors path="updatedBy" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kataloogi nimi:</td>
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Subjekt:</td>
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi staatus:</td>
								<td style="padding:2px;">
								&nbsp;<select>
										<c:forEach var="option" items="${docStatusTypes}">
											<option>${option.typeName}</option>
										</c:forEach>
									  </select>
								</td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Atribuudi v��rtus:</td>
								<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path=""/></font></b><form:errors path="" /></td>
							</tr>
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi t��p:</td>
								<td style="padding:2px;">
								&nbsp;<select>
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
			<input type="submit" value="Otsi">
		</form:form>
	</body>
</html>