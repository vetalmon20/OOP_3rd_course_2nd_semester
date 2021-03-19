package app.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

import app.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {
    private final static Logger logger = LogManager.getLogger(UserDao.class);
    private final Connection connection;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("sql");

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public Optional<User> create(User entity) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(resourceBundle.getString("user.create"), Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entity.getPass());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBigDecimal(5, new BigDecimal(entity.getMoney()));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }

            logger.info("User has been successfully created");
            return Optional.of(entity);
        } catch (SQLException ex) {
            logger.warn("Error with adding a user: {}", ex.getMessage());
        }

        return Optional.empty();
    }

    public void changeMoney(String email, Long money) {
        try {
            PreparedStatement statement = connection.prepareStatement(resourceBundle.getString("user.changeMoney"));
            statement.setLong(1, money);
            statement.setString(2, email);
            statement.executeUpdate();
            logger.info("Money has been successfully changed");
        }  catch (SQLException ex) {
            logger.warn("Error with changing the money value of user:" + email + ". Error: {}", ex.getMessage());
        }
    }


}
