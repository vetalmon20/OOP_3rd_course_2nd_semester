package app.servlets;

import app.command.CommandContainer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class MainServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
        config.getServletContext().setAttribute("loggedInUsers", new HashSet<>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().removeAttribute("errorMessage");
        req.getSession().removeAttribute("errorRegister");
        String commandName = req.getRequestURI();
        String command = CommandContainer.get(commandName).execute(req);


        if (command.contains("redirect:")) {
            command = command.replace("redirect:/", "/pages/");
            command = command.concat(".jsp");
            //resp.sendRedirect(command.replace("redirect:/", "/pages/"));
            resp.sendRedirect(command);
        } else {
            req.getRequestDispatcher(command).forward(req, resp);
        }
    }
}
