package io.eff.SpringTestBot.config;

import io.eff.SpringTestBot.TargetBot;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@AllArgsConstructor
public class SpringConfig {
    private final BotConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getWebHookPath()).build();
    }

    @Bean
    public TargetBot springWebhookBot(SetWebhook setWebhook) {
        TargetBot bot = new TargetBot(setWebhook);

        bot.setBotPath(telegramConfig.getWebHookPath());
        bot.setBotUsername(telegramConfig.getBotName());
        bot.setBotToken(telegramConfig.getBotToken());

        return bot;
    }
}