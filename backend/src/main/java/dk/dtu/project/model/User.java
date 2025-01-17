package dk.dtu.project.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    // constructor
    public User (Long id,String name, String email, String password){
        this.id=id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public Long getId(){return id;}
    public void setId(Long id){this.id =id;}
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String passwprd){
        this.password =passwprd;
    }

}
