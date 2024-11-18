package ru.gav19770210.javapro.task05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gav19770210.javapro.task05.entities.User;
import ru.gav19770210.javapro.task05.services.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/get/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        var userGet = userService.getUserById(id);
        if (userGet != null) {
            return userGet;
        } else {
            throw new NoSuchElementException("Не найден пользователь с ИД = " + id);
        }
    }

    @GetMapping(value = "/user/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/get-by-name/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @PostMapping(value = "/user/create")
    public HttpStatus createUser(@RequestBody User user) {
        var userCreate = userService.createUser(user);
        if (userCreate != null) {
            return HttpStatus.OK;
        } else {
            throw new IllegalArgumentException("Ошибка добавления пользователя с именем = " + user.getName());
        }
    }

    @PostMapping(value = "/user/update")
    public HttpStatus updateUser(@RequestBody User user) {
        var userGet = userService.getUserById(user.getId());
        if (userGet != null) {
            userService.updateUser(user);
            return HttpStatus.OK;
        } else {
            throw new NoSuchElementException("Не найден пользователь с ИД = " + user.getId());
        }
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Long id) {
        var userGet = userService.getUserById(id);
        if (userGet != null) {
            userService.deleteUserById(id);
            return HttpStatus.OK;
        } else {
            throw new NoSuchElementException("Не найден пользователь с ИД = " + id);
        }
    }
}
