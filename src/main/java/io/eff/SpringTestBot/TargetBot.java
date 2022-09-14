package io.eff.SpringTestBot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;

import java.io.IOException;

@Slf4j
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TargetBot extends SpringWebhookBot {
    String botPath;
    String botUsername;
    String botToken;


    public TargetBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    @SneakyThrows
    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        log.info(update.toString());
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();


            try {
                execute(new SendMessage(String.valueOf(chat_id), "Привет, "  + update.getMessage().getFrom().getLastName() + " " + update.getMessage().getFrom().getFirstName() + "! По твоему запросу \"" + update.getMessage().getText() + "\" пока ничего не найдено или бот не знает такую команду"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private BotApiMethod<?> handleUpdate(Update update) {
        return null;
    }
}