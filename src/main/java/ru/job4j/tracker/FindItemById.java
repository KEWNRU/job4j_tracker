package ru.job4j.tracker;

import java.sql.SQLException;

public class FindItemById implements UserAction {

    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Поиск по id";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("Поиск по id");
        int id = input.askInt("Введите id: ");
        Item item = store.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
