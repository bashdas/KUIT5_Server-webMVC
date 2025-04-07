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
      <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
         <div class="panel panel-default content-main">
             <form name="question" method="post" action="">
                 <div class="form-group">
                     <label for="writer">글쓴이</label>
                     <input class="form-control" id="writer" name="writer" placeholder="글쓴이"/>
                 </div>
                 <div class="form-group">
                     <label for="title">제목</label>
                     <input type="text" class="form-control" id="title" name="title" placeholder="제목"/>
                 </div>
                 <div class="form-group">
                     <label for="contents">내용</label>
                     <textarea name="contents" id="contents" rows="5" class="form-control"></textarea>
                 </div>
                 <button type="submit" class="btn btn-primary clearfix pull-right" style="margin-top:10px;">질문하기</button>
                 <div class="clearfix" />
             </form>
           </div>
       </div>
   </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>