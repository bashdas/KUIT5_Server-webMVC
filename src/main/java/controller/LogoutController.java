package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static controller.SessionKey.USER_SESSION_KEY;

public class LogoutController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)  {
        HttpSession session = req.getSession();
        session.removeAttribute(USER_SESSION_KEY.getKey());

        return "redirect:/";
    }
}
