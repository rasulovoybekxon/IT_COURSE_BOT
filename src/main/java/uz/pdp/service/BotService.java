package uz.pdp.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import uz.pdp.markups.InlineMarkups;
import uz.pdp.markups.MarkUps;
import uz.pdp.utils.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BotService {
    private InlineMarkups inlineMarkups = new InlineMarkups();
    private final Connection connection = Utils.getConnection();

    private static String lessonPth = "D:\\Java basic\\Main\\main\\JavaBackend\\IT-COURSE-BOT\\src\\main\\resources\\01_dars_Dasturlash_Kompyuterning_texnik_va_dasturiy_ta’minoti_C++.pdf";

    public SendMessage requestContact(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "\t Welcome to our IT course \t Please share contact");
        sendMessage.setReplyMarkup(MarkUps.contactButton());
        return sendMessage;
    }

    public SendMessage categoryAvailableCourse(String chatId, String category) {
        SendMessage sendMessage = new SendMessage(chatId, "All " + category
                + " Backend courses we have");
        sendMessage.setReplyMarkup(inlineMarkups.availableCourses(category));
        return sendMessage;
    }

    public SendMessage categories(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Select one of them");
        sendMessage.setReplyMarkup(MarkUps.showCategories());
        return sendMessage;
    }

    public SendMessage showMainManu(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "MAIN MANU");
        sendMessage.setReplyMarkup(MarkUps.mainManu());
        return sendMessage;
    }

    public SendMessage startCourses(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Click the start button and join us");
        sendMessage.setReplyMarkup(MarkUps.startCourse());
        return sendMessage;
    }

    public SendMessage showLessons(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Your lessons");
        sendMessage.setReplyMarkup(inlineMarkups.models());
        return sendMessage;
    }

    public SendMessage showLessons2(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Your lessons");
        sendMessage.setReplyMarkup(inlineMarkups.models2());
        return sendMessage;
    }

    @SneakyThrows
    public SendMessage description(String chatId, String date) {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from courses");

        SendMessage sendMessage = new SendMessage();
        while (resultSet.next()) {
            if (date.equals(resultSet.getString("course_name"))) {
                sendMessage.setChatId(chatId);
                sendMessage.setText(resultSet.getString("description"));
            }
        }
        return sendMessage;
    }


    public EditMessageText editShowLesson2(String chatId, Integer messageId) {
//        EditMessageReplyMarkup markup = new EditMessageReplyMarkup(chatId, messageId, inlineMessageId, new InlineKeyboardMarkup());
        EditMessageText messageText = new EditMessageText();
        messageText.setText("Part 2");
        messageText.setChatId(chatId);
//        messageText.setInlineMessageId(inlineMessageId);
        messageText.setMessageId(messageId);
        messageText.setReplyMarkup(new InlineKeyboardMarkup());
        return messageText;

    }

    public SendMessage getUserALLCourses(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Your courses.");
        sendMessage.setReplyMarkup(MarkUps.showUserCourses(chatId));
        return sendMessage;
    }

    public SendMessage CPlusPLusLessons(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Your courses.");
        sendMessage.setReplyMarkup(MarkUps.CPlusPlus());
        return sendMessage;
    }



}
