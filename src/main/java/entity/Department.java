package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Department {
    private int id;
    private String name;
    private int facultyId;
    private Faculty facultyByFacultyId;
    private Collection<Logbook> logbooksById;

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

    @Basic
    @Column(name = "faculty_id")
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (facultyId != that.facultyId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + facultyId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    public Faculty getFacultyByFacultyId() {
        return facultyByFacultyId;
    }

    public void setFacultyByFacultyId(Faculty facultyByFacultyId) {
        this.facultyByFacultyId = facultyByFacultyId;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<Logbook> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<Logbook> logbooksById) {
        this.logbooksById = logbooksById;
    }
}
