package ru.gav19770210.javapro.task05.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private Date timestamp;
    private String message;
    private String description;
}
