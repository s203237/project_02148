package dk.dtu.project.service;

import dk.dtu.project.model.User;
import dk.dtu.project.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    //add new user/ create user
    public void registerUser(String email, String name, String password) throws Exception {
        if (userRepository.getUserByEmail(email) != null) {
            throw new RuntimeException("User already exists");
        }
        String encryptedPassword = passwordEncoder.encode(password);
        userRepository.addUser(email, name, password);
    }

    // authentication user (login)
    public User authenticate(String email, String password) throws InterruptedException {
        Object[] tuple = userRepository.getUserByEmail(email);
        if (tuple != null) {
            // Get the encrypted password from Space
            String storedPassword = (String) tuple[2];
            if (passwordEncoder.matches(password, storedPassword)) {
                return new User(null, (String) tuple[0], (String) tuple[1], storedPassword);
            }
        }
        return null;
    }
    // Get user information
    public User getUser(String email) throws InterruptedException {
        Object[] tuple = userRepository.getUserByEmail(email);
        if (tuple != null) {
            return new User(null,(String) tuple[0], (String) tuple[1], (String) tuple[2]);
        }
        return null;
    }

    // update user (profile)
    public boolean updateUser(String email, User updatedUser) throws InterruptedException {
        Object[] existingUser = userRepository.getUserByEmail(email);
        if (existingUser == null) {
            return false; // User does not exist
        }
        // Delete old user
        userRepository.deleteUserByEmail(email);
        //Encrypt new password
        String encryptedPassword = passwordEncoder.encode(updatedUser.getPassword());
        // Add new information
        userRepository.addUser(updatedUser.getEmail(), updatedUser.getName(), encryptedPassword);
        return true;
    }

    // delete user
    public boolean deleteUser(String email) throws InterruptedException {
        Object[] existingUser = userRepository.getUserByEmail(email);
        if (existingUser == null) {
            return false; // User does not exist
        }
        userRepository.deleteUserByEmail(email); // Delete old user
        return true;
    }

}