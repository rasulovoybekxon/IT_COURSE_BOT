package uz.pdp.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import uz.pdp.markups.InlineMarkups;
import uz.pdp.markups.MarkUps;

public class BotService {
    private InlineMarkups inlineMarkups = new InlineMarkups();

    public SendMessage requestContact(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "\t Welcome to our IT course \t Please share contact");
        sendMessage.setReplyMarkup(MarkUps.contactButton());
        return sendMessage;
    }

    public SendMessage categoryAvailableCourse(String chatId, String category) {
        SendMessage sendMessage = new SendMessage(chatId, "Select");
        sendMessage.setReplyMarkup(inlineMarkups.availableCourses(category));
        return sendMessage;
    }

    public SendMessage showCategory(String chatId) {
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
        SendMessage sendMessage = new SendMessage(chatId, "Select one of them");
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
        sendMessage.setReplyMarkup(inlineMarkups.models());
        return sendMessage;
    }

    public EditMessageText editShowLesson2(String chatId, Integer messageId, String inlineMessageId) {
//        EditMessageReplyMarkup markup = new EditMessageReplyMarkup(chatId, messageId, inlineMessageId, new InlineKeyboardMarkup());
        EditMessageText messageText = new EditMessageText();
        messageText.setText("Part 2");
        messageText.setChatId(chatId);
        messageText.setInlineMessageId(inlineMessageId);
        messageText.setMessageId(messageId);
        messageText.setReplyMarkup(new InlineKeyboardMarkup());
        return messageText;

    }
}
