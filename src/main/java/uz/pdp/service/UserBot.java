package uz.pdp.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.enums.State;
import uz.pdp.enums.constants.Constants;
import uz.pdp.markups.MarkUps;
import uz.pdp.models.User;
import uz.pdp.utils.TelegramUtils;
import uz.pdp.utils.Utils;

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
//            Long chatId1 = message.getChatId();
            String chatId = message.getChatId().toString();
            User findUser = userService.findByChatId(chatId);
            String text = update.getMessage().getText();
            if (findUser == null) {

                if (message.hasContact()) {
                    Contact contact = message.getContact();
                    String phoneNumber = contact.getPhoneNumber();
                    System.out.println(phoneNumber);

                    User user = User.fromContact(contact);
                    user.setUserName(message.getChat().getUserName());

                    userService.addUser(user);

                    System.out.println(user.getFirstName());
                    execute(botService.menu(chatId));

                } else {
                    execute(botService.requestContact(chatId));
                }
            }



            switch (findUser.getState()){
                case REGISTERED -> {
                    if(text.equalsIgnoreCase(Constants.COURSES)){
//                        execute(botService.getFromCategory(chatId,text));

                        execute(botService.categories(chatId));
                        findUser.setState(State.CATEGORY);
                        userService.updateState(String.valueOf(State.CATEGORY),chatId);
                    }else if(text.equals(Constants.BACK)){
                        execute(botService.menu(chatId));
                    }
                }
                case CATEGORY -> {
                    if (text.equalsIgnoreCase(Constants.BACKEND)) {
                        execute(botService.getFromCategory(chatId, text));
//                        Integer messageId = execute(botService.getFromCategory(chatId, text)).getMessageId();
//                        execute(new EditMessageText(chatId,messageId,));

                    } else if (text.equalsIgnoreCase(Constants.BACK)) {
                       findUser.setState( userService.updateState(String.valueOf(State.REGISTERED),chatId));
                        execute(botService.menu(chatId));
                    }
                }


            }


        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();

            switch (data) {
                case Constants.BACKEND -> {

                }
            }
        }


    }


}
