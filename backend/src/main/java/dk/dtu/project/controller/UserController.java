package dk.dtu.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dk.dtu.project.service.UserService;
import dk.dtu.project.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // User Registration API
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            boolean isRegistered = userService.addUser(user);
            if (isRegistered) {
                return ResponseEntity.ok("Registration successful!!");
            } else {
                return ResponseEntity.badRequest().body("Email already exists!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }


    // User Login API
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            boolean isAuthenticated = userService.authenticate(user.getEmail(), user.getPassword());
            if (isAuthenticated) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.badRequest().body("Invalid email or password!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    // API to update user information
    @PutMapping("/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody User updatedUser) {
        try {
            boolean isUpdated = userService.updateUser(email, updatedUser);
            if (isUpdated) {
                return ResponseEntity.ok("User updated successfully!");
            } else {
                return ResponseEntity.badRequest().body("User not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    // API to delete user
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        try {
            boolean isDeleted = userService.deleteUser(email);
            if (isDeleted) {
                return ResponseEntity.ok("User deleted successfully!");
            } else {
                return ResponseEntity.badRequest().body("User not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}


