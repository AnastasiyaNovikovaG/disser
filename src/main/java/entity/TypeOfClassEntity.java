package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type_of_class", schema = "mydb", catalog = "")
public class TypeOfClassEntity {
    private int id;
    private String name;
    private Collection<LogbookEntity> logbooksById;
    private Collection<PlanEntity> plansById;

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

        TypeOfClassEntity that = (TypeOfClassEntity) o;

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
    public Collection<LogbookEntity> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<LogbookEntity> logbooksById) {
        this.logbooksById = logbooksById;
    }

    @OneToMany(mappedBy = "typeOfClassByIdType")
    public Collection<PlanEntity> getPlansById() {
        return plansById;
    }

    public void setPlansById(Collection<PlanEntity> plansById) {
        this.plansById = plansById;
    }
}
