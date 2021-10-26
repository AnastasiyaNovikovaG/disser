package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type_of_class", schema = "mydb", catalog = "")
public class TypeOfClass {
    private int id;
    private String name;
    private Collection<Logbook> logbooksById;
    private Collection<Plan> plansById;

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

        TypeOfClass that = (TypeOfClass) o;

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

    @OneToMany(mappedBy = "typeOfClassByIdType")
    public Collection<Logbook> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<Logbook> logbooksById) {
        this.logbooksById = logbooksById;
    }

    @OneToMany(mappedBy = "typeOfClassByIdType")
    public Collection<Plan> getPlansById() {
        return plansById;
    }

    public void setPlansById(Collection<Plan> plansById) {
        this.plansById = plansById;
    }
}
