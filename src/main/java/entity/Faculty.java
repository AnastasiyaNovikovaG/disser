package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Faculty {
    private int id;
    private String name;
    private Collection<Department> departmentsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (id != faculty.id) return false;
        if (name != null ? !name.equals(faculty.name) : faculty.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<Department> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<Department> departmentsById) {
        this.departmentsById = departmentsById;
    }
}
