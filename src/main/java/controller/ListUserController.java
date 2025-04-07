package controller;

import core.db.MemoryUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jwp.model.User;

import java.util.Collection;

import static controller.SessionKey.USER_SESSION_KEY;

public class ListUserController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        Object value = session.getAttribute(USER_SESSION_KEY.getKey());

        if (value != null) {
            Collection<User> users = MemoryUserRepository.getInstance().findAll();
            req.setAttribute("users", users);
            return "/user/list.jsp";
        }
        return "redirect:/user/login.jsp";
    }
}
