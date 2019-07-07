<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome Spring !</h1>
<h2>Chào khách hàng</h2>
<table class="index_info">
    <tr>
        <td>mã số khách hàng: &nbsp;</td>
        <td><c:out value="${customer_no}"/></td>
    </tr>
</table>
</body>
</html>
