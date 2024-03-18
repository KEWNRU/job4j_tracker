package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class ShowAction implements UserAction {

    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Вывод всех элементов";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("Вывод всех элементов");
        List<Item> items = store.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок.");
        }
        return true;
    }
}