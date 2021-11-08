package novikava.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonthsEntity {
    private int id;
    private String month;
    private int semestrId;

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

    @Basic
    @Column(name = "semestr_id")
    public int getSemestrId() {
        return semestrId;
    }

    public void setSemestrId(int semestrId) {
        this.semestrId = semestrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonthsEntity monthsEntity = (MonthsEntity) o;

        if (id != monthsEntity.id) return false;
        if (semestrId != monthsEntity.semestrId) return false;
        if (month != null ? !month.equals(monthsEntity.month) : monthsEntity.month != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + semestrId;
        return result;
    }
}
