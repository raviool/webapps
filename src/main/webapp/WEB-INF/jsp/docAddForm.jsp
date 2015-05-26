<%--
  Created by IntelliJ IDEA.
  User: Raviool
  Date: 26.05.2015
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <title></title>
</head>
<body>
<jsp:include page="header.jsp" />

<form action="?add" method="POST">
  <input type="hidden" name="catalog" value="${catalog}"/>
  <input type="hidden" name="type" value="${type}"/>
  <table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
    <tr>
      <td style="padding:0px;">
        <table style="border:0;border-collapse:separate;border-spacing:1px;">
          <tr bgcolor='#ffffff'>
            <td bgcolor='#cccccc' style="padding:2px;" nowrap>Kataloog:</td>
            <td style="padding:2px;">&nbsp;${docCatalog.name}&nbsp;</td>
          </tr>
          <tr bgcolor='#ffffff'>
            <td bgcolor='#cccccc' style="padding:2px;" nowrap>Dokumendi tüüp:</td>
            <td style="padding:2px;">&nbsp;${docType.typeName}</td>
          </tr>
          <tr bgcolor='#ffffff'>
            <td bgcolor='#cccccc' style="padding:2px;" nowrap>Nimetus:</td>
            <td style="padding:2px;">&nbsp;<b><font color='#0000ff'><input type="text" name="name" value="${name}"/></font>${nameError}</b></td>
          </tr>
          <tr bgcolor='#ffffff'>
            <td bgcolor='#cccccc' style="padding:2px;" nowrap>Kirjeldus:</td>
            <td style="padding:2px;">&nbsp;<b><font color='#0000ff'><input type="text" name="description" value="${description}"/></font>${descriptionError}</b></td>
          </tr>
          <c:forEach var="attribute" items="${docAttributes}">
            <tr bgcolor='#ffffff'>
              <td bgcolor='#cccccc' style="padding:2px;" nowrap>${attribute.typeName}:</td>
              <td style="padding:2px;">
                <c:if test="${attribute.dataTypeFk == 1}">
                  <input type="text" name="${attribute.docAttributeType}" value="${attribute.defaultValueText}"/>
                </c:if> <c:if test="${attribute.dataTypeFk == 2}">
                <input type="number" name="${attribute.docAttributeType}" value="${attribute.defaultValueText}"/>
              </c:if> <c:if test="${attribute.dataTypeFk == 3}">
                <input type="date" name="${attribute.docAttributeType}" value="${attribute.defaultValueText}"/>
              </c:if> <c:if test="${attribute.dataTypeFk == 4}">
                <select name="${attribute.docAttributeType}">
                  <c:forEach var="option" items="${attribute.selectionValues}">
                    <option value="${option.atrTypeSelectionValue}" <c:if test="${option.atrTypeSelectionValue == attribute.defaultSelectionIdFk}">selected</c:if>>${option.valueText}</option>
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
                  <option value="${status.docStatusType}">${status.typeName}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <input type="submit" value="Salvesta">
</form>
</body>
</html>
