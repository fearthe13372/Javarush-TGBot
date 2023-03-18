package com.github.fearthe13372.jrtb.bot;
import com.github.fearthe13372.jrtb.command.CommandContainer;
import com.github.fearthe13372.jrtb.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Locale;

/**
 * Telegrambot for Javarush Community from Javarush community.
 */
@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot{
    public static String Command_prefix = "/";
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public JavaRushTelegramBot (){
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
           String message = update.getMessage().getText().trim();
           if(message.startsWith(Command_prefix))
           {
               String commandIdentifier = message.split(" ")[0].toLowerCase();
               commandContainer.retrieveCommand(commandIdentifier).execute(update);
           }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }
    @Override
    public String getBotToken() {
        return token;
    }
}
