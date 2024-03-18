package ru.job4j.tracker;

import java.sql.SQLException;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Удаление элемента";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("Удаление элемента");
        int id = input.askInt("Введите id: ");
        tracker.delete(id);
        out.println("Заявка удалена");
        return true;
    }
}