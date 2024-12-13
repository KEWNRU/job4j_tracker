package ru.job4j.lombok;

import lombok.*;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @EqualsAndHashCode.Include
    @NonNull
    private int id;

    @Setter
    private String name;
}