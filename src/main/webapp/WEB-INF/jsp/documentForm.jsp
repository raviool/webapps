<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="white">
	<a href='${pageContext.request.contextPath}'>servlet</a> |
	<a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/document/log.txt'>log.txt</a>
	<br>
	<form:form modelAttribute="document">
		<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td>
					<table width=100% border=0 cellpadding=2 cellspacing=1>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>DOKUMENT:</td>
							<td>&nbsp;${document.document}&nbsp;</td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Dokumendi tüüp:</td>
							<td>&nbsp;${docType.typeName}</td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Nimetus:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input
											path="name" /></font></b>
							<form:errors path="name" /></td>
						</tr>
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' nowrap>Kirjeldus:</td>
							<td>&nbsp;<b><font color='#0000ff'><form:input
											path="description" /></font></b>
							<form:errors path="description" /></td>
						</tr>
						<c:forEach var="attribute" items="${docAttributes}">
							<tr bgcolor='#ffffff'>
								<td bgcolor='#cccccc' nowrap>${attribute.typeName}:</td>
								<td><c:if test="${attribute.dataType == 1}">
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
							<td bgcolor='#cccccc' nowrap>Dokumendi staatus:</td>
							<td>&nbsp;${docStatusType.typeName}&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="submit" value="Salvesta">
	</form:form>
</body>
</html>
