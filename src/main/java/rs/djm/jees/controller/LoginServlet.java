package rs.djm.jees.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.djm.jees.model.data.UserSessionObject;
import rs.djm.jees.model.service.UserService;

/**
 * @author djm.rs
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserSessionObject userSession = UserService.getInstance()
                .getUserDataForSession(username, password);

        String nextPage = "WEB-INF/pages/home.jsp";

        if (userSession.isValidated()) {
            request.getSession().setAttribute("user", userSession);
        } else {
            final String[] errorMessages = new String[]{"Login error"};
            nextPage = "index.jsp";

            request.setAttribute("errors", errorMessages);
        }

        request.getRequestDispatcher(nextPage).forward(request, response);
    }

}
