
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Form Student</title>
    <meta charset="utf-8" />
</head>
<body>
    <h2>SINH VIÊN POLY</h2>
    <form action="student-savedata.html" method="post">
        <div>Họ và tên: </div> <input name="name"/>
        <div>Điểm trung bình: </div> <input name="mark"/>
        <div>Chuyên ngành: </div> <label>
            <input name="major" type="radio" value="APP" />
            Ứng dụng phần mềm
        </label>
        <label>
            <input name="major" type="radio" value="WEB" />
            Thiết kế trang web
        </label><hr>
        <button>Lưu</button>
    </form>
</body>
</html>
