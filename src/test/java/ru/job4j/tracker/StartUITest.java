package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String editName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new EditItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(editName);
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameAction() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", one.getName(), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindItemByName(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Find items by name ===" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. === Find items by name ===" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByIdAction() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindItemById(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Find item by id ===" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. === Find item by id ===" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindAllAction() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}