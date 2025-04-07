package mvc;

import controller.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private RequestMapper requestMapper = new RequestMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        String uri = req.getRequestURI();
        String path = uri.substring(req.getContextPath().length());

        Controller controller = requestMapper.getController(path);

        if (controller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Controller not found for path: " + path);
            return;
        }

        String view = controller.execute(req, resp);

        if (view.startsWith("redirect:")) {
            resp.sendRedirect(view.substring("redirect:".length()));
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        }
    }
}