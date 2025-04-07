package controller;

import core.db.MemoryUserRepository;
import core.db.Repository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jwp.model.User;

import static controller.SessionKey.USER_SESSION_KEY;

public class LoginController implements Controller {
    Repository repository = MemoryUserRepository.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            return "/user/updateForm.jsp";
        }
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User userData = repository.findUserById(userId);

        if (userData == null ||!userData.matchPassword(password)) {
            // 비밀번호 틀림
            return "/user/login_failed.jsp";
        }
        // 로그인 성공하면 세션에 저장
        HttpSession session = req.getSession();
        session.setAttribute(USER_SESSION_KEY.getKey(), userData);
        return "redirect:/";
    }
}
