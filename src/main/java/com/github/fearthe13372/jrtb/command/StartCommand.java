package com.github.fearthe13372.jrtb.command;

import com.github.fearthe13372.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Привет. Я JavaRush Telegram Bot. Я помогу тебе посмотреть статьи тех авторов, которые тебе интересны! Я еще маленький и только учусь";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execute(Update update){
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);
    }
}
