<%--
  Created by IntelliJ IDEA.
  User: booksun
  Date: 2018/1/2
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="shop"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理员密码修改</title>
    <meta name="description" content="管理员密码修改">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${shop}/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/${shop}/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${shop}/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${shop}/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="${shop}/assets/css/app.css">
    <script src="${shop}/assets/js/jquery.min.js"></script>

</head>

<body data-type="login">
<script src="${shop}/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-title">修改密码</div>
            <span class="tpl-login-content-info">
                  修改密码
              </span>

            <%--<c:if test="${not empty tip}">--%>
            <%--<div class="am-alert" data-am-alert>--%>
            <%--<button type="button" class="am-close">&times;</button>--%>
            <%--<p>${tip}</p>--%>
            <%--</div>--%>
            <%--</c:if>--%>

            <%
                if (session.getAttribute("useriderror") != null) {
            %>
            <div class="am-alert" data-am-alert>
                <button type="button" class="am-close">&times;</button>
                <p><%=session.getAttribute("useriderror")%>
                </p>
            </div>
            <%
                    session.removeAttribute("useriderror");
                }
            %>


            <form class="am-form tpl-form-line-form" id="msg">


                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" placeholder="请输入密码" required
                           minlength="3" maxlength="6">
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password2" placeholder="再次输入密码" required
                           minlength="3" maxlength="6">
                    <span style="color: #8fdf82">*两次输入的密码必须保持一致</span>
                </div>

                <div class="am-form-group">

                    <button type="button"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn"
                            onclick="return check();">提交
                    </button>

                    <input type="button"
                           class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn"
                           name="Submit" value="返回" onclick="javascript:history.go(-1)"/>

                </div>
            </form>
        </div>
    </div>
</div>
<script src="${shop}/assets/js/amazeui.min.js"></script>
<script src="${shop}/assets/js/app.js"></script>
<script src="${shop}/assets/js/pwd.js"></script>
<script>
    var id =
    ${sessionScope.user.id}
</script>

</body>

</html>