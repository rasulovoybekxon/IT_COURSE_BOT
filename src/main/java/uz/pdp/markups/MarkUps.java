package uz.pdp.markups;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.enums.constants.Constants;
import uz.pdp.utils.Utils;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarkUps {
    private static Connection connection = Utils.getConnection();

    public static ReplyKeyboardMarkup contactButton() {
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("\uD83D\uDCDEShare phone number");
        button.setRequestContact(true);

        row.add(button);
        return ReplyKeyboardMarkup.builder()
                .keyboard(List.of(row))
                .resizeKeyboard(true)
                .build();
    }

    public static ReplyKeyboardMarkup mainManu() {
        ArrayList<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(Constants.COURSES);
        row.add(Constants.POPULAR);
        row.add(Constants.TRENDING);

        rows.add(row);

        row = new KeyboardRow();
        row.add(Constants.MY_COURSES);

        rows.add(row);
        return ReplyKeyboardMarkup.builder()
                .resizeKeyboard(true)
                .keyboard(rows)
                .build();
    }

    @SneakyThrows
    public static ReplyKeyboardMarkup showCategories() {

        Statement statement = connection.createStatement();
        ArrayList<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(Constants.BACKEND);
        rows.add(row);

        row = new KeyboardRow();
        row.add(Constants.FRONTEND);


        row.add(Constants.MOBILE);
        rows.add(row);

        row = new KeyboardRow();
        row.add(Constants.BACK);
        rows.add(row);

        return ReplyKeyboardMarkup.builder().resizeKeyboard(true).keyboard(rows).build();
    }

    public static ReplyKeyboardMarkup startCourse() {

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        row.add("Start course");
        row.add("Back");
        rows.add(row);

        return ReplyKeyboardMarkup.builder().resizeKeyboard(true).keyboard(rows).build();

    }

}
