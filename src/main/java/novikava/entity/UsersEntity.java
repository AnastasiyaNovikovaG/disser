package novikava.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UsersEntity {
    private int id;
    private String email;
    private String password;
    private Collection<RolesHasUsers> rolesHasUsersById;

    @Id
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

    @OneToMany(mappedBy = "usersByUsersId")
    public Collection<RolesHasUsers> getRolesHasUsersById() {
        return rolesHasUsersById;
    }

    public void setRolesHasUsersById(Collection<RolesHasUsers> rolesHasUsersById) {
        this.rolesHasUsersById = rolesHasUsersById;
    }
}
