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
            row.add(button);
            rows.add(row);
            row = new ArrayList<>();
        }
        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup models() {

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton("1-dars. Dasturlash kompyuterning texnik va dasturiy ta'minoti");

        button.setCallbackData("1-dars.Dasturlash kompyuterning texnik va dasturiy ta'minoti");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("2-dars.Ma'lumot va axborot.Axborotning o`lchov birliklari-Sanoq");
        button.setCallbackData("2-dars.Ma'lumot va axborot.Axborotning o`lchov birliklari-Sanoq");

        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("3-dars.C++ da ma'lumot turlari,o`zfaruvchilar va literallar");
        button.setCallbackData("3-dars.C++ da ma'lumot turlari,o`zfaruvchilar va literallar");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("4-dars.C++ dasturlash tili  asosiy operatirlari");
        button.setCallbackData("4-dars.C++ dasturlash tili  asosiy operatirlari");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("5-dars.Algoritm tushunchasi va turlari.Chiziqliy algoritmlar");
        button.setCallbackData("5-dars.Algoritm tushunchasi va turlari.Chiziqliy algoritmlar");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();


        button = new InlineKeyboardButton("6-dars.Mantiqiy amallar");
        button.setCallbackData("6-dars.Mantiqiy amallar");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("7-dars.Massivlar bilan ishlash");
        button.setCallbackData("7-dars.Massivlar bilan ishlash");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("8-dars.Shart operatori");
        button.setCallbackData("8-dars.Shart operatori");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("9-dars.Tanlash operatori");
        button.setCallbackData("9-dars.Tanlash operatori");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("10-dars.Takrorlanuvchi operatorlar");
        button.setCallbackData("10-dars.Takrorlanuvchi operatorlar");
        row.add(button);
        rows.add(row);
        row = new ArrayList<>();

        button = new InlineKeyboardButton("⬅\uFE0F");
        button.setCallbackData("⬅\uFE0F");
        row.add(button);

        button = new InlineKeyboardButton("➡\uFE0F");
        button.setCallbackData("➡\uFE0F");
        row.add(button);
        rows.add(row);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup models2() {

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton("11-dars.Takrorlanuvchi algoritmlar");

        button.setCallbackData("11-dars.Takrorlanuvchi algoritmlar");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("12-dars.C++ da takrorlash operatorlari (1)");
        button.setCallbackData("12-dars.C++ da takrorlash operatorlari (1)");

        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("12-dars.C++ da takrorlash operatorlari (2)");
        button.setCallbackData("12-dars.C++ da takrorlash operatorlari (2)");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("13-dars.Funksiya va prosedura tushunchasi.Kutibxonalari");
        button.setCallbackData("13-dars.Funksiya va prosedura tushunchasi.Kutibxonalari");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("14-dars.Funksiya bilan ishlash.User-defined functions");
        button.setCallbackData("14-dars.Funksiya bilan ishlash.User-defined functions");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();


        button = new InlineKeyboardButton("15-dars.Function overloading");
        button.setCallbackData("15-dars.Function overloading");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("16-dars.Recursive function");
        button.setCallbackData("16-dars.Recursive function");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("17-dars.Massvlar bilan ishlash (1)");
        button.setCallbackData("17-dars.Massvlar bilan ishlash (1)");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("18-dars.Massvlar bilan ishlash (2)");
        button.setCallbackData("18-dars.Massvlar bilan ishlash (2)");
        row.add(button);
        rows.add(row);

        row = new ArrayList<>();

        button = new InlineKeyboardButton("19-dars.Satrlar bilan ishlash (1)");
        button.setCallbackData("19-dars.Satrlar bilan ishlash (1)");
        row.add(button);
        rows.add(row);
        row = new ArrayList<>();

        button = new InlineKeyboardButton("20-dars.Satrlar bilan ishlash (2)");
        button.setCallbackData("20-dars.Satrlar bilan ishlash (2)");
        row.add(button);
        rows.add(row);
        row = new ArrayList<>();

        button = new InlineKeyboardButton("⬅\uFE0F");
        button.setCallbackData("⬅\uFE0F");
        row.add(button);

        button = new InlineKeyboardButton("➡\uFE0F");
        button.setCallbackData("➡\uFE0F");
        row.add(button);
        rows.add(row);


        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }
}
