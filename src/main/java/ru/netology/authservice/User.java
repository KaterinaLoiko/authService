package ru.netology.authservice;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class User {
    String userName;
    String password;
}
