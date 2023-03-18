package com.github.fearthe13372.jrtb;
import com.github.fearthe13372.jrtb.bot.JavaRushTelegramBot;
import com.github.fearthe13372.jrtb.service.SendBotMessageService;
import com.github.fearthe13372.jrtb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private JavaRushTelegramBot javarushBot;
    @BeforeEach
    public void init(){
        javarushBot = Mockito.mock(JavaRushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushBot);
    }
    @Test
    public void shouldProperlySendMessage()throws TelegramApiException{

        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId,message);

        Mockito.verify(javarushBot).execute(sendMessage);

    }
}
