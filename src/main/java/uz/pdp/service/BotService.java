package uz.pdp.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BotService {

    public static SendMessage requestContact(String chatId){
        SendMessage sendMessage = new SendMessage(chatId, "Please share your phone number");
        sendMessage.setReplyMarkup(MarkUps.contactButton());
        return sendMessage;
    }
}
