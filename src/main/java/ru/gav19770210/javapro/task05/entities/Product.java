package ru.gav19770210.javapro.task05.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @NonNull
    private Long id;
    @NonNull
    private Long userId;
    @NonNull
    private String accountNumber;
    @NonNull
    private BigDecimal balance;
    @NonNull
    private ProductType type;
}
