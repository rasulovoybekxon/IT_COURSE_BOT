package uz.pdp.markups;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.utils.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InlineMarkups {
    private Connection connection = Utils.getConnection();

    @SneakyThrows
    public InlineKeyboardMarkup availableCourses(String category) {

        Statement statement = connection.createStatement();
        String query = "select * from courses where category = '%s'";
        ResultSet resultSet = statement.executeQuery(String.format(query, category));

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

    public InlineKeyboardMarkup models() {

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton("1-lesson. Programming computer hardware and software");

        button.setCallbackData("1-lesson. Programming computer hardware and software");

    }
}
