package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Months {
    private int id;
    private String month;
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
    @Column(name = "month")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Months months = (Months) o;

        if (id != months.id) return false;
        if (month != null ? !month.equals(months.month) : months.month != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "monthsByMonthsId")
    public Collection<Logbook> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<Logbook> logbooksById) {
        this.logbooksById = logbooksById;
    }

    @OneToMany(mappedBy = "monthsByIdMonth")
    public Collection<Plan> getPlansById() {
        return plansById;
    }

    public void setPlansById(Collection<Plan> plansById) {
        this.plansById = plansById;
    }
}
