package uz.pdp.service;

import lombok.SneakyThrows;
import uz.pdp.enums.State;
import uz.pdp.models.User;
import uz.pdp.utils.ConnectUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class UserService {
    private static Connection connection = ConnectUtils.getConnection();

    @SneakyThrows
    public String addUser(User user) {
        Statement statement = connection.createStatement();
        String query = "select * from add_user('%s','%s','%s','%s','%s','%s')";
        ResultSet resultSet = statement.executeQuery(
                String.format(query, user.getFirstName(), user.getLastName(), user.getUserName(), user.getPhoneNumber(), user.getChatId(), user, user.getState())
        );

        resultSet.next();
        return resultSet.getString("add_user");
    }

    @SneakyThrows
    public User findByChatId(String chatId) {
        Statement statement = connection.createStatement();
        String query = "select * from find_by_chat_id('%s')";
        ResultSet resultSet = statement.executeQuery(String.format(query, chatId));

        if (resultSet.next()) {
            User user = User.builder()
                    .id(resultSet.getObject("id", UUID.class))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .userName(resultSet.getString("username"))
                    .phoneNumber(resultSet.getString("phone_number"))
                    .chatId(resultSet.getString("chat_id"))
                    .state(State.valueOf(resultSet.getString("user_state")))
                    .build();
            return user;
        }

        return null;
    }

}
