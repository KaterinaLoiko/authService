package ru.netology.authservice.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
}
