<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Collection" %>
<%@ page import="jwp.model.User" %>

<!doctype html>
<html lang="ko">
<head>
    <%@ include file="../include/header.jspf" %>
</head>
<body>
<%@ include file="../include/navigation.jspf" %>
    <div class="container" id="main">
        <table class="table table-striped">
            <thead class="col-md-12">
            <tr>
                <th class="col-md-3">아이디</th>
                <th class="col-md-3">이름</th>
                <th class="col-md-3">이메일</th>
                <th class="col-md-3">#</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
<%--            <%--%>
<%--                Collection<User> users = (Collection<User>) request.getAttribute("users");--%>
<%--                for (User user : users) {--%>
<%--            %>--%>

            <tr>
                <th class="col-md-3">${user.userId}</th>
                <th class="col-md-3">${user.name}</th>
                <th class="col-md-3">${user.email}</th>
                <th class="col-md-3"><a href="/user/update?userId=${user.userId}" class="btn btn-success" role="button">수정</a></th>
            </tr>
            </c:forEach>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
</body>
</html>