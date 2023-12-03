package uz.pdp.markups;

import lombok.SneakyThrows;
import org.glassfish.jersey.internal.guava.Iterators;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.pdp.models.Constants;
import uz.pdp.utils.ConnectUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InlineMarkups {
    private Connection connection = ConnectUtils.getConnection();

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
}
