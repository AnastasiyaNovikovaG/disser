package novikava.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles_has_users", schema = "mydb", catalog = "")
@IdClass(RolesHasUsersPK.class)
public class RolesHasUsers {
    private int rolesId;
    private int usersId;
    private int teacherId;
    private RolesEntity rolesByRolesEntityId;
    private UsersEntity usersByUsersEntityId;
  // private TeacherEntity teacherByTeacherEntityId;

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
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public RolesEntity getRolesByRolesId() {
        return rolesByRolesEntityId;
    }

    public void setRolesByRolesId(RolesEntity rolesByRolesEntityId) {
        this.rolesByRolesEntityId = rolesByRolesEntityId;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UsersEntity getUsersByUsersId() {
        return usersByUsersEntityId;
    }

    public void setUsersByUsersId(UsersEntity usersByUsersEntityId) {
        this.usersByUsersEntityId = usersByUsersEntityId;
    }

   /* @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public TeacherEntity getTeacherByTeacherId() {
        return teacherByTeacherEntityId;
    }

    public void setTeacherByTeacherId(TeacherEntity teacherByTeacherEntityId) {
        this.teacherByTeacherEntityId = teacherByTeacherEntityId;
    }*/
}
