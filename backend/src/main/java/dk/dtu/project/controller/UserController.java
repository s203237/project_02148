package dk.dtu.project.controller;

import dk.dtu.project.model.LoginRequest;
import dk.dtu.project.model.UserTuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dk.dtu.project.service.UserService;
import dk.dtu.project.model.User;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // User Registration API
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user.getEmail(), user.getName(), user.getPassword());
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    // User Login API
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            User authenticatedUser = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
            if (authenticatedUser != null) {
                // Returns user information if login is successful
                return ResponseEntity.ok(authenticatedUser);
            } else {
                // Return authentication error if email or password is incorrect
                return ResponseEntity.status(401).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
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


