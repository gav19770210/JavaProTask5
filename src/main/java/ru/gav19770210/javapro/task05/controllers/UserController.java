package ru.gav19770210.javapro.task05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gav19770210.javapro.task05.entities.User;
import ru.gav19770210.javapro.task05.services.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}/get")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/user/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{name}/get-by-name")
    public User getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @PostMapping(value = "/user/create")
    public HttpStatus createUser(@RequestBody User user) {
        var userCreate = userService.createUser(user);
        return HttpStatus.OK;
    }

    @PostMapping(value = "/user/update")
    public HttpStatus updateUser(@RequestBody User user) {
        var userUpdate = userService.updateUser(user);
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/user/{id}/delete")
    public HttpStatus deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return HttpStatus.OK;
    }
}
