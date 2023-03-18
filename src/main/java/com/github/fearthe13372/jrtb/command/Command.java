package com.github.fearthe13372.jrtb.command;
import org.telegram.telegrambots.meta.api.objects.Update;
public interface Command {
    void execute(Update update);
}
