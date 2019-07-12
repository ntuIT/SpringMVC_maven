<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
    <h1>trang chủ</h1>
    <% String path = request.getContextPath(); %>
    <a href="<%=path%>/student/show-form.htm">Đến trang Student</a>
    <form action="index.html" method="get">
        <table class="index_info">
            <tr>
                <td><label class="caption">Nhập mã khách hàng:</label> &nbsp;</td>
                <td><input type="text" name="txt_id" /></td>
            </tr>
            <tr>
                <td>&nbsp; </td>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>

    </form>
</body>
</html>
