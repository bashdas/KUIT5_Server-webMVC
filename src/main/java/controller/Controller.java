package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {

    String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
