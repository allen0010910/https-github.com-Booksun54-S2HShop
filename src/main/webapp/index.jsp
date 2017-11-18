<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>主页</title>
</head>

<body>
<!-- 下面两种写法都可以访问 --></span>
<a href="${pageContext.request.contextPath }/user_update.action?user.userid=root&user.password=12323">访问update</a>
<a href="user_save.action">访问save</a>
</body>
</html>