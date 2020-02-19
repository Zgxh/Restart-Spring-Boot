<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/28
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Zgxh SpringBoot Learning</title>
</head>

<%--注意：JSP是Spring boot官方不推荐的技术--%>
<body>
<%--下面的语句使用EL表达式来获得值--%>
${zgxh}                  <%--使用Model转发信息时，利用key值获取value--%>
${user.getName()}        <%--使用自定义类转发信息时，可以调用方法或变量值--%>
${user.id}
</body>

</html>
