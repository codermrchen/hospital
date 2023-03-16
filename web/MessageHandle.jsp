<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2022/5/9
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息操作</title>

</head>
<body style="position: absolute">

        <div style="border: #5FB878 solid 2px;width: 700px;height: 500px;border-radius: 10px"  >
            <div>
                <h1 style="margin-left: 50px">健康药膳</h1>
            </div>
            <hr style="color: #5FB878">
<form action="UploadServlet" method="post" enctype="multipart/form-data">
    <table style="width: 600px;position: relative;top:30px">
        <tr style="position: relative;left: 50px;margin-top: 20px" >
            <td >药膳名</td>
            <td><input style="border-radius: 5px;height: 30px" type="text" name="ysname"/></td>
        </tr>
        <tr style="position: relative;left: 50px;top:30px">
            <td >注意事项</td>
            <td><input type="text"style="width: 300px;height: 50px;border-radius: 5px"  name="name"/></td>
        </tr>
        <tr style="position: relative;left: 50px;top: 70px">
            <td >上传做法图片</td>
            <td><input type="file" name="myfile" size="30"/></td>
        </tr>
        <tr>
            <!--设置单元格可横跨的列数。-->
            <td style="position: relative;left: 50px;top:100px;" colspan="2"><input style="width: 100px;height: 50px;
            background-color: #5FB878;border-radius: 10px;font-size: 20px;font-weight: bold" type="submit" value="上传"/><span style="margin-left: 50px">${message}</span></td>
        </tr>
    </table>

</form>
        </div>
</body>
</html>
