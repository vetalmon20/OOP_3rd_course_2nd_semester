package app.servlets;

import app.dao.DaoFactory;
import app.dao.IngredientsDao;
import app.dao.UsersDao;
import app.model.Model;
import app.model.drink.Drink;
import app.model.ingredient.Ingredient;
import app.model.user.User;
import app.model.user.UserBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddServlet extends HttpServlet {

    private final UsersDao usersDao;

    public AddServlet() {
        usersDao = DaoFactory.createUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* String name = req.getParameter("name");
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


        req.setAttribute("userName", name);
        doGet(req, resp);*/

        doGet(req, resp);
    }
}
