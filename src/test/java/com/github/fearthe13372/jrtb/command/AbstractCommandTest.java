package com.github.fearthe13372.jrtb.command;

import com.github.fearthe13372.jrtb.bot.JavaRushTelegramBot;
import com.github.fearthe13372.jrtb.service.SendBotMessageService;
import com.github.fearthe13372.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {
    protected JavaRushTelegramBot javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(javaRushTelegramBot);
    abstract  String getCommandName();
    abstract  String getCommandMessage();
    abstract  Command getCommand();
    
    @Test
    public void shouldProperlyExecuteCommand()throws TelegramApiException{
        
        Long chatId = 1234566352L;
        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandMessage());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);
        //when
        getCommand().execute(update);

        //then
        Mockito.verify(javaRushTelegramBot).execute(sendMessage);
    }
}
