package novikava.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "semestr", schema = "mydb", catalog = "")
public class SemestrEntity {
    private int id;
    private Integer number;
    private Collection<MonthsEntity> monthsEntityById;

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

        SemestrEntity semestrEntity = (SemestrEntity) o;

        if (id != semestrEntity.id) return false;
        if (number != null ? !number.equals(semestrEntity.number) : semestrEntity.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "semestrBySemestrId", cascade=CascadeType.ALL)
    public Collection<MonthsEntity> getMonthsById() {
        return monthsEntityById;
    }

    public void setMonthsById(Collection<MonthsEntity> monthsEntityById) {
        this.monthsEntityById = monthsEntityById;
    }*/
}
