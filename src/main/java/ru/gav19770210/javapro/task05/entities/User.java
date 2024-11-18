package ru.gav19770210.javapro.task05.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
