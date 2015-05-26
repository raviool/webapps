<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
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
	<script src="${pageContext.request.contextPath}/static/js/subject.js"></script>
</head>
<body bgcolor="white">
<jsp:include page="header.jsp" />
<br>

<form name="edit" action="/edit" method="POST">
	<table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table style="border:0;border-collapse:separate;border-spacing:1px;">
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokument nr:</td>
						<td style="padding:2px;" id="documentId">${document.document}</td><input name="id" type="hidden" value="${document.document}"/>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi tüüp:</td>
						<td style="padding:2px;">${docType.typeName}</td><input name="type" type="hidden" value="${docType.docType}"/>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimetus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><input type="text" name="name" value="${document.name}"/></font></b></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kirjeldus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><input type="text" name="description" value="${document.description}"/></font></b> </td>
					</tr>
					<c:forEach var="attribute" items="${docAttributes}">
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' style="padding:2px;" nowrap>${attribute.typeName}:</td>
							<td style="padding:2px;">
								<c:if test="${attribute.dataType == 1}">
									<input type="text" name="${attribute.docAttributeTypeFk}" value="${attribute.valueText}"/>
								</c:if> <c:if test="${attribute.dataType == 2}">
								<input type="number" name="${attribute.docAttributeTypeFk}" value="${attribute.valueNumber}"/>
							</c:if> <c:if test="${attribute.dataType == 3}">
								<input type="date" name="${attribute.docAttributeTypeFk}" value="${attribute.valueDate}"/>
							</c:if> <c:if test="${attribute.dataType == 4}">
								<select name="${attribute.docAttributeTypeFk}">
									<c:forEach var="option" items="${attribute.selectionValues}">
										<option value="${option.atrTypeSelectionValue}" <c:if test="${option.atrTypeSelectionValue == attribute.atrTypeSelectionValueFk}">selected</c:if>>${option.valueText}</option>
									</c:forEach>
								</select>
							</c:if></td>
						</tr>
					</c:forEach>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi staatus:</td>
						<td style="padding:2px;">
							<select name="status">
								<c:forEach var="status" items="${statuses}">
									<option value="${status.docStatusType}" <c:if test="${status.docStatusType == document.docStatusTypeFk}">selected</c:if> >${status.typeName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input name="submit" type="submit" value="Salvesta">
</form>
<br>

<!--<form:form modelAttribute="document">
	<div style="display:none;" id="documentId">${document.document}</div>
	<table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table style="border:0;border-collapse:separate;border-spacing:1px;">
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>DOKUMENT:</td>
						<td style="padding:2px;">&nbsp;${document.document}&nbsp;</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi tüüp:</td>
						<td style="padding:2px;">&nbsp;${docType.typeName}</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimetus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input
								path="name" /></font></b> <form:errors path="name" /></td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Kirjeldus:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input
								path="description" /></font></b> <form:errors path="description" /></td>
					</tr>
					<c:forEach var="attribute" items="${docAttributes}">
						<tr bgcolor='#ffffff'>
							<td bgcolor='#cccccc' style="padding:2px;" nowrap>${attribute.typeName}:</td>
							<td style="padding:2px;"><c:if test="${attribute.dataType == 1}">
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
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi staatus:</td>
						<td style="padding:2px;">&nbsp;${docStatusType.typeName}&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="submit" value="Salvesta">
</form:form>-->

<table style="border:0;border-collapse:separate;border-spacing:1px;">
	<tr bgcolor='#ffffff'>
		<td bgcolor='#cccccc' style="padding:2px;" nowrap><b>Subjekt</b></td>
		<td bgcolor='#cccccc' style="padding:2px;" nowrap><b>Seos</b></td>
		<td bgcolor='#cccccc' style="padding:2px;" nowrap><b>Märge</b></td>
		<td bgcolor='#cccccc' style="padding:2px;" nowrap></td>
	</tr>
	<c:forEach var="subject" items="${subjects}">
		<tr bgcolor='#ffffff'>
			<td bgcolor='#cccccc' style="padding:2px;" nowrap>${subject.name}</td>
			<td bgcolor='#cccccc' style="padding:2px;" nowrap>${subject.type}</td>
			<td bgcolor='#cccccc' style="padding:2px;" nowrap>${subject.note}</td>
			<td bgcolor='#cccccc' style="padding:2px;" nowrap><a href="/deleterel?id=${subject.relationId}&doc=${document.document}"><input type="button" value="Kustuta"/></a></td>
		</tr>
	</c:forEach>
</table>

<br>
<form:form modelAttribute="person">
	<table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table style="border:0;border-collapse:separate;border-spacing:1px;">
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' colspan="2" style="padding:2px;" nowrap>SUBJEKTI OTSING</td>
					</tr>
					<tr bgcolor='#ffffff'>
						<td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimi:</td>
						<td style="padding:2px;">&nbsp;<b><font color='#0000ff'><form:input path="lastName" id="lastName"/></font></b><form:errors path="lastName" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="button" value="Otsi" onClick="get_subjects(document.getElementById('lastName').value, this)">
</form:form>

<div ID="ajax_response" hidden="true"></div>
<div ID="subjects_list" style="visibility: hidden;">
	<table style="border:0;border-collapse:separate;border-spacing:0px;">
		<tr>
			<td style="padding:0px;">
				<table id="subjectsTable" style="border:0;border-collapse:separate;border-spacing:1px;"></table>
			</td>
		</tr>
	</table>
	<input type="button" value="Sulge" onClick="hide_subjects_list()">
</div>
</body>
</html>