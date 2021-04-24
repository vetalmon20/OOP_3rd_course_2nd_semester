package app.command;

import app.model.ingredient.Ingredient;
import app.model.order.Order;
import app.service.IngredientsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.util.List;

public class AdminCommand extends Command{
    private static final Logger logger = LogManager.getLogger(AdminCommand.class);
    private final IngredientsService ingredientsService = new IngredientsService();

    public AdminCommand() {
        path = Command.pagesPath + "admin.jsp";
    }
    @Override
    public String execute(HttpServletRequest request) {
        logger.info("Starting executing Admin command");
        if(request.getParameter("updated") != null) {
            try {
                List<Ingredient> ingredients = ingredientsService.getIngredients();
                for(Ingredient ingr : ingredients) {
                    ingredientsService.setIngredientAmount(ingr.getId(), 20L);
                }
                ingredients = ingredientsService.getIngredients();
                request.setAttribute("ingredients", ingredients);
            } catch (Exception e) {
                logger.error("Cannot receive ingredients {}", e.getMessage());
            }
        } else {
            try {
                List<Ingredient> ingredients = ingredientsService.getIngredients();
                request.setAttribute("ingredients", ingredients);
            } catch (Exception e) {
                logger.error("Cannot receive ingredients {}", e.getMessage());
            }
        }

        logger.info("Admin command is successfully executed");
        return path;
    }
}
