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

import static controller.SessionKey.USER_SESSION_KEY;

@WebServlet("/user/update")
public class UpdateUserFormController extends HttpServlet {
    Repository repository = MemoryUserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        User userData = repository.findUserById(userId);

        HttpSession session = req.getSession();
        User loginedUser = (User) session.getAttribute(USER_SESSION_KEY.getKey());
        if (userData.isSameUser(loginedUser)) {
            req.setAttribute("users", userData);

            RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
            rd.forward(req, resp);
            return;
        }

        resp.sendRedirect("/user/userList");

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
