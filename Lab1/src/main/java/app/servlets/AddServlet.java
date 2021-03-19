package app.servlets;

import app.dao.DaoFactory;
import app.dao.UserDao;
import app.model.Model;
import app.model.user.User;
import app.model.user.UserBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class AddServlet extends HttpServlet {

    private final UserDao userDao;

    public AddServlet() {
        userDao = DaoFactory.createUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String email = req.getParameter("email");
        Long money = Long.parseLong(req.getParameter("money"));

        User user = new UserBuilder()
                .setEmail(email)
                .setName(name)
                .setMoney(money)
                .setPass(password)
                .build();

        Model model = Model.getInstance();
        model.add(user);

        userDao.create(user);

        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}
