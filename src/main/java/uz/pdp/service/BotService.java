package uz.pdp.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import uz.pdp.enums.State;
import uz.pdp.enums.constants.Constants;
import uz.pdp.enums.constants.ConstantsLesson;
import uz.pdp.markups.InlineMarkups;
import uz.pdp.markups.MarkUps;
import uz.pdp.utils.Utils;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class BotService {
    private InlineMarkups inlineMarkups = new InlineMarkups();
    public static BotService botService;

    public static BotService getInstance() {
        if (botService == null) {
            botService = new BotService();
        }
        return botService;
    }

    public SendMessage requestContact(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "\t Welcome to our IT course \t Please share contact");
        sendMessage.setReplyMarkup(MarkUps.contactButton());
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
}
