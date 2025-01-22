package service;
import dk.dtu.project.model.User;
import dk.dtu.project.service.UserService;
import dk.dtu.project.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_UserAlreadyExists_ThrowsException() throws InterruptedException {
        String email = "test@example.com";
        when(userRepository.getUserByEmail(email)).thenReturn(new Object[]{email, "Test User", "password"});

        Exception exception = assertThrows(RuntimeException.class, () ->
                userService.registerUser(email, "Test User", "password"));

        assertEquals("User already exists", exception.getMessage());
        verify(userRepository, times(1)).getUserByEmail(email);
    }

//    @Test
//    void registerUser_NewUser_SuccessfullyRegisters() throws Exception {
//        String email = "newuser@example.com";
//        String password = "password123";
//        String encryptedPassword = "$2a$10$hashedPassword";
//
//        when(userRepository.getUserByEmail(email)).thenReturn(null);
//        when(passwordEncoder.encode(password)).thenReturn(encryptedPassword);
//
//        userService.registerUser(email, "New User", password);
//
//        verify(userRepository, times(1)).registerUser(eq(email), eq("New User"), eq(encryptedPassword));
//    }


    @Test
    void authenticate_ValidCredentials_ReturnsUser() throws InterruptedException {
        String email = "test@example.com";
        String rawPassword = "password123";
        String encryptedPassword = new BCryptPasswordEncoder().encode(rawPassword);

        when(userRepository.getUserByEmail(email))
                .thenReturn(new Object[]{email, "Test User", encryptedPassword});

        User user = userService.authenticate(email, rawPassword);

        assertNotNull(user);
        assertEquals("Test User", user.getName()); // Update if name should be "Test User"
        assertEquals(email, user.getEmail());      // Add this if email needs validation
    }




//    @Test
//    void authenticate_InvalidCredentials_ReturnsNull() throws InterruptedException {
//        String email = "test@example.com";
//        String rawPassword = "wrongpassword";
//        String encryptedPassword = "$2a$10$hashedPassword";
//
//        when(userRepository.getUserByEmail(email))
//                .thenReturn(new Object[]{email, "Test User", encryptedPassword});
//        when(passwordEncoder.matches(rawPassword, encryptedPassword)).thenReturn(false);
//
//        User user = userService.authenticate(email, rawPassword);
//
//        assertNull(user);
//        verify(passwordEncoder, times(1)).matches(rawPassword, encryptedPassword);
//    }

    @Test
    void getUser_ExistingUser_ReturnsUser() throws InterruptedException {
        String email = "test@example.com";
        String name = "Test User";
        when(userRepository.getUserByEmail(email)).thenReturn(new Object[]{email, name, "encryptedPassword"});

        User user = userService.getUser(email);

        assertNotNull(user);
        assertEquals(email, user.getEmail());
        assertEquals("Test User", user.getName());
    }

    @Test
    void getUser_NonExistingUser_ReturnsNull() throws InterruptedException {
        String email = "nonexistent@example.com";
        when(userRepository.getUserByEmail(email)).thenReturn(null);

        User user = userService.getUser(email);

        assertNull(user);
    }

//    @Test
//    void updateUser_ExistingUser_UpdatesSuccessfully() throws InterruptedException {
//        String email = "test@example.com";
//        String updatedName = "Updated User";
//        String rawPassword = "newPassword123";
//        String encryptedPassword = "$2a$10$AM12ZR4Adz/ctCT7NpiwIuTxEGa5wu/dMnhN4OjgBJ6wXG4amtr.6";
//
//        User updatedUser = new User(email, updatedName,rawPassword);
//        when(userRepository.getUserByEmail(email)).thenReturn(new Object[]{email, "Old User", "oldpassword"});
//        when(passwordEncoder.encode(rawPassword)).thenReturn(encryptedPassword);
//        // Gọi phương thức updateUser
//        boolean result = userService.updateUser(email, updatedUser);
//
//        // Xác minh hành vi và kiểm tra kết quả
//        verify(userRepository, times(1)).deleteUserByEmail(email);
//        verify(userRepository, times(1)).registerUser(email, updatedName, encryptedPassword);
//        assertTrue(result);
//    }



    @Test
    void updateUser_NonExistingUser_ReturnsFalse() throws InterruptedException {
        String email = "nonexistent@example.com";
        User updatedUser = new User(null, email, "Updated User", "newpassword123");
        when(userRepository.getUserByEmail(email)).thenReturn(null);

        boolean result = userService.updateUser(email, updatedUser);

        assertFalse(result);
        verify(userRepository, never()).deleteUserByEmail(anyString());
        verify(userRepository, never()).registerUser(anyString(), anyString(), anyString());
    }

    @Test
    void deleteUser_ExistingUser_DeletesSuccessfully() throws InterruptedException {
        String email = "test@example.com";
        when(userRepository.getUserByEmail(email)).thenReturn(new Object[]{email, "Test User", "password"});

        boolean result = userService.deleteUser(email);

        assertTrue(result);
        verify(userRepository, times(1)).deleteUserByEmail(email);
    }

    @Test
    void deleteUser_NonExistingUser_ReturnsFalse() throws InterruptedException {
        String email = "nonexistent@example.com";
        when(userRepository.getUserByEmail(email)).thenReturn(null);

        boolean result = userService.deleteUser(email);

        assertFalse(result);
        verify(userRepository, never()).deleteUserByEmail(anyString());
    }
}