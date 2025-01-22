package dk.dtu.project.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    // Getter cho email
    public String getEmail() {
        return email;
    }

    // Getter cho password
    public String getPassword() {
        return password;
    }

    // Setter (nếu cần)
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

