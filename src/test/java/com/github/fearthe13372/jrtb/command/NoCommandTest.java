package com.github.fearthe13372.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.fearthe13372.jrtb.command.CommandName.NO;
import static com.github.fearthe13372.jrtb.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
