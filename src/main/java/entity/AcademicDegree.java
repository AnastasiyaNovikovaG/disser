package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "academic_degree", schema = "mydb")
public class AcademicDegree implements Comparable<AcademicDegree>{
    private int id;
    private String name;
    private Collection<Teacher> teachersById;

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

        AcademicDegree that = (AcademicDegree) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "academicDegreeByIdDegree")
    public Collection<Teacher> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<Teacher> teachersById) {
        this.teachersById = teachersById;
    }

    @Override
    public int compareTo(AcademicDegree o) {
        return 0;
    }
}
