package sample.controller;

import sample.view.ConsoleView;

public abstract class AbstractController {
    protected final ConsoleView consoleView;

    public AbstractController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }
}
