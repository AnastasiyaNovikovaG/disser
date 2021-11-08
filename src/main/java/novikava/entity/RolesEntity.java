package novikava.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class RolesEntity {
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

        RolesEntity rolesEntity = (RolesEntity) o;

        if (id != rolesEntity.id) return false;
        if (role != null ? !role.equals(rolesEntity.role) : rolesEntity.role != null) return false;

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
