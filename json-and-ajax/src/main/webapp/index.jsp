<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/28
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>ajax test!</title>
    <%
        pageContext.setAttribute("contextPath", request.getContextPath()); // 此时为"/"
    %>
    <script src="jquery-3.4.1.js"></script>  <%-- 引入jQuery，以支持AJAX --%>
    <style>
        div {
            float: left;
            width: 200px;
            height: 200px;
            margin-left: 20px;
            background-color: aquamarine;
        }
    </style>
</head>

<body>
<div>
    div1 <%=new Date()%>
</div>
<div id="selected">
    div2 <%=new Date()%>
</div>
<a id="aBtn" href="/refresh">获取更新后的数据</a>
</body>

<script type="text/javascript">
    $("a").click(function () {
        // $.get()的四个参数：
        // url，（必须）
        // data 即 要传送的数据，
        // success(response,status,xhr) 即 响应成功后的行为，是一个function，response是返回的内容，status是状态码，xhr就是原始的XMLHttpRequest js对象,
        // datatype 即 返回数据的类型, 可选 "xml", "html", "text", "script", "json", "jsonp"， 会自动转换成指定类型
        $.get("/refresh", {name:"zgxh", age:18}, function (data) {
            // alert(typeof data);
            // alert("返回数据: data : " + data);
            $("#selected").append("name : " + data.name + ", age : " + data.age);
        }, "json");
        return false; // 清除html链接<a>标签默认的跳转行为
    });
</script>

</html>
