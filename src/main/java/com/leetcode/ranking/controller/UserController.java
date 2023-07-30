package com.leetcode.ranking.controller;

import com.leetcode.ranking.entity.User;
import com.leetcode.ranking.services.UserService;
import com.leetcode.ranking.services.UserService.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        ServiceResult result = userService.addUser(user);
        if (result == ServiceResult.SUCCESS) {
            String message = "The user " + user.getName() + " is added successfully in the database";
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .header("Content-Type", "application/json")
                                 .body("{\"message\":\"" + message + "\"}");
        } else {
            String message = "Failed to add the user " + user.getName() + " to the database";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .header("Content-Type", "application/json")
                                 .body("{\"message\":\"" + message + "\"}");
        }
    }


    @PutMapping("/user/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable("userId") int id) {
        user.setId(id);
        ServiceResult result = userService.updateUser(user, id);
        if (result == ServiceResult.SUCCESS) {
        	System.out.println("Put called");
        	return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body("{\"message\":\"" + "updated success" + "\"}");
        } 
        else {
        	System.out.println("Put else called"); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update the user " + user.getName() + " in the database");
        }
    }  

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int id) {
        ServiceResult result = userService.deleteUser(id);
        if (result == ServiceResult.SUCCESS) {
            return ResponseEntity.ok("The user with id " + id + " is successfully deleted from the database");
        } 
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete the user with id " + id + " from the database");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserWithId(@PathVariable("userId") int id){
        Optional<User> user = userService.getUserWithId(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } 
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
