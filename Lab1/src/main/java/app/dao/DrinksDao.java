package app.dao;

import app.model.drink.Drink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DrinksDao {
    private final static Logger logger = LogManager.getLogger(DrinksDao.class);
    private final Connection connection;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("sql");

    public DrinksDao(Connection connection) {
        this.connection = connection;
    }

    public List<Drink> getAll() {
        List<Drink> drinks = new ArrayList<>();
        ResultSet resultSet;

        try {
            PreparedStatement statement = connection.prepareStatement(resourceBundle.getString("drinks.findAll"));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Drink drink = ResultSetConverter.getDrinkFromResultSet(resultSet);

                drinks.add(drink);
            }
            logger.info("Drinks has been successfully received");
        } catch (SQLException ex) {
            logger.warn("Drinks are not reachable: {}", ex.getMessage());
        }
        return drinks;
    }

}
