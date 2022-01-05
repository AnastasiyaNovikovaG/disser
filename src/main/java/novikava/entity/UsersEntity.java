package novikava.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "mydb", catalog = "")
public class UsersEntity {


    private int id;

    private String email;
    private String password;
    private String username;
    private Collection<RolesHasUsers> rolesHasUsersById;

    public UsersEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername() {
        this.username = this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity usersEntity = (UsersEntity) o;

        if (id != usersEntity.id) return false;
        if (email != null ? !email.equals(usersEntity.email) : usersEntity.email != null) return false;
        if (password != null ? !password.equals(usersEntity.password) : usersEntity.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersId")
    public Collection<RolesHasUsers> getRolesHasUsersById() {
        return rolesHasUsersById;
    }

    public void setRolesHasUsersById(Collection<RolesHasUsers> rolesHasUsersById) {
        this.rolesHasUsersById = rolesHasUsersById;
    }

    public UsersEntity(String email, String password) {
        this.email = email;
        this.password = password;
        this.username = email;
    }
}
