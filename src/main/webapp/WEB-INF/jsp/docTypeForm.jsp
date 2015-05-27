<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raviool
  Date: 26.05.2015
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <title></title>
</head>
<body>
<jsp:include page="header.jsp" />
<form action="documentadd" method="GET">
  <table style="background-color:#000000;border:0;border-collapse:separate;border-spacing:0px;">
    <tr bgcolor='#ffffff'>
      <td bgcolor='#cccccc' style="padding:2px;" nowrap>Kataloog</td>
      <td bgcolor='#cccccc' style="padding:2px;" nowrap>${catalog.name}<input name="catalog" type="hidden" value="${catalog.docCatalog}"/></td>
    </tr>
    <tr>
      <td bgcolor='#cccccc' style="padding:2px;" nowrap>Tüüp</td>
      <td bgcolor='#cccccc' style="padding:2px;" nowrap>
        <select name="type">
          <c:forEach items="${doctypes}" var="type">
            <option value="${type.docType}">${type.typeName}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
  </table>
  <input type="submit" value="Edasi"/>
</form>

</body>
</html>
