package com.github.fearthe13372.jrtb.command;

import com.github.fearthe13372.jrtb.command.Command;
import com.github.fearthe13372.jrtb.command.CommandContainer;
import com.github.fearthe13372.jrtb.command.CommandName;
import com.github.fearthe13372.jrtb.command.UnknownCommand;
import com.github.fearthe13372.jrtb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }
    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values()).forEach(commandName -> {
            Command command = commandContainer.retrieveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class,command.getClass());
        });
    }
    @Test
    public void shouldReturnUnknownCommand(){
        String unknownCommand = "/dssafasd";
        Command command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknownCommand.class,command.getClass());
    }
}
