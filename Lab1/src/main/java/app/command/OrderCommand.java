package app.command;

import app.model.drink.Drink;
import app.model.ingredient.Ingredient;
import app.model.order.Order;
import app.model.order.OrderBuilder;
import app.model.user.User;
import app.service.DrinksService;
import app.service.IngredientsService;
import app.service.OrdersService;
import app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderCommand extends Command {
    static final Logger logger = LogManager.getLogger(OrderCommand.class);
    private final IngredientsService ingredientsService = new IngredientsService();
    private final DrinksService drinksService = new DrinksService();
    private final OrdersService orderService = new OrdersService();
    private final UserService userService = new UserService();

    public OrderCommand() {
        path = Command.pagesPath + "order.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("Executing order command");

        //This if recognizes whether I am currently processing an order or go to order jsp
        if(request.getParameter("drink") == null) {
            int finalSum = Integer.parseInt(request.getParameter("finalCostHName"));
            String ingrsIdStr = request.getParameter("finalDrinkIngrsHName");

            List<Long> ingrsId = new ArrayList<>();
            if(ingrsIdStr.length() > 0) {
                ingrsId = Arrays.stream(ingrsIdStr
                    .split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            }
            int drinkId = Integer.parseInt(request.getParameter("finalDrinkIdHName"));
            int drinkQuantity = Integer.parseInt(request.getParameter("finalDrinkQuantHName"));

            try {
                Drink currDrink = drinksService.getDrinkById((long) drinkId);
                ingrsId.addAll(currDrink.getIngredientIds());
                //change ingr amount corresponding to drinks quantity
                for(int i = 0; i < drinkQuantity; i++) {
                    for (Long aLong : ingrsId) {
                        Ingredient ingr = ingredientsService.getIngredient(aLong);
                        ingredientsService.setIngredientAmount(ingr.getId(), ingr.getAmount() - 1);
                    }
                }
                User currUser = (User) request.getSession().getAttribute("user");
                Order newOrder = new OrderBuilder().setUserEmail(currUser.getEmail())
                        .setCost((long) finalSum)
                        .setDate(LocalDate.now())
                        .setDrinkName(currDrink.getName())
                        .build();
                orderService.addOrder(newOrder);
                currUser.setMoney(currUser.getMoney() - finalSum);
                userService.setMoney(currUser.getEmail(), currUser.getMoney() - finalSum);

            } catch (Exception ex) {
                logger.warn("Cannot proceed the order with such values:" + finalSum +  " "
                        + drinkId + " " + drinkQuantity + ". {}", ex.getMessage());
            }
            return path;
        }

        int id = Integer.parseInt(Optional.ofNullable(request.getParameter("drink")).orElse("100"));
        Drink drink;
        try {
            drink = drinksService.getDrinkById((long) id);
            List<String> drinkIngredients = ingredientsService.getIngredientNames(drink.getIngredientIds());
            List<Ingredient> ingredients = ingredientsService.getIngredients();

            request.setAttribute("drinkCost", drink.getCost());
            request.setAttribute("drinkName", drink.getName());
            request.setAttribute("drinkIngr", drinkIngredients);
            request.setAttribute("drinkId", id);
            request.setAttribute("allIngr", ingredients);
        } catch (Exception ex) {
            logger.warn("There is some issues with order command: {}", ex.getMessage());
        }

        return path;
    }
}