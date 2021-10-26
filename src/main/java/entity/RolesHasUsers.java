package entity;

import javax.persistence.*;

@Entity
@Table(name = "roles_has_users", schema = "mydb", catalog = "")
@IdClass(RolesHasUsersPK.class)
public class RolesHasUsers {
    private int rolesId;
    private int usersId;
    private int teacherId;
    private Roles rolesByRolesId;
    private Users usersByUsersId;
    private Teacher teacherByTeacherId;

    @Id
    @Column(name = "roles_id")
    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    @Id
    @Column(name = "users_id")
    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Basic
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesHasUsers that = (RolesHasUsers) o;

        if (rolesId != that.rolesId) return false;
        if (usersId != that.usersId) return false;
        if (teacherId != that.teacherId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolesId;
        result = 31 * result + usersId;
        result = 31 * result + teacherId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false)
    public Roles getRolesByRolesId() {
        return rolesByRolesId;
    }

    public void setRolesByRolesId(Roles rolesByRolesId) {
        this.rolesByRolesId = rolesByRolesId;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    public Users getUsersByUsersId() {
        return usersByUsersId;
    }

    public void setUsersByUsersId(Users usersByUsersId) {
        this.usersByUsersId = usersByUsersId;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public Teacher getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }
}
