package controller;


import core.db.MemoryUserRepository;
import core.db.Repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jwp.model.User;

import java.io.IOException;

@WebServlet("/user/login")
public class Logincontroller extends HttpServlet {
    Repository repository = MemoryUserRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User userData = repository.findUserById(userId);


        if (userData == null ||!userData.matchPassword(password)) {
            // 비밀번호 틀림
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }

        // 로그인 성공하면 세션에 저장
        HttpSession session = req.getSession();
        session.setAttribute("user", userData);

        resp.sendRedirect("/");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId=req.getParameter("userId");
        User userData = repository.findUserById(userId);

        req.setAttribute("user",userData);

        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req, resp);
    }



}
