package ru.job4j.tracker;

public class ExitAction implements UserAction {

    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Выход");
        return false;
    }
}
