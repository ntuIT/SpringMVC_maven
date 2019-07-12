
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin sinh viên</title>
</head>
<body>
    <% String path = request.getContextPath(); %>
    <form action="<%=path%>/student.htm" method="get">
        <div>
        <table>
            <tr>
                <td><label class="caption_input">Họ & tên: </label></td>
                <td><input type="text" name="txt_name"/></td>
            </tr>
            <tr>
                <td><label class="caption_input">Điểm TB</label></td>
                <td><input type="text" name="txt_mark"/></td>
            </tr>
            <tr>
                <td><label class="caption_input">Chuyên ngành: </label></td>
                <td><input type="text" name="txt_major"/></td>
            </tr>

        </table>
        <button name="btnInsert">Thêm</button>
            <button name="btnUpdate">Cập nhật</button>
            <button name="btnDelete">Xóa</button>
            <button name="btnReset">Nhập lại</button>
            <br><hr align="center" width="360px">
        </div>

    </form>
<%--    <table border="1" style="width: 50%">--%>
<%--        <tr></tr>--%>
    </table>
</body>
</html>
