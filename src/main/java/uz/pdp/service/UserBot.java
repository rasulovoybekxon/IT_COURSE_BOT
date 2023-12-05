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
        if (update.hasMessage()) {
            Message message = update.getMessage();
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
                    execute(botService.showMainManu(chatId));

                } else {
                    execute(botService.requestContact(chatId));
                }
            }


            switch (findUser.getState()) {
                case REGISTERED -> {
                    if (text.equalsIgnoreCase(Constants.COURSES)) {
//                        execute(botService.getFromCategory(chatId,text));

                        execute(botService.categories(chatId));
                        findUser.setState(State.CATEGORY);
                        userService.updateState(String.valueOf(State.CATEGORY), chatId);
                    } else if (text.equals(Constants.BACK)) {
                        execute(botService.showMainManu(chatId));
                    }
                }
                case CATEGORY -> {
                    if (Constants.BACKEND.equalsIgnoreCase(text)) {
                        userService.updateState(String.valueOf(State.SELECT), chatId);
                        execute(botService.categoryAvailableCourse(chatId, text));

                    } else if (text.equalsIgnoreCase(Constants.BACK)) {
                        findUser.setState(userService.updateState(String.valueOf(State.REGISTERED), chatId));
                        execute(botService.showMainManu(chatId));
                    }
                }
                case SELECT -> {
                    if (text.equals(Constants.BACK)) {
                        userService.updateState(State.REGISTERED.name(), chatId);
                        execute(botService.showMainManu(chatId));
                    }
                }
                case JAVA_BACKEND -> {
                    if (text.equals(Constants.START_COURSE)) {
                        userService.updateState(State.CHECK_LESSON.name(), chatId);
                        execute(botService.showLessons(chatId));
                    } else if (text.equals(Constants.BACK)) {
                        userService.updateState(State.CATEGORY.name(), chatId);
                        execute(botService.categories(chatId));
                    }
                }
                case CHECK_LESSON -> {
                    if (text.equals(Constants.BACK)) {
                        userService.updateState(State.CATEGORY.name(), chatId);
                        execute(botService.categories(chatId));
                    } else if (text.equals(Constants.START_COURSE)) {
                        execute(new SendMessage(chatId, "You has already added this course"));
                    }
                }
                case C_PLUS_PLUS -> {
                    if (text.equals(Constants.START_COURSE)) {
                        userService.updateState(State.CHECK_LESSON.name(), chatId);
//                        execute(botService.showLessons(chatId));
                    } else if (text.equals(Constants.BACK)) {
                        userService.updateState(State.CATEGORY.name(), chatId);
                        execute(botService.categories(chatId));
                    }
                }
            }

        } else if (update.hasCallbackQuery()) {

            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            Message message = callbackQuery.getMessage();
            String chatId = message.getChatId().toString();
            User currentUser = userService.findByChatId(chatId);

            switch (currentUser.getState()) {
                case SELECT -> {
                    if (data.equals(Constants.JAVA_BACKEND)) {
                        userService.updateState(String.valueOf(State.JAVA_BACKEND), chatId);
                        execute(botService.description(chatId, data));
                        execute(botService.startCourses(chatId));
                    } else if (data.equals(Constants.C_PLUS_PLUS)) {
                        userService.updateState(State.C_PLUS_PLUS.name(), chatId);
                        execute(botService.description(chatId, data));
                        execute(botService.startCourses(chatId));
                    }
                }
            }
        }

    }
}

