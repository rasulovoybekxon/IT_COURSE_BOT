package uz.pdp.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.pdp.markups.InlineMarkups;
import uz.pdp.markups.MarkUps;

public class BotService {
    private InlineMarkups inlineMarkups = new InlineMarkups();

    public SendMessage requestContact(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Please share your phone number");
        sendMessage.setReplyMarkup(MarkUps.contactButton());
        return sendMessage;
    }

    public SendMessage categoryCourse(String chatId, String category) {
        SendMessage sendMessage = new SendMessage(chatId, "Select");
        sendMessage.setReplyMarkup(inlineMarkups.availableCourses(category));
        return sendMessage;
    }
}
