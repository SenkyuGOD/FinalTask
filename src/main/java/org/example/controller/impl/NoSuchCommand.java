package org.example.controller.impl;

import org.example.controller.Command;

public class NoSuchCommand implements Command {
    @Override
    public String execute(String request) {
        return "Ошибка запроса";
    }
}
