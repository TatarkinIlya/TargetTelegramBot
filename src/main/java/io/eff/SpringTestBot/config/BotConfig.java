package io.eff.SpringTestBot.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@Data
@PropertySource("application.yaml")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotConfig {

    @Value("${telegram.bot-name}")
    String botName;

    @Value("${telegram.bot-token}")
    String botToken;

    @Value("${telegram.webhook-path}")
    String webHookPath;
}
