<!doctype html>
<html lang="ko">
<head>
    <%@ include file="../include/header.jspf" %>
</head>
<body>
<%@ include file="../include/navigation.jspf" %>
<div class="navbar-default">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="/index.jsp" class="nav-link px-2 link-secondary">Q&A</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
            <li><a href="/user/userList" class="nav-link px-2 link-dark">User List</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <a href="/user/login.jsp" type="button" class="btn btn-outline-primary me-2">Login</a>
            <a href="/user/form.jsp" type="button" class="btn btn-primary">Sign-up</a>
        </div>
    </header>
</div>

<div class="container" id="main">

    <main class="form-signin">

        <form name="sign-up" method="post" action="/user/signup">
            <div class="form-floating">
                <input type="text" class="form-control" value="${user.userId}" id="userId" name="userId" placeholder="Id" readonly>
                <label for="userId">User Id</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="password" name="password" value="${user.password}">
                <label for="password">Password</label>
            </div>
            <div class="form-floating">
                <input type="text" class="form-control" id="name" name="name" value="${user.name}">
                <label for="name">Name</label>
            </div>
            <div class="form-floating">
                <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                <label for="email">Email address</label>
            </div>
            <div style="height:10px;">
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Update</button>
        </form>
    </main>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>
</body>
</html>