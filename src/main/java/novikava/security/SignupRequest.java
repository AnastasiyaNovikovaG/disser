/*
package novikava.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

public class SignupRequest {

    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Collection<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(max = 50)
    private Integer id_teacher;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = this.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getRole() {
        return this.role;
    }

    public void setRole(Collection<String> role) {
        this.role = role;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

}
*/
