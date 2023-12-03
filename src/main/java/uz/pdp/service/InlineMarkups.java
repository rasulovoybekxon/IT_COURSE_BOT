package uz.pdp.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.utils.ConnectUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InlineMarkups {
    private Connection connection = ConnectUtils.getConnection();

    @SneakyThrows
    public InlineKeyboardMarkup availableCourses() {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from courses");

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button;

        while (resultSet.next()) {

            button = new InlineKeyboardButton(resultSet.getString("course_name"));
            button.setCallbackData(resultSet.getString("course_name"));
            button.setCallbackData("Back");
            row.add(button);
            rows.add(row);
            row = new ArrayList<>();
        }
        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }
}
