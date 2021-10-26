package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Roles {
    private int id;
    private String role;
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
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (id != roles.id) return false;
        if (role != null ? !role.equals(roles.role) : roles.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rolesByRolesId")
    public Collection<RolesHasUsers> getRolesHasUsersById() {
        return rolesHasUsersById;
    }

    public void setRolesHasUsersById(Collection<RolesHasUsers> rolesHasUsersById) {
        this.rolesHasUsersById = rolesHasUsersById;
    }
}
