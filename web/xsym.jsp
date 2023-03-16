<%--
  Created by IntelliJ IDEA.
  User: ice cream
  Date: 2022/5/24
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药方显示</title>

</head>
<body>
<div style="border: #5FB878 solid 2px;width: 700px;height:1500px;border-radius: 10px"  >
    <div>
        <h1 style="margin-left: 50px">健康药膳</h1>
    </div>
    <hr style="color: #5FB878">
    <form action="UploadServlet" method="post" enctype="multipart/form-data">
        <table style="width: 600px;position: relative;top:30px;table-layout: fixed">
            <tr style="position: relative;left: 50px;margin-top: 20px" >
                <td style="width: 100px;">药膳名</td>
                <td><input style="border-radius: 5px;width: 150px;height: 30px" type="text" value="${ysname}"  disabled="disabled" autocomplete="off"  name="ysname"/></td>

            </tr>
            <tr style="position: relative;left: 50px;top:30px">
                <td >注意事项</td>
                <td><input type="text"style="width: 300px;height: 100px;border-radius: 5px;" value="${name}"  disabled="disabled" autocomplete="off"  name="name"/></td>
            </tr>
            <tr style="position: relative;left: 50px;top: 70px">
                <td ><img style="width: 500px;height: 1000px" src="picture/member/${pname}"/></td>
            </tr>

        </table>

    </form>
</div>
</body>
</html>
