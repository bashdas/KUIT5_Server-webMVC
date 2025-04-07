package mvc;

import controller.*;


public class RequestMapper {

    public Controller getController(String path) {
        return switch (path) {
            case "/user/login" -> new LoginController();
            case "/user/userList" -> new ListUserController();
            case "/user/signup" -> new CreateUserController();
            case "/user/logout" -> new LogoutController();
            case "/user/update" -> new UpdateUserFormController();
            default -> new HomeController();
        };
    }
}