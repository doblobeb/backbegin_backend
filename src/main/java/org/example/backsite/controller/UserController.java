package org.example.backsite.controller;

import org.example.backsite.model.User;
import org.example.backsite.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestParam String email, @RequestParam String password) {
        User user = userService.findById(id);
        user.setEmail(email);
        user.setPassword(password);
        return ResponseEntity.ok(userService.save(user));
    }
}
