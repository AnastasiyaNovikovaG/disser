package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RolesHasUsersPK implements Serializable {
    private int rolesId;
    private int usersId;

    @Column(name = "roles_id")
    @Id
    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    @Column(name = "users_id")
    @Id
    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesHasUsersPK that = (RolesHasUsersPK) o;

        if (rolesId != that.rolesId) return false;
        if (usersId != that.usersId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolesId;
        result = 31 * result + usersId;
        return result;
    }
}
