package ru.job4j.tracker;

import java.sql.SQLException;

public class EditItemAction implements UserAction {

    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Редактирование";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("Редактирование");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (store.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}