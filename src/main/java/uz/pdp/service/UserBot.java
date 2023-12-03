package uz.pdp.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.models.User;
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
    static UserService userService = new UserService();
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            String text = message.getText();
            User findUser = userService.findByChatId(chatId);

            if (findUser == null) {
//                User user = new User();
                if (message.hasContact()) {
                    Contact contact = message.getContact();
                    String phoneNumber = contact.getPhoneNumber();
                    System.out.println(phoneNumber);

                    User user = User.fromContact(contact);
                    user.setUserName(message.getChat().getUserName());

                    userService.addUser(user);

                    System.out.println(user.getFirstName());
                } else {
                    execute(botService.requestContact(chatId));
                }
            }
        }


    }


}
