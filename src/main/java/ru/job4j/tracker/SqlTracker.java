package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO items (name, created) VALUES  (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        boolean rsl;
        try (PreparedStatement statement = connection.prepareStatement("update items set name = ?,"
                + " created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
            return rsl;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items;")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                rsl.add(new Item(rs.getInt("id"), rs.getString("name")));
            }
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from items where name = ?;")) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                rsl.add(new Item(rs.getInt("id"), rs.getString("name")));
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item rsl = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from items where id = ?;")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                rsl = new Item(rs.getInt("id"), rs.getString("name"));
            }
        }
        return rsl;
    }
}