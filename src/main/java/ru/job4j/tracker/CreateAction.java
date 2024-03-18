package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Создание элемениа";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("Создание элемениа");
        String name = input.askStr("ВВедите имя: ");
        Item item = new Item(name);
        store.add(item);
        out.println("Добавленная заявка: " + item);

        return true;
    }
}