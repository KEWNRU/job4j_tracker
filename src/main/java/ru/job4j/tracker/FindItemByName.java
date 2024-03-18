package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindItemByName implements UserAction {

    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Поиск по имени";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("Поиск по имени");
        String name = input.askStr("Введите имя: ");
        List<Item> items = store.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
