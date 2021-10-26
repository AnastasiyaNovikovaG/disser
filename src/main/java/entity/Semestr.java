package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Semestr {
    private int id;
    private Integer number;
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
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestr semestr = (Semestr) o;

        if (id != semestr.id) return false;
        if (number != null ? !number.equals(semestr.number) : semestr.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "semestrByIdSem")
    public Collection<Logbook> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<Logbook> logbooksById) {
        this.logbooksById = logbooksById;
    }

    @OneToMany(mappedBy = "semestrByIdSem")
    public Collection<Plan> getPlansById() {
        return plansById;
    }

    public void setPlansById(Collection<Plan> plansById) {
        this.plansById = plansById;
    }
}
