package uz.pdp.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.models.Constants;

import java.util.ArrayList;
import java.util.List;

public class MarkUps {
    public static ReplyKeyboardMarkup contactButton(){
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("\uD83D\uDCDEShare phone number");
        button.setRequestContact(true);

        row.add(button);
        return ReplyKeyboardMarkup.builder()
                .keyboard(List.of(row))
                .resizeKeyboard(true)
                .build();
    }

    public static ReplyKeyboardMarkup showAllCourses(){
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


}
