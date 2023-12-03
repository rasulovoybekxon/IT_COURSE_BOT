package uz.pdp.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.utils.TelegramUtils;

public class UserBot extends TelegramLongPollingBot {
    private BotService botService = new BotService();

    @Override
    public String getBotUsername() {
        return TelegramUtils.BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TelegramUtils.BOT_TOKEN;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        String text = message.getText();
        execute(botService.categoryCourse(chatId, text));
    }


}
