package com.example.shopping_demo.controller;

import com.example.shopping_demo.entity.User;
import com.example.shopping_demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/register/")
    public ResponseEntity<String> register(@RequestBody User user) {
        User createdUser = userService.registerUser(user);
        if (createdUser != null) {
            return ResponseEntity.ok("회원가입 완료");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //회원정보 조회
    @GetMapping("/profile/{user_id}")
    public ResponseEntity<User> userProfile(@PathVariable Long user_id) {
        User user = userService.getUser(user_id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //회원정보 수정
    @PutMapping("/update/{user_id}")
    public ResponseEntity<User> updateProfile(
            @PathVariable Long user_id,
            @RequestBody User user
    ) {
        User updatedUser = userService.updateUser(user_id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //회원 탈퇴
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long user_id
    ) {
        boolean deleted = userService.deleteUser(user_id);
        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
