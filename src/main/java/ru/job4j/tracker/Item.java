package ru.job4j.tracker;

import lombok.Data;

import javax.persistence.*;

import ru.job4j.toone.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "items")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "participates",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> participates = new ArrayList<>();

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }
}
