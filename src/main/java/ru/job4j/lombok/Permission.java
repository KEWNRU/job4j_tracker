package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission {
    private int id;
    @Setter
    @EqualsAndHashCode.Include
    private String name;
    @Singular("rules")
    private List<String> rules;
}