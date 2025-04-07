package controller;

import core.db.MemoryUserRepository;
import core.db.Repository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jwp.model.User;

import static controller.SessionKey.USER_SESSION_KEY;

public class UpdateUserFormController implements Controller {
    Repository repository = MemoryUserRepository.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            String userId = req.getParameter("userId");
            User userData = repository.findUserById(userId);

            HttpSession session = req.getSession();
            User loginedUser = (User) session.getAttribute(USER_SESSION_KEY.getKey());
            if (userData.isSameUser(loginedUser)) {
                req.setAttribute("users", userData);

                return "/user/updateForm.jsp";
            }

            return "redirect:/user/userList";
        }

        User newUser = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        repository.addUser(newUser);

        return "redirect:/user/userList";
    }
}
