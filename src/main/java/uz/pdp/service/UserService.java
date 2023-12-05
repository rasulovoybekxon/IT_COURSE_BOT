package uz.pdp.service;

import lombok.SneakyThrows;
import uz.pdp.enums.State;
import uz.pdp.models.Course;
import uz.pdp.models.User;
import uz.pdp.utils.Utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class UserService {
    private static Connection connection = Utils.getConnection();

    @SneakyThrows
    public String addUser(User user) {
        Statement statement = connection.createStatement();
        String query = "select * from add_user('%s','%s','%s','%s','%s','%s')";
        ResultSet resultSet = statement.executeQuery(
                String.format(query, user.getFirstName(), user.getLastName(), user.getUserName(), user.getPhoneNumber(), user.getChatId(), user.getState())
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

    @SneakyThrows
    public State updateState(String newState, String chatId){
        Statement statement = connection.createStatement();
        String query = "update users set user_state = '%s' where chat_id = '%s' ";
        boolean execute = statement.execute(String.format(query, newState,chatId));

        return State.valueOf(newState);
    }


    @SneakyThrows
    public ArrayList<Course> getUserCourses(String chatId) {
        Statement statement = connection.createStatement();
        String query = "select * from get_course('%s')";
        ResultSet resultSet = statement.executeQuery(
                String.format(query,chatId)
        );
        ArrayList<Course> courses = new ArrayList<>();
        while (resultSet.next()) {
            Course course = new Course();
            course.setCourseName(resultSet.getString("course_name"));
            course.setCompleted_course(resultSet.getBoolean("completed_course"));
            course.setId(resultSet.getObject("id", UUID.class));
            course.setNumberOfUsers(resultSet.getLong("number_of_users"));
            course.setCategory(resultSet.getString("category"));
            course.setDescription(resultSet.getString("description"));
            course.setLevel(resultSet.getInt("level"));

            courses.add(course);
        }

        resultSet.next();
        return courses;
    }

}
