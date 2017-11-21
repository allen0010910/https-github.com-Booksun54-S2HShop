<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
</head>

<body>
<a href="${pageContext.request.contextPath }/user_update.action?id=1&userid=root&password=123">访问update</a>
<a href="${pageContext.request.contextPath }/user_save.action?userid=root23&password=123">访问save</a>
<a href="${pageContext.request.contextPath }/user_query.action">查询所有类别1</a><br/>
<c:forEach items="${requestScope.userList }" var="category">
    ${category.userid } | ${category.password }  <br/>
</c:forEach>

<c:forEach items="${sessionScope.categoryList }" var="category">
    ${category.userid } | ${category.password }  <br/>
</c:forEach>

<c:forEach items="${applicationScope.categoryList }" var="category">
    ${category.userid } | ${category.password }  <br/>
</c:forEach>
</body>
</html>