package controller;

import core.db.MemoryUserRepository;
import core.db.Repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jwp.model.User;

import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserFormController extends HttpServlet {
    // 아니 왜 repository 인터페이스 만들어놓고 안쓰는거임?
    //걍 써버림요,,.
    Repository repository = MemoryUserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId=req.getParameter("userId");
        User userData = repository.findUserById(userId);

        req.setAttribute("user",userData);

        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User newUser = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        repository.addUser(newUser);

        resp.sendRedirect("/user/userList");
    }
}
