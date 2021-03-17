package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserController {
  /* asd
      C - @PostMapping
      R - @GetMapping
      U - @PutMapping
      D - @DeleteMapping
   */

    @Autowired
    private UserService userService;

    // /rest/users
    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public void updateById(@RequestBody User user, @PathVariable long id) {
        userService.updateById(id, user);
    }

    @PostMapping("/users")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletRequest req) {
        return userService.login(user, req);
    }

    @GetMapping("/whoami")
    public User whoAmI() {
        return userService.findCurrentUser();
    }

}
