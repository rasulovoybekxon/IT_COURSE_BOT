package uz.pdp.markups;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.enums.constants.Constants;
import uz.pdp.models.Course;
import uz.pdp.service.UserService;
import uz.pdp.utils.Utils;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarkUps {
    private static Connection connection = Utils.getConnection();
    static UserService userService = new UserService();

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

    public static ReplyKeyboardMarkup showUserCourses(String chatId){
        ArrayList<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        ArrayList<Course> userCourses = userService.getUserCourses(chatId);

        for (Course userCourse : userCourses) {
            row.add(userCourse.getCourseName());
            rows.add(row);
            row = new KeyboardRow();
        }
        row.add(Constants.BACK);
        rows.add(row);

        return ReplyKeyboardMarkup.builder().keyboard(rows).resizeKeyboard(true).build();
    }

    public static ReplyKeyboardMarkup CPlusPlus() {

        ArrayList<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();


//        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
//        List<InlineKeyboardButton> row = new ArrayList<>();

        KeyboardButton button = new KeyboardButton("1-dars. Dasturlash kompyuterning texnik va dasturiy ta'minoti");

//        button.setCallbackData("1-dars.Dasturlash kompyuterning texnik va dasturiy ta'minoti");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("2-dars.Ma'lumot va axborot.Axborotning o`lchov birliklari-Sanoq");
//        button.setCallbackData("2-dars.Ma'lumot va axborot.Axborotning o`lchov birliklari-Sanoq");

        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("3-dars.C++ da ma'lumot turlari,o`zfaruvchilar va literallar");
//        button.setCallbackData("3-dars.C++ da ma'lumot turlari,o`zfaruvchilar va literallar");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("4-dars.C++ dasturlash tili  asosiy operatirlari");
//        button.setCallbackData("4-dars.C++ dasturlash tili  asosiy operatirlari");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("5-dars.Algoritm tushunchasi va turlari.Chiziqliy algoritmlar");
//        button.setCallbackData("5-dars.Algoritm tushunchasi va turlari.Chiziqliy algoritmlar");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();


        button = new KeyboardButton("6-dars.Mantiqiy amallar");
//        button.setCallbackData("6-dars.Mantiqiy amallar");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("7-dars.Massivlar bilan ishlash");
//        button.setCallbackData("7-dars.Massivlar bilan ishlash");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("8-dars.Shart operatori");
//        button.setCallbackData("8-dars.Shart operatori");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("9-dars.Tanlash operatori");
//        button.setCallbackData("9-dars.Tanlash operatori");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton("10-dars.Takrorlanuvchi operatorlar");
//        button.setCallbackData("10-dars.Takrorlanuvchi operatorlar");
        row.add(button);
        rows.add(row);
        row = new KeyboardRow();
        row.add(Constants.BACK);
        rows.add(row);

        return ReplyKeyboardMarkup.builder().resizeKeyboard(true).keyboard(rows).build();
    }

}
