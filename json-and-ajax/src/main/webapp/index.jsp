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
</head>

<body>
<div>
    div1 <%=new Date()%>
</div>
<div>
    div2 <%=new Date()%>
</div>
<a id="aBtn" href="/refresh">获取更新后的数据</a>
</body>

<script type="text/javascript">
    $("a").click(function () {
        // $.get()的四个参数：
        // url，
        // data 即 要传送的数据，
        // success(response,status,xhr) 即 响应成功后的行为，是一个function，response是返回的内容，status是状态码，xhr就是原始的XMLHttpRequest对象,
        // datatype 即 返回数据的类型
        $.get("/refresh", function (data) {
            alert("返回数据: data : " + data);
        });
        return false; // 清除链接默认的跳转行为
    });
</script>

</html>
